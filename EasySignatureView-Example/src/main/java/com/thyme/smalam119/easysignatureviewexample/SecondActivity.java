package com.thyme.smalam119.easysignatureviewexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        prepareView();
    }

    private void prepareView() {
        byte[] bytes = getIntent().getByteArrayExtra(getResources().getString(R.string.key_signature_byte_intent));
        //converting bytes to bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        //converting bitmap to drawable
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageDrawable(drawable);
        Log.d("bytes",bytes.length + "");
    }
}
