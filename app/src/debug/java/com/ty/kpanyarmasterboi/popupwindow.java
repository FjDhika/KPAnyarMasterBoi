package com.ty.kpanyarmasterboi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.VideoView;

public class popupwindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);

        VideoView vidview = findViewById(R.id.videoview);
        String str = "https://firebasestorage.googleapis.com/v0/b/reference-unity-247807.appspot.com/o/sounds%2FOzzy%20Ozone.mp4?alt=media&token=0ed6a93e-c53e-49f0-894d-43539af0e5d0";
        Uri uri = Uri.parse(str);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int) (height*.6));

        vidview.setVideoURI(uri);
        vidview.requestFocus();
        vidview.start();
    }
}
