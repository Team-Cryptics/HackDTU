package com.samarthgupta.hackdtu;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class Card_View extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    ImageView iv1;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card__view);
        ref = firebaseDatabase.getReference();
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        iv1 = (ImageView)findViewById(R.id.imageView);

        Intent i = getIntent();
        Log.i("TAG","IN CARD1");
        final String UID = i.getStringExtra("ID");
        Log.i("TAG","IN CARD2");
        Log.i("TAG" , UID);

        if (UID.equals("m13")|| UID.equals("m14")||UID.equals("m16")|| UID.equals("m18")||UID.equals("m7")){

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    DatabaseClass databaseClass = new DatabaseClass();
                    for(DataSnapshot dsp : dataSnapshot.child("Hospitals").child(UID).getChildren()){
                         //databaseClass = dsp.getValue(DatabaseClass.class);
                        Log.i("TAG","Hospital Name : "+databaseClass.getHname());
                    }

                    Log.i("TAG","Hospital Name : "+databaseClass.getHname());
                    tv1.setText("Hospital Name : "+databaseClass.getHname());
                    tv2.setText("Hospital Address :"+databaseClass.getAddress());
                    Picasso.with(getApplicationContext()).load(databaseClass.getImageUrl()).into(iv1);
                    tv4.setText("Number Of Available Doctors :"+ databaseClass.getNumdoc());
                    tv5.setText("Reception Contact Number : " + databaseClass.getPhone());
                    tv6.setText("Doctor Available Between : " + databaseClass.getTimings());


                    // for(DataSnapshot dsp : dataSnapshot.child("Hospitals").child(UID).getChildren()){

                    //}

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }


    }
}
