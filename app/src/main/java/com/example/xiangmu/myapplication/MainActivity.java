package com.example.xiangmu.myapplication;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.example.xiangmu.myapplication.base.activity.BaseActivity;
import com.example.xiangmu.myapplication.base.activity.SimpleActivity;
import com.example.xiangmu.myapplication.fragment.ZhiHuFragment;
import com.example.xiangmu.myapplication.fragment.man.GanHoFrement;
import com.example.xiangmu.myapplication.fragment.man.GuanyuFrement;
import com.example.xiangmu.myapplication.fragment.man.ShezhiFrment;
import com.example.xiangmu.myapplication.fragment.man.ShouChangFrement;
import com.example.xiangmu.myapplication.fragment.man.SujuFrement;
import com.example.xiangmu.myapplication.fragment.man.V2exFrement;
import com.example.xiangmu.myapplication.fragment.man.WeiXiFrement;
import com.example.xiangmu.myapplication.presenter.ZhihuPresenter;
import com.example.xiangmu.myapplication.view.ZhiZuView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends SimpleActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.toolbar)
    Toolbar mToolbarMain;
   @BindView(R.id.dw)
    DrawerLayout mDrawerLayout;
   @BindView(R.id.tv_toobar)
    TextView tv;
   @BindView(R.id.fab1)
   FloatingActionButton fab;

    private WeiXiFrement mWeiXiFrement;
    private GanHoFrement mGanHoFrement;
    private SujuFrement mSujuFrement;
    private V2exFrement mV2exFrement;
    private ShouChangFrement mShouChangFrement;
    private ShezhiFrment mShezhiFrment;
    private GuanyuFrement mGuanyuFrement;
    //这里是msw就是 干货集中营和微信的布尔值  如果干货可见就是flase，如果微信可见就是true
    private boolean mSw;
    private ZhiHuFragment mZhiHuFragment;
    private MenuItem mItem1;

    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        mWeiXiFrement = new WeiXiFrement();
        mGanHoFrement = new GanHoFrement();
        mSujuFrement = new SujuFrement();

        mShouChangFrement = new ShouChangFrement();
        mShezhiFrment = new ShezhiFrment();
        mGuanyuFrement = new GuanyuFrement();
        mZhiHuFragment = new ZhiHuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.lint,mZhiHuFragment).commit();

    }

    @Override
    public void getIntgentData() {
        super.getIntgentData();
        fab.setVisibility(View.GONE);
        sheToobar(mToolbarMain,"知乎日报");
        // mToolbarMain.getMenu().getItem(1).setVisible(true);
        ZhiHuFragment zhiHuFragment = new ZhiHuFragment();
        //获取侧滑布局的Menu
        Menu menu = mNv.getMenu();
        //通过menu获取对应的Menitem对象
        mItem1 =  menu.findItem(R.id.drawer_zhihu);
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {



            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
/*
* 当点每一个Menuitem的时候就把刚开始的知乎给设置成faseMenuitem
* */
                switch (item.getItemId()){
                    case  R.id.drawer_zhihu:
                        transaction.replace(R.id.lint,new ZhiHuFragment() );
                        sheToobar(mToolbarMain,"知乎日报");
                        transaction.commit();
                        item.setChecked(true);
                        //设置侧滑菜单隐藏
                        clostChehua();
                        //mToolbarMain.getMenu().getItem(1).setVisible(false);
                        break;
                    case  R.id.drawer_wechat:
                        visible=true;
                        //这里是msw就是 干货集中营和微信的布尔值  如果干货可见就是flase，如果微信可见就是true
                        mSw = true;
                        transaction.replace(R.id.lint,mWeiXiFrement);
                        // mToolbarMain.getMenu().getItem(1).setVisible(true);
                        sheToobar(mToolbarMain,"微信精选");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();

                        break;
                    case  R.id.drawer_gank:
                        visible=true;
                        //这里是msw就是 干货集中营和微信的布尔值  如果干货可见就是flase，如果微信可见就是true
                        mSw = false;
                        // mToolbarMain.getMenu().getItem(1).setVisible(false);
                        //这里做了一个重新赋值
                        //因为切换到其它的Frement会有页面滞空的状态
                        mGanHoFrement=new GanHoFrement();
                        transaction.replace(R.id.lint,mGanHoFrement);
                        sheToobar(mToolbarMain,"干货集中营");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();
                        break;
                    case  R.id.drawer_gold:

                        // mToolbarMain.getMenu().getItem(1).setVisible(false);
                        mSujuFrement=new SujuFrement();
                        transaction.replace(R.id.lint,mSujuFrement);
                        sheToobar(mToolbarMain,"稀土掘金");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();
                        break;
                    case  R.id.drawer_vtex:
                        // mToolbarMain.getMenu().getItem(1).setVisible(false);
                        transaction.replace(R.id.lint, new V2exFrement());
                        sheToobar(mToolbarMain,"V2EX");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();
                        break;
                    case  R.id.drawer_like:
                        // mToolbarMain.getMenu().getItem(1).setVisible(false);
                        item.setChecked(true);
                        transaction.replace(R.id.lint,mShouChangFrement);
                        sheToobar(mToolbarMain,"收藏");
                        transaction.commit();
                        mItem1.setChecked(false);
                        clostChehua();
                        break;
                    case  R.id.drawer_setting:
                        //mToolbarMain.getMenu().getItem(1).setVisible(false);
                        transaction.replace(R.id.lint,mShezhiFrment);
                        sheToobar(mToolbarMain,"设置");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();
                        break;
                    case  R.id.drawer_about:
                        // mToolbarMain.getMenu().getItem(1).setVisible(false);
                        transaction.replace(R.id.lint,mGuanyuFrement);
                        sheToobar(mToolbarMain,"关于");
                        transaction.commit();
                        item.setChecked(true);
                        mItem1.setChecked(false);
                        clostChehua();
                        break;

                }
                return  true;
            }

        });

    }
  //设置侧滑菜单隐藏
    private void clostChehua() {
        mDrawerLayout.closeDrawer(mNv);
    }


    @Override
    protected void initData() {

    }
    //onPrepareOptionsMenu

    boolean visible=false;
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.getItem(0).setVisible(visible);
        visible=false;
        return super.onPrepareOptionsMenu(menu);
    }

    protected void sheToobar(Toolbar toolbar, String title) {
         tv.setText(title);
         toolbar.setTitle("");
        setSupportActionBar(mToolbarMain);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,mToolbarMain, R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
              //这里是msw就是 干货集中营和微信的布尔值  如果干货可见就是flase，如果微信可见就是true
                if (mSw) {
                    //通过调用对象的方式把搜索框对应的参数传入进去
                    mWeiXiFrement.setQuery(query);
                }else {
                   // 通过调用对象的方式把搜索框对应的参数传入进去
                    Log.e(TAG, "onQueryTextSubmit: " );
                    mGanHoFrement.setQuery(query);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Log.i(TAG,"back");
            Toast.makeText(this,"back",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @OnClick({R.id.nv, R.id.toolbar, R.id.dw})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.nv:
                break;
            case R.id.toolbar:
                break;
            case R.id.dw:
                break;
        }
    }



}
