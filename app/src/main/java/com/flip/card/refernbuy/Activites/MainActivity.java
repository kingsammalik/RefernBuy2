package com.flip.card.refernbuy.Activites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.flip.card.refernbuy.Fragments.CartFragment;
import com.flip.card.refernbuy.Fragments.CategoryFragment;
import com.flip.card.refernbuy.Fragments.HomeFrag;
import com.flip.card.refernbuy.Fragments.ProfileFragment;
import com.flip.card.refernbuy.Fragments.WholeSaleFragment;
import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.adapters.RecyclerViewDataAdapter;
import com.flip.card.refernbuy.interfaces.IOnBackPressed;
import com.flip.card.refernbuy.models.SectionDataModel;
import com.flip.card.refernbuy.models.SingleItemModel;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public BottomNavigationView bottomNavigationView;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        initView();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:

                        HomeFrag homeFragment = new HomeFrag();
                        transaction.replace(R.id.main_fragment_container, homeFragment).commit();
                        hideSearch();
                        break;

                    case R.id.nav_category:

                        CategoryFragment categoryFragment = new CategoryFragment();
                        transaction.replace(R.id.main_fragment_container, categoryFragment).commit();
                        showSearch();

                        break;

                    case R.id.nav_profile:

                        ProfileFragment profileFragment = new ProfileFragment();
                        transaction.replace(R.id.main_fragment_container, profileFragment).commit();


                        break;
                    case R.id.nav_whole:

                        WholeSaleFragment wholeSaleFragment = new WholeSaleFragment();
                        transaction.replace(R.id.main_fragment_container, wholeSaleFragment).commit();

                        break;
                    case R.id.nav_cart:

                        CartFragment cartFragment = new CartFragment();
                        transaction.replace(R.id.main_fragment_container, cartFragment).commit();

                        break;

                }

                return true;
            }
        });
        bottomNavigationView.setVisibility(View.VISIBLE);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void initView() {

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        linearLayout = (LinearLayout) findViewById(R.id.linear);


    }

    public void hideSearch(){
        linearLayout.setVisibility(View.GONE);
    }

    public void showSearch(){
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_container);
        if (!(fragment instanceof IOnBackPressed) || !((IOnBackPressed) fragment).onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_active) {
            // Handle the camera action
        } else if (id == R.id.nav_earning) {

        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_wish) {

        } else if (id == R.id.nav_earn) {

        } else if (id == R.id.nav_orders) {

        }else if (id == R.id.nav_coupon) {

        } else if (id == R.id.nav_manager) {

        } else if (id == R.id.nav_care) {

        } else if (id == R.id.nav_how) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
