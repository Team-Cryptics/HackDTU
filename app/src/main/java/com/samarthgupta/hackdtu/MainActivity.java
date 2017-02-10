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
    DatabaseReference ref,ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref1 = firebaseDatabase.getReference();
        ref=firebaseDatabase.getReference();
        DatabaseClass dc1 = new DatabaseClass(001, "hname","add",10,50,"989898", "9-7");
        ref.child("A").setValue(dc1);

        ref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                DatabaseClass databaseClass;
                for(DataSnapshot dsp : dataSnapshot.getChildren()){
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
}
