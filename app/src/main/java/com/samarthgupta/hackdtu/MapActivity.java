package com.samarthgupta.hackdtu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class
MapActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MapsActivity mapsActivity;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref,ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mapsActivity = new MapsActivity();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ref1 = firebaseDatabase.getReference();
        ref=firebaseDatabase.getReference();

         String uid = "m13";
         String hname = "Sanjay gandhi hospital Hospital";
         String address = "Block S, Mangolpuri, Delhi, 110083";
          int numdoc =15;
         int numroom= 25;
         String phone = "282759087";
         String timings = "24 hours";
         String imageUrl = "https://hrelate.in/img/user_profile/sanjay-gandhi-memorial-hospital-mangolpuri-delhi1715712591.jpg";
        DatabaseClass dc1 = new DatabaseClass(uid,imageUrl,hname,address,numdoc,numroom,phone,timings);

        ref.child("Hospitals").child(uid).setValue(dc1);

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               DatabaseClass databaseClass;
                for(DataSnapshot dsp : dataSnapshot.child("Hospitals").getChildren()){
                    databaseClass=dsp.getValue(DatabaseClass.class);
                    String a= databaseClass.getAddress();
                    Log.i("TAG",a);


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
        getMenuInflater().inflate(R.menu.map, menu);
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

        if (id == R.id.nav_hospital) {
            mapsActivity.build_retrofit_and_get_response("hospital");
        } else if (id == R.id.nav_chemist) {
            mapsActivity.build_retrofit_and_get_response("pharmacy");
        } else if (id == R.id.nav_heart) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_abt) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
