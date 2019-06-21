package com.example.adita.amstta3;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {
    private Fragment fragment;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FloatingActionButton fab_main, fab_verde, fab_amarillo;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    private Fragment fragment2;
    TextView textview_verde, textview_amarillo;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawerLayout.addDrawerListener(this);

        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });

        fab_main = findViewById(R.id.fab_main); fab_main.bringToFront();
        fab_verde = findViewById(R.id.fab_verde); fab_verde.bringToFront();
        fab_amarillo = findViewById(R.id.fab_amarillo); fab_amarillo.bringToFront();
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        textview_verde = (TextView) findViewById(R.id.txt_verde);
        textview_amarillo = (TextView) findViewById(R.id.txt_amarillo);

        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {
                    textview_verde.setVisibility(View.INVISIBLE);
                    textview_amarillo.setVisibility(View.INVISIBLE);
                    fab_verde.startAnimation(fab_close);
                    fab_amarillo.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab_amarillo.setClickable(false);
                    fab_verde.setClickable(false);
                    isOpen = false;
                } else {
                    textview_verde.setVisibility(View.VISIBLE);
                    textview_amarillo.setVisibility(View.VISIBLE);
                    fab_verde.startAnimation(fab_open);
                    fab_amarillo.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab_verde.setClickable(true);
                    fab_amarillo.setClickable(true);
                    isOpen = true;
                }

            }
        });


        fab_amarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(Color.YELLOW);
            }
        });
        fab_verde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(Color.GREEN);

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        switch (menuItem.getItemId()) {
            case R.id.nav_video:
                fragment = new Fragment_video();
                fragmentTransaction = true;
                break;
            case R.id.nav_calendario:
                fragment = new Fragment_calendario();
                fragmentTransaction = true;
                break;
            case R.id.nav_mapa:
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction fragmentTransaction1 = fm.beginTransaction();
//                fragmentTransaction1.replace(R.id.frameLayout, new Fragment_mapa());
//                fragmentTransaction1.commit();

                fragment = new Fragment_mapa();
                fragmentTransaction = true;
                break;
            case R.id.nav_grafica:
                fragment = new Fragment_grafico();
                fragmentTransaction = true;
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }

        if(fragmentTransaction) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
            setTitle(menuItem.getTitle());
        }
        else{
            fragment = HomeContentFragment.newInstance("SELECCIONE UNA OPCIÓN DEL MENÚ");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();
            setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
       // Toast.makeText(this, getString(R.string.navigation_drawer_open),
              //  Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }
}

