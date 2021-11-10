package com.amirhosseinemadi.bmi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;

import android.accessibilityservice.AccessibilityService;
import android.content.DialogInterface;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.amirhosseinemadi.bmi.R;
import com.amirhosseinemadi.bmi.databinding.ActivityMainBinding;
import com.amirhosseinemadi.bmi.viewModel.ViewModel;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    int white = R.color.md_white_1000;
    NavigationView navigationView;
    LinearLayout linearLayout1,linearLayout2;
    CircleProgressBar circleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        linearLayout1 = findViewById(R.id.lay);
        linearLayout2 = findViewById(R.id.lay2);
        final ViewModel viewModel = new ViewModel(linearLayout1,linearLayout2);
        activityMainBinding.setViewModel(viewModel);
        toolbar = activityMainBinding.toolbar;
        circleProgressBar = activityMainBinding.circlePro;
        navigationView = activityMainBinding.nav;
        setSupportActionBar(toolbar);
        drawerLayout = activityMainBinding.drawer;
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.about :
                        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.bug :
                        Intent intent2 = new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:amirhossein79.e@gmail.com"));
                        startActivity(intent2);
                        break;
                    case R.id.exit :
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("خروج");
                        alert.setMessage("آیا میخواهید خارج شوید ؟");
                        alert.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                            }
                        });
                        alert.setNegativeButton("خیر",null);
                        alert.show();
                        break;
                }
                return false;
            }
        });
        circleProgressBar.setMax(60);
        viewModel.getMutableLiveData().observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                float a = Float.parseFloat(s);
                int b = (int) a;
                circleProgressBar.setProgress(b);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("خروج");
        alert.setMessage("آیا میخواهید خارج شوید ؟");
        alert.setPositiveButton("بله", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alert.setNegativeButton("خیر",null);
        alert.show();
    }
}
