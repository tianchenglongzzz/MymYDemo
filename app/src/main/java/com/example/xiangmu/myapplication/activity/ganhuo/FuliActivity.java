package com.example.xiangmu.myapplication.activity.ganhuo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.xiangmu.myapplication.utils.ImgUtis;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import com.example.xiangmu.myapplication.R;
import com.example.xiangmu.myapplication.app.MyApp;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.greendao.ScBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FuliActivity extends SimpleActivity {

    private static final String TAG = "FuliActivity";
    private final String NAME = "福利";
    @BindView(R.id.simg_fuli)
    SimpleDraweeView mSimpleDraweeView;
    private String mName;
    private boolean mB;
    @BindView(R.id.fuli_toobar)
    Toolbar mToolbar;
    private List<ScBean> mList;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);

        setTooBar(mToolbar, "");
        Log.e("TAG", mName);
        ImgUtis.setFace(mName, mSimpleDraweeView, this);
    }

    @Override
    public void getIntgentData() {
        super.getIntgentData();
        Intent intent = getIntent();
        mName = intent.getStringExtra("name");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_fuli;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toobar_menu_fuli, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (MyApp.getSession() != null) {
            mList = MyApp.getSession().getScBeanDao().loadAll();
        }
        mB = false;
        Log.e(TAG, "onPrepareOptionsMenu: " + mName);
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getImgurl() != null && mList.get(i).getImgurl().equals(mName)) {
                mB = true;
            }
        }

        if (!mB) {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_n);
        } else {
            menu.getItem(0).setIcon(R.mipmap.ic_toolbar_like_p);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_like:
                if (mB) {
                    List<ScBean> scBeans = MyApp.getSession().getScBeanDao().loadAll();
                    for (int i = 0; i < scBeans.size(); i++) {
                        if (scBeans.get(i).getImgurl() != null && scBeans.get(i).getImgurl().equals(mName)) {
                            MyApp.getSession().getScBeanDao().delete(scBeans.get(i));
                        }
                    }
                    item.setIcon(R.mipmap.ic_toolbar_like_n);
                    mB = false;
                } else {
                    MyApp.getSession().getScBeanDao().insert(new ScBean(null, null, 0, null, NAME, mName));
                    mB = true;
                    item.setIcon(R.mipmap.ic_toolbar_like_p);
                }
                break;
            case R.id.action_copy:
                Bitmap bitmap = returnBitMap(mName);
                saveImageToGallery(this,bitmap);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public static void saveImageToGallery(Context context, Bitmap bmp) {
            // 首先保存图片
            File appDir = new File(Environment.getExternalStorageDirectory(), "Boohee");
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                Log.e(TAG, "saveImageToGallery: "+bmp );
                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(),
                        file.getAbsolutePath(), fileName, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // 最后通知图库更新
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(file.getAbsolutePath())));


    }
    Bitmap bitmap;
    public Bitmap returnBitMap(final String url){

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageurl = null;

                try {
                    imageurl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return bitmap;
    }



}