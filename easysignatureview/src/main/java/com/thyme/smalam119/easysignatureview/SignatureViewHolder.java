package com.thyme.smalam119.easysignatureview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by smalam119 on 12/25/17.
 */

class SignatureViewHolder extends RelativeLayout {
    private View mRootView, mCancelButton, mDoneButton;
    private View mCrossButton;
    private TextView mSubTitleTextView, mDateTimeTextView;
    private SignatureView mSignatureView;
    private Context mContext;
    public OnSignatureViewHolderInteraction onSignatureViewHolderInteraction;

    public SignatureViewHolder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        prepareView(context);
    }

    public SignatureViewHolder(Context context) {
        super(context);
        mContext = context;
        prepareView(context);
    }

    public void setSubTitleText(String text) {
        mSubTitleTextView.setText(text);
    }

    public String getSubtitleText(){
        return mDateTimeTextView.getText().toString();
    }

    private String getDateTimeString() {
        Date currentTime = Calendar.getInstance().getTime();
        String stringDate = DateFormat.getDateInstance().format(currentTime);
        return stringDate;
    }

    public Date getDate(){
        return Calendar.getInstance().getTime();
    }

    public void clearSignatureView() {
        mSignatureView.clearCanvas();
        mSignatureView.setDrawingCacheEnabled(false);
    }

    private Bitmap getSignatureBitmap() {
        mSignatureView.setDrawingCacheEnabled(true);
        Bitmap bitmap = mSignatureView.getDrawingCache();
        return bitmap;
    }

    private void prepareView(Context context) {
        mRootView = inflate(context, R.layout.signature_view_container_view, this);
        mCancelButton = (View) mRootView.findViewById(R.id.cancel_button);
        mCancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignatureViewHolderInteraction.onCancelButtonClicked();
            }
        });
        mDoneButton = (View) mRootView.findViewById(R.id.done_button);
        mDoneButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignatureViewHolderInteraction.onDoneButtonClicked(getSignatureBitmap());
                mSignatureView.setDrawingCacheEnabled(false);
            }
        });
        mCrossButton = (View) mRootView.findViewById(R.id.cross_button);
        mCrossButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSignatureView();
            }
        });
        mSubTitleTextView = (TextView) mRootView.findViewById(R.id.term_condition_text_text_view);
        mDateTimeTextView = (TextView) mRootView.findViewById(R.id.date_time_text_view);
        mSignatureView = (SignatureView) mRootView.findViewById(R.id.signature_view);
        mDateTimeTextView.setText(getDateTimeString());
    }
}
