package com.example.lenovo.clicktoexpandtextview;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShow;
    final String desc = "我有一只小毛驴，我从来也不骑~有一天我心血来潮骑它去\n" +
            "赶集，我手里拿着小皮鞭，我心里正得意~不知怎么哗啦啦啦\n" +
            "啦，我摔了一身泥";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShow = (TextView) findViewById(R.id.TvShow);
        //去除点击图片后的背景色（ SpannableString 在点击时会使背景变色 ，填上这句则可不变色 ）
        mTvShow.setHighlightColor(Color.TRANSPARENT);

        //添加 TextView 的高度监听
        mTvShow.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int paddingLeft = mTvShow.getPaddingLeft();
                int paddingRight = mTvShow.getPaddingRight();
                TextPaint paint = mTvShow.getPaint();
                float moreText = mTvShow.getTextSize() * 3;
                float availableTextWidth = (mTvShow.getWidth() - paddingLeft - paddingRight) * 2 - moreText;
                CharSequence ellipsizeStr = TextUtils.ellipsize(desc,paint,availableTextWidth,TextUtils.TruncateAt.END);

                // TextView 实际显示的文本长度  < 应该显示文本的长度(收缩状态)
                if(ellipsizeStr.length() < desc.length()){
                    //openFun(mTvShow, ellipsizeStr, desc);//显示收缩状态的文本和图标
                }
                // TextView 实际显示的文本长度  == 应该显示文本的长度(正常状态)
                else if(ellipsizeStr.length() == desc.length()){
                    mTvShow.setText(desc);//正常显示Textview
                }
                // TextView 实际显示的文本长度  > 应该显示文本的长度(展开状态)
                else{
                    //closeFun(mTvShow, ellipsizeStr, desc);//显示展开状态的文本和图标
                }

                if(Build.VERSION.SDK_INT>=16){
                    mTvShow.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }else{
                    mTvShow.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }
}
