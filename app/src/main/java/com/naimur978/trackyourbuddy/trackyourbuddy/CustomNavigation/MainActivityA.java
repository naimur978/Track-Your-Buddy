package com.naimur978.trackyourbuddy.trackyourbuddy.CustomNavigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.naimur978.trackyourbuddy.trackyourbuddy.R;
import com.naimur978.trackyourbuddy.trackyourbuddy.activity.LogInActivity;
import com.naimur978.trackyourbuddy.trackyourbuddy.fragment.FriendsFragment;
import com.naimur978.trackyourbuddy.trackyourbuddy.fragment.HomeFragment;


public class MainActivityA extends AppCompatActivity {

    Fragment selectedFragment = null;
    public static final String IS_LOGIN = "is_logged_in";
    private SharedPreferences mPref;
    public static final String PREF_NAME = "LOCA";
    int PRIVATE_MODE = 0;
    private SharedPreferences.Editor mEditor;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina);


        mPref = getApplicationContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();

        String isLoggedIn = mPref.getString(IS_LOGIN, null);

        if (isLoggedIn == null) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }

        mHandler = new Handler();

        BubbleNavigationLinearView bubbleNavigation = findViewById(R.id.bubbleNavigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (position){
                    default:
                        selectedFragment = new HomeFragment();
                        break;
                    case 0:
                        selectedFragment = new HomeFragment();
                        break;
                    case 1:
                        selectedFragment = new FriendsFragment();
                        break;
                    case 2:
                        selectedFragment = new StarredFragmentA();
                        break;
                    case 3:
                        selectedFragment = new HomeFragmentA();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });

    }
}
