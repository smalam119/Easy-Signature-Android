package com.thyme.smalam119.easysignatureviewexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import com.thyme.smalam119.easysignatureview.SignatureView;
import com.thyme.smalam119.easysignatureview.SignatureViewActivity;

/**
 * Created by smalam119 on 12/25/17.
 */

public class DemoSignatureViewController extends SignatureViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setSubText("I accept the nothingness and meaninglessness of life");
        Log.d("onCreate", "called");
    }

    //call back for done button click. returns bitmap
    @Override
    public void onClickDone(Bitmap bitmap) {
    }

    //call back for done button click. returns array of byte
    @Override
    public void onClickDone(byte[] bytes) {
        gotoSecondActivity(bytes);
    }

    //callback for cancel button click
    @Override
    public void onClickCancel() {
        this.finish();
    }

    private void gotoSecondActivity(byte[] bytes) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(getResources().getString(R.string.key_signature_byte_intent), bytes);
        startActivity(intent);
    }

}
