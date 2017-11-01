package aeric.sharewifi.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;
import com.okhttplib.annotation.RequestType;
import com.okhttplib.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import aeric.sharewifi.R;
import aeric.sharewifi.bean.Areas;
import aeric.sharewifi.util.SelectorFactory;
import aeric.sharewifi.util.ToastUtil;
import base.BaseActivity;
import butterknife.Bind;
import butterknife.OnClick;

import static aeric.sharewifi.R.id.resultTV;
import static android.graphics.Color.GRAY;

public class Main2Activity extends BaseActivity {


    @Bind(R.id.httpBtn)
    Button mHttpBtn;
    @Bind(resultTV)
    TextView mResultTV;
    @Bind(R.id.dataTV)
    TextView mDataTV;

    private boolean isNeedDeleteCache = true;

    @Override
    protected int initLayout() {
        return R.layout.activity_main2;
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
                .bind(mHttpBtn)
                .bind(mDataTV)
                .bind(mResultTV);

    }

    @OnClick({R.id.httpBtn, resultTV})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.httpBtn:
                async();
                break;
            case resultTV:
                break;
        }
    }


    /**
     * 异步请求：回调方法可以直接操作UI
     */
    private void async() {
        String url = "http://www.airnearby.com/api/areas/v1";
        doHttpAsync(HttpInfo.Builder()
                        .setUrl(url)
                        .setRequestType(RequestType.GET)//设置请求方式
//                        .addHead("head", "test")//添加头参数
//                        .addParam("param", "test")//添加接口参数
                        .setDelayExec(1, TimeUnit.SECONDS)//延迟2秒执行
                        .build(),
                new Callback() {
                    @Override
                    public void onFailure(HttpInfo info) throws IOException {
                        String result = info.getRetDetail();
                        mResultTV.setText("异步请求失败：" + result);
                    }

                    @Override
                    public void onSuccess(HttpInfo info) throws IOException {
                        String result = info.getRetDetail();
                        mResultTV.setText("异步请求成功：" + result);
                        List<Areas> areas=new ArrayList<Areas>();
                        String s = "";
                        //GSon解析
                        try{
                            JSONObject object=new JSONObject(result);
                            int code=object.getInt("code");
                            JsonParser parser=new JsonParser();
                            JsonObject obj= parser.parse(result).getAsJsonObject();
                            Gson gson=new Gson();
                            JsonArray array = obj.getAsJsonArray("data");

                            if (code == 0) {
                                Type type = (Type) new TypeToken<Areas>(){}.getType();
                                for (int i = 0; i < array.size(); i++) {
                                    JsonElement j = array.get(i);
                                    Areas area = gson.fromJson(j, type);
                                    s = s+"id"+area.getId()+"name"+area.getName();
                                    areas.add(area);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mDataTV.setText(s);
                    }
                });
        needDeleteCache(true);
    }

    private void needDeleteCache(boolean delete) {
        isNeedDeleteCache = delete;
    }


    /**
     * 清理缓存
     */
    private void deleteCache() {
        if (OkHttpUtil.getDefault().deleteCache()) {
            ToastUtil.show(this, "清理缓存成功");
        } else {
            ToastUtil.show(this, "清理缓存失败");
        }
    }
}
