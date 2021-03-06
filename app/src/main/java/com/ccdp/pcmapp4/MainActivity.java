package com.ccdp.pcmapp4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.ccdp.pcmapp4.fragment.AboutFragment;
import com.ccdp.pcmapp4.fragment.HomeFragment;
import com.ccdp.pcmapp4.fragment.JoinFragment;
import com.ccdp.pcmapp4.fragment.OrderFragment;
import com.google.firebase.auth.FirebaseAuth;

public  class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth firebaseAuth;
    private ImageView txtview_edit;
        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            View headerview=navigationView.getHeaderView(0);
            txtview_edit = (ImageView)headerview.findViewById(R.id.userprofile);

            txtview_edit.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick (View v){
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);

                }
            });
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
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
            switch (id){
                //case R.id.action_add:
                //Intent intent = new Intent(MainActivity.this,AddKebersihanActivity.class);
                //startActivity(intent);
                //break;

                case R.id.action_logout:
                    firebaseAuth.signOut();
                    startActivity(new Intent(this, LoginActivity.class));
                break;

                case R.id.action_exit:
                    finish();
                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.navigation_home) {
                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, homeFragment).commit();
            } else if (id == R.id.navigation_order) {
                OrderFragment orderFragment = new OrderFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, orderFragment).commit();
            } else if (id == R.id.navigation_joinus) {
                JoinFragment joinFragment = new JoinFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, joinFragment).commit();
            } else if (id == R.id.navigation_about) {
                AboutFragment aboutFragment = new AboutFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, aboutFragment).commit();


            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
}