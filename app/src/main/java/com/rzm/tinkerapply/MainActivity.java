package com.rzm.tinkerapply;

import android.Manifest;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvBug = findViewById(R.id.tv_bug);
        tvBug.setText("---------修改了内容");
        requestPermission();
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        TinkerInstaller.onReceiveUpgradePatch(getApplication().getApplicationContext(),
                Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
        Toast.makeText(getApplicationContext(),"修复",Toast.LENGTH_SHORT).show();
    }
}
