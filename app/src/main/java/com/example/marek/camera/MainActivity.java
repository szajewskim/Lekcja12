package com.example.marek.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;

    private int fileUri;
    private int fileUri2;

    Intent intent;
    Intent intent2;
    File imageFile;
    File image;
    File video;
    String timeStamp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent2 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        imageFile = new File(Environment.getExternalStorageDirectory(), "Documents");
        imageFile.mkdirs();
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        image = new File(imageFile, "test"+timeStamp+".jpg");
        video = new File(imageFile, "test"+timeStamp+",avi");

        Uri uriSavedImage = Uri.fromFile(image);
        Uri uriSAvedVideo = Uri.fromFile(video);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
        intent2.putExtra(MediaStore.EXTRA_OUTPUT, uriSAvedVideo);

        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        startActivityForResult(intent2, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
    }
}
