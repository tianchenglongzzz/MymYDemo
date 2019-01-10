package com.example.xiangmu.myapplication.activity;

        import android.content.Intent;
        import android.graphics.BitmapFactory;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.drawable.Drawable;
        import android.net.Uri;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import com.example.xiangmu.myapplication.MainActivity;
        import com.example.xiangmu.myapplication.R;
        import com.facebook.drawee.view.SimpleDraweeView;

        import butterknife.BindView;

public class StartActivity extends AppCompatActivity {

    SimpleDraweeView mSimpleDraweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                 startActivity(new Intent(StartActivity.this,MainActivity.class));
            finish();
            }
        },2000);

    }
}
