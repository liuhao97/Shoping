package com.devliu.shoping;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.devliu.shoping.moudle.classify.ClassifyFragment;
import com.devliu.shoping.moudle.home.HomeFragment;
import com.devliu.shoping.moudle.shop.ShopFragment;
import com.devliu.shoping.moudle.user.UserFragment;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhao
 * on 2017/4/19
 * use to :
 */

public class FirstActivity extends AppCompatActivity {



    private List<Fragment> fragList;
    private FragmentManager manager;
    private AlphaTabsIndicator bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        initVariables();

        initViews();

        initFrags();

        initBottomBar();

    }

    private void initBottomBar() {
        bottomBar.getTabView(0).showNumber(12);
        bottomBar.getTabView(1).showNumber(0);
        bottomBar.getTabView(2).showNumber(3);
        bottomBar.getTabView(3).showPoint();

    }

    private void initFrags() {
        fragList = new ArrayList<>();
        fragList.add(new HomeFragment());
        fragList.add(new ClassifyFragment());
        fragList.add(new ShopFragment());
        fragList.add(new UserFragment());

        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < fragList.size(); i++) {
            Fragment frag = fragList.get(i);
            transaction.add(R.id.main_frag_container, frag);
            if(i != 0){
                transaction.hide(frag);
            }
        }
        transaction.commit();
    }

    private void initVariables() {
        manager = getSupportFragmentManager();
    }

    private void initViews() {
        bottomBar = (AlphaTabsIndicator)findViewById(R.id.main_bottom_bar);
        bottomBar.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                FragmentTransaction transaction = manager.beginTransaction();
                for (int i = 0; i < fragList.size(); i++) {
                    Fragment frag = fragList.get(i);
                    if(tabNum == i){
                        transaction.show(frag);
                    }else{
                        transaction.hide(frag);
                    }
                }
                transaction.commit();
            }
        });
    }



}
