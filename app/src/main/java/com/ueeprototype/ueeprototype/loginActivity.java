package com.ueeprototype.ueeprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    private static final float BLUR_RADIUS = 25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ImageView bgImage = (ImageView) findViewById(R.id.loginImageBG);

        //bgImage.setImageBitmap(blur());

    }
/*
    public Bitmap blur() {

        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.sliit_login_image);

        if (null == image) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(image);
        final RenderScript renderScript = RenderScript.create(this);
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);

        //Intrinsic Gausian blur filter
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }
*/
}
