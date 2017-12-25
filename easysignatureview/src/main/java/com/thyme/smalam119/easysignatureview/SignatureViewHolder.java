package com.thyme.smalam119.easysignatureview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by smalam119 on 12/25/17.
 */

public class SignatureViewHolder extends RelativeLayout {
    private View mRootView, mCancelButton, mDoneButton;
    private View mCrossButton;
    private TextView subTitleTextView;
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
        subTitleTextView.setText(text);
    }

    private void clearSignatureView() {
        mSignatureView.clearCanvas();
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
            }
        });
        mCrossButton = (View) mRootView.findViewById(R.id.cross_button);
        mCrossButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSignatureView();
            }
        });
        subTitleTextView = (TextView) mRootView.findViewById(R.id.term_condition_text_text_view);
        mSignatureView = (SignatureView) mRootView.findViewById(R.id.signature_view);
    }
}
