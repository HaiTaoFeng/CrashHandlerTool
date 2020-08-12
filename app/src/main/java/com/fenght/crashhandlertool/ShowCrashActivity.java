package com.fenght.crashhandlertool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class ShowCrashActivity extends AppCompatActivity {
    private String path = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_show);
        TextView tv_text= findViewById(R.id.tv_text);
        Intent intent = getIntent();
        if (intent != null) {
            path = getIntent().getStringExtra("path");
        }
        if ("".equals(path) || path == null) {
            tv_text.setText("找不到崩溃日志文件，请检查是否开启文件读写权限！");
           return;
        }
        StringBuffer sb = new StringBuffer();
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = br.readLine())!=null){
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        tv_text.setText(sb.toString());
    }
}
