package com.example.lenovo.clicktoexpandtextview;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.lenovo.clicktoexpandtextview.util.Utils;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShow;
    final String str = "我有一只小毛驴，我从来也不骑~有一天我心血来潮骑它去\n" +
            "赶集，我手里拿着小皮鞭，我心里正得意~不知怎么哗啦啦啦\n" +
            "啦，我摔了一身泥";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShow = (TextView) findViewById(R.id.TvShow);
        //调用 toggleEllipsize 方法来设置 mTv
        Utils.toggleEllipsize(mTvShow,str);
    }

}
