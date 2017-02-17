package com.example.arthur.demoqc4;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.arthur.demoqc4.models.ReturnDataResponse;
import com.example.arthur.demoqc4.retrofit.ApiStores;
import com.example.arthur.demoqc4.retrofit.AppClient;
import com.example.arthur.demoqc4.retrofit.RetrofitCallback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private ArrayList<Fragment> fragments;
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_main_demo);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
//        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
//                .setFirstSelectedPosition(0)
//                .initialise();

//        fragments = getFragments();
//        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
        loadDataByRetrofit();
    }


    /** * 设置默认的 */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, HomeFragment.newInstance("Home"));
        transaction.commit();
    }

    private ArrayList<Fragment> getFragments(List<UISettingsResponse.MainTabBarLayout.MainTabBars> list) {
        Map<String,Fragment> map = new HashMap<>();
        map.put("PageNews",HomeFragment.newInstance("Home"));
        map.put("PageService",HomeFragment.newInstance("Books"));
        map.put("PageTao",HomeFragment.newInstance("Games"));
        map.put("PageFind",HomeFragment.newInstance("Music"));
        map.put("PageYou",HomeFragment.newInstance("Movies"));
        map.put("PageMy",HomeFragment.newInstance("TV"));

        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            fragments.add(map.get(list.get(i).getViewId()));
        }

        return fragments;
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.layFrame, fragment);
                } else {
                    ft.add(R.id.layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    public ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);


    private void loadDataByRetrofit() {
//        final List<UISettingsResponse.MainTabBarLayout.MainTabBars> list = model.getData().getUISettings().getMainTabBarLayout()
//                .getMainTabBars();
        int[] imgs = {R.mipmap.ic_book_white_24dp,R.mipmap.ic_tv_white_24dp,R.mipmap.ic_music_note_white_24dp,R.mipmap.ic_home_white_24dp};
//                    for (int i = 0; i < list.size(); i++){
//                        final String name = list.get(i).getName();
//                        final String url = list.get(i).getIconUrl();
//                        new DownloadImageTask().execute(IMAGE_URL) ;
//                        bottomNavigationBar.addItem(new BottomNavigationItem(imgs[i], name)
//                                .setActiveColorResource(R.color.teal)).setInActiveColor(R.color.colorAccent);
//                    }
//                    bottomNavigationBar.setFirstSelectedPosition(0);
//                    bottomNavigationBar.initialise();
//                    fragments = getFragments(list);
//                    setDefaultFragment();
//        new DownloadImageTask(list).execute() ;
//        showProgressDialog();
//        Call<ReturnDataResponse<NewsPaperGroupResponse>> call = apiStores.getnewspapergroup(9999);
//        call.enqueue(new RetrofitCallback<ReturnDataResponse<NewsPaperGroupResponse>>() {
//                @Override
//                public void onSuccess(ReturnDataResponse<NewsPaperGroupResponse> model) {
////                dataSuccess(model);
//                    Toast.makeText(MainActivity.this,model.getData().getUISettings().getMainTabBarLayout()
//                            .getMainTabBars().get(0).getName()+"~~~~~~~~~",Toast.LENGTH_SHORT).show();
//                    final List<UISettingsResponse.MainTabBarLayout.MainTabBars> list = model.getData().getUISettings().getMainTabBarLayout()
//                            .getMainTabBars();
//                    int[] imgs = {R.mipmap.ic_book_white_24dp,R.mipmap.ic_tv_white_24dp,R.mipmap.ic_music_note_white_24dp,R.mipmap.ic_home_white_24dp};
////                    for (int i = 0; i < list.size(); i++){
////                        final String name = list.get(i).getName();
////                        final String url = list.get(i).getIconUrl();
////                        new DownloadImageTask().execute(IMAGE_URL) ;
////                        bottomNavigationBar.addItem(new BottomNavigationItem(imgs[i], name)
////                                .setActiveColorResource(R.color.teal)).setInActiveColor(R.color.colorAccent);
////                    }
////                    bottomNavigationBar.setFirstSelectedPosition(0);
////                    bottomNavigationBar.initialise();
////                    fragments = getFragments(list);
////                    setDefaultFragment();
//                    new DownloadImageTask(list).execute() ;
//                }
//
//            @Override
//            public void onFailure(int code, String msg){
////                    toastShow(msg);
//                Toast.makeText(MainActivity.this,msg+"======",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onThrowable(Throwable t) {
////                toastShow(t.getMessage());
//                Toast.makeText(MainActivity.this,t.getMessage()+"------",Toast.LENGTH_SHORT).show();
//                Log.e("MainActivity",t.getMessage());
//            }
//
//            @Override
//            public void onFinish() {
//
////                dismissProgressDialog();
//            }
//        });
////        addCalls(call);
    }

    private Drawable loadImageFromNetwork(String imageUrl)
    {
        Drawable drawable = null;
        try {
            // 可以在这里通过文件名来判断，是否本地有此图片
            drawable = Drawable.createFromStream(
                    new URL(imageUrl).openStream(), "image.jpg");
        } catch (IOException e) {
            Log.d("test", e.getMessage());
        }
        if (drawable == null) {
            Log.d("test", "null drawable");
        } else {
            Log.d("test", "not null drawable");
        }

        return drawable ;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, List<Drawable>>
    {
        private List<UISettingsResponse.MainTabBarLayout.MainTabBars> list;

        public DownloadImageTask(List<UISettingsResponse.MainTabBarLayout.MainTabBars> list) {
            this.list = list;
        }

        protected List<Drawable> doInBackground(String... urls) {
            List<Drawable> drs = new ArrayList<>();
            for (int i = 0; i < list.size(); i++ ){
                drs.add(loadImageFromNetwork(list.get(i).getIconUrl()));
            }
            return drs;
        }

        protected void onPostExecute(List<Drawable> result) {
            for (int i = 0; i < result.size(); i++){
                final String name = list.get(i).getName();
                bottomNavigationBar.addItem(new BottomNavigationItem(result.get(i), name)
                        .setActiveColorResource(R.color.teal)).setInActiveColor(R.color.colorAccent);
            }
            bottomNavigationBar.setFirstSelectedPosition(0);
            bottomNavigationBar.initialise();
            fragments = getFragments(list);
            setDefaultFragment();
        }
    }

}