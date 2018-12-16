package com.danusuhendra.pikcat;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public
class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private OrderFragment orderFragment;
    private HistoryFragment historyFragment;
    private AkunFragment akunFragment;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMainFrame =  (FrameLayout) findViewById(R.id.main_frame);
        mMainNav =  (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        orderFragment = new OrderFragment();
        historyFragment = new HistoryFragment();
        akunFragment = new AkunFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nave_order:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(orderFragment);
                        return true;
                    case R.id.nav_history:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(historyFragment);
                        return true;
                    case R.id.nav_akun:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(akunFragment);
                        return true;

                        default:
                            return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
