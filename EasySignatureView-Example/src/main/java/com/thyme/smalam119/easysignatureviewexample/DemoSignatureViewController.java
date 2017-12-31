package com.thyme.smalam119.easysignatureviewexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.thyme.smalam119.easysignatureview.SignatureViewActivity;
import java.util.Date;

/**
 * Created by smalam119 on 12/25/17.
 */

public class DemoSignatureViewController extends SignatureViewActivity {
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setSubText("I accept the nothingness and meaninglessness of life");

    }

    //call back for done button click. returns bitmap
    @Override
    public void onClickDone(Bitmap bitmap) {
    }

    //call back for done button click. returns array of byte
    @Override
    public void onClickDone(byte[] bytes) {
        date = this.getDate();
        Log.d("date_from_demo",date.toString());
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
