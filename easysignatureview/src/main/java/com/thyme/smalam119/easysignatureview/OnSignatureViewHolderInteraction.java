package com.thyme.smalam119.easysignatureview;

import android.graphics.Bitmap;

/**
 * Created by smalam119 on 12/25/17.
 */

public interface OnSignatureViewHolderInteraction {
    void onCancelButtonClicked();
    void onDoneButtonClicked(Bitmap bitmap);
}
