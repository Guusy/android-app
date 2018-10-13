package com.example.ggrascantou.gonzaapp.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ggrascantou.gonzaapp.R;
import com.example.ggrascantou.gonzaapp.view.fragments.HomeFragment;
import com.example.ggrascantou.gonzaapp.view.fragments.ProfileFragment;
import com.example.ggrascantou.gonzaapp.view.fragments.SearchFragment;

import java.util.HashMap;

public class ContainerActivity extends AppCompatActivity {

    HashMap<Integer, Fragment> fragments = new HashMap<Integer, Fragment>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        fragments.put((Integer) R.id.home,new HomeFragment());
        fragments.put((Integer) R.id.profile,new ProfileFragment());
        fragments.put((Integer) R.id.search,new SearchFragment());

        BottomNavigationView bottomBar =  (BottomNavigationView)  findViewById(R.id.bottombar);
        bottomBar.setSelectedItemId(R.id.home);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = fragments.get(menuItem.getItemId());
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                return true;
            }
        });
    }
}
