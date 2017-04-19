package com.devliu.shoping.ui.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.devliu.shoping.R;
import com.devliu.shoping.ui.frag.ClassifyFrag;
import com.devliu.shoping.ui.frag.HomeFrag;
import com.devliu.shoping.ui.frag.ShopFrag;
import com.devliu.shoping.ui.frag.UserFrag;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        fragList.add(new HomeFrag());
        fragList.add(new ClassifyFrag());
        fragList.add(new ShopFrag());
        fragList.add(new UserFrag());

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
