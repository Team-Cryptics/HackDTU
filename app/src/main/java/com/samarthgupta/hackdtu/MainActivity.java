package com.samarthgupta.hackdtu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref=firebaseDatabase.getReference();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
git
                for(DataSnapshot dsp : dataSnapshot.child("006").getChildren()){
                    Log.i("TAG","TAG");
                    DatabaseClass databaseClass=dsp.getValue(DatabaseClass.class);
                    Log.i("TAG","TAG");
                    Log.i("TAG",databaseClass.getAddress());

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
