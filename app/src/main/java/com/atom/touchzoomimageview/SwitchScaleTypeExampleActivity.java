package com.atom.touchzoomimageview;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class SwitchScaleTypeExampleActivity extends Activity {

    private TouchImageView image;
    private Activity activity;
    private TextView tvScaletype;
    private static final ScaleType[] scaleTypes = {ScaleType.CENTER, ScaleType.CENTER_CROP, ScaleType.CENTER_INSIDE, ScaleType.FIT_XY, ScaleType.FIT_CENTER, ScaleType.MATRIX};
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_scaletype_example);
        activity = this;
        image = (TouchImageView) findViewById(R.id.img);
        tvScaletype = (TextView) findViewById(R.id.tv_scaletype);

        //
        // Set next scaleType with each button click
        //
        image.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                index = ++index % scaleTypes.length;
                ScaleType currScaleType = scaleTypes[index];
                image.setScaleType(currScaleType);
                tvScaletype.setText("ScaleType: " + currScaleType);
            }
        });
    }

}
