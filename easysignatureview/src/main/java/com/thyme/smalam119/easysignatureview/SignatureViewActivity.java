package com.thyme.smalam119.easysignatureview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.Date;

public abstract class SignatureViewActivity extends AppCompatActivity implements OnSignatureViewHolderInteraction {
    private SignatureViewHolder mSignatureViewHolder;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature_view);
        mSignatureViewHolder = (SignatureViewHolder) findViewById(R.id.signature_view_holder_main);
        mSignatureViewHolder.onSignatureViewHolderInteraction = this;

        //get date from the signature view
        date = mSignatureViewHolder.getDate();
        Log.d("date",date.toString());
    }

    private byte[] bitmapToDrawable(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;
    }

    public void setSubText(String subText) {
        mSignatureViewHolder.setSubTitleText(subText);
    }

    public abstract void onClickDone(Bitmap bitmap);
    public abstract void onClickDone(byte[] bytes);
    public abstract void onClickCancel();

    @Override
    public void onCancelButtonClicked() {
        onClickCancel();
    }

    @Override
    public void onDoneButtonClicked(Bitmap bitmap) {
        onClickDone(bitmap);
        onClickDone(bitmapToDrawable(bitmap));
    }
}
