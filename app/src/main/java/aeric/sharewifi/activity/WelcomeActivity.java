package aeric.sharewifi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import aeric.sharewifi.R;
import aeric.sharewifi.util.SelectorFactory;
import base.BaseActivity;
import butterknife.Bind;
import butterknife.OnClick;

import static android.graphics.Color.GRAY;

/**
 * 欢迎页
 *
 * @author LZQ
 */
public class WelcomeActivity extends BaseActivity {

    @Bind(R.id.httpBtn)
    Button httpBtn;
    @Bind(R.id.uploadImgBtn)
    Button uploadImgBtn;
    @Bind(R.id.uploadFileBtn)
    Button uploadFileBtn;
    @Bind(R.id.downloadBtn)
    Button downloadBtn;
    @Bind(R.id.downloadPointBtn)
    Button downloadPointBtn;
    @Bind(R.id.mainactivity2Btn)
    Button mainactivity2Btn;

    @Override
    protected int initLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置按钮圆角样式
        SelectorFactory.newShapeSelector()
                .setStrokeWidth(2)
                .setCornerRadius(15)
                .setDefaultStrokeColor(GRAY)
                .setDefaultBgColor(getResources().getColor(R.color.wihte))
                .setPressedBgColor(getResources().getColor(R.color.light_blue))
                .bind(httpBtn)
                .bind(uploadImgBtn)
                .bind(uploadFileBtn)
                .bind(downloadBtn)
                .bind(downloadPointBtn)
                .bind(mainactivity2Btn);
    }

    @OnClick({R.id.httpBtn, R.id.uploadImgBtn, R.id.uploadFileBtn, R.id.downloadBtn, R.id.downloadPointBtn,R.id.mainactivity2Btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.httpBtn:
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                break;
            case R.id.uploadImgBtn:
                startActivity(new Intent(WelcomeActivity.this, UploadImageActivity.class));
                break;
            case R.id.uploadFileBtn:
                startActivity(new Intent(WelcomeActivity.this, UploadFileActivity.class));
                break;
            case R.id.downloadBtn:
                startActivity(new Intent(WelcomeActivity.this, DownloadActivity.class));
                break;
            case R.id.downloadPointBtn:
                startActivity(new Intent(WelcomeActivity.this, DownloadBreakpointsActivity.class));
                break;
            case R.id.mainactivity2Btn:
                startActivity(new Intent(WelcomeActivity.this, Main2Activity.class));
                break;
        }
    }

}
