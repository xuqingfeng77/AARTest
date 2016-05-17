package com.eposp.aartest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.cropper.ui.ActivityCapture;
import com.cropper.ui.AssetsAct;

import java.io.File;
import java.util.Date;

/**
 * 生成aar文件
 */
public class MainActivity extends AppCompatActivity {
private Context mContext;
    public static final String ROOT = android.os.Environment
            .getExternalStorageDirectory()
            + File.separator
            +"aartest"
            + File.separator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void BtnClick(View v){
        setSelfCamera();
    }
    public void BtnAssetsClick(View v){
        intentAssets();
    }
    /**
     * 启动自定义相机
     */
    protected void setSelfCamera() {
        File fileCamera = new File(ROOT, "userinfos");
        if (!fileCamera.exists()) {
            fileCamera.mkdirs();
        }
        File file = new File(fileCamera, new Date().getTime() + ".png");
        Intent intent1 = new Intent(mContext, ActivityCapture.class);
        intent1.putExtra("path",file.getPath());
        startActivityForResult(intent1, 111);
    }
    private void intentAssets(){
        Intent intent =new Intent (mContext, AssetsAct.class);
        startActivity(intent);
    }
}
