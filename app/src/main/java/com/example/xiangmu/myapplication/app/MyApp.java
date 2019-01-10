package com.example.xiangmu.myapplication.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatDelegate;


/*import com.example.xiangmu.myapplication.greendao.DaoMaster;
import com.example.xiangmu.myapplication.greendao.DaoSession;*/
import com.example.xiangmu.myapplication.greedao.DaoMaster;
import com.example.xiangmu.myapplication.greedao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

/**
 * @packge: com.example.xiangmu.myapplication.app
 * @filename:MyApp
 * @date :${DATA} 11:53
 */

public class MyApp extends Application {
    private    static   MyApp sMyApp;
   private  static DaoSession mDaoSession;
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;private DaoSession mDaoSession1;


    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp=this;
        Fresco.initialize(this);

        LeakCanary.install(this);
        SharedPreferences cc = this.getSharedPreferences("cc", MODE_PRIVATE);
        boolean name = cc.getBoolean("name", true);
        setNightMode(name);
        getDaoBean();
    }
   public static  MyApp getMyApp(){
        return  sMyApp;

   }
    private void getDaoBean() {

        if (mDaoSession==null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(sMyApp, "My.db");
            SQLiteDatabase database = helper.getReadableDatabase();
            DaoMaster master = new DaoMaster(database);
            mDaoSession = master.newSession();

        }





    }
    public static DaoSession getSession(){
        return mDaoSession;
    }
    private void setNightMode(boolean name) {
      if (name) {
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
      }else {
          AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
      }
      }



}
