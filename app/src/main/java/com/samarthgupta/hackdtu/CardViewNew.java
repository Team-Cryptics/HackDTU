package com.samarthgupta.hackdtu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

/**
 * Created by samarthgupta on 11/02/17.
 */

public class CardViewNew extends AppCompatActivity {
    private static final String TAG = "MainAct: ";

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    ImageView iv1;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    DatabaseClass databaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card__view);


        databaseReference = firebaseDatabase.getReference();
       /* DatabaseClass databaseClass = new DatabaseClass("01","http://s4.reutersmedia.net/resources/r/?m=02&d=20151009&t=2&i=1085748865&w=644&fh=&fw=&ll=&pl=&sq=&r=LYNXNPEB980MV","J.K. Medical Store","J.K. Medical Store : B-Block, Near MCD Community Bhawan, Sahibabad Dairy, Delhi",00,00,"27849277","10 AM to 10 PM");
        /*    ref = firebaseDatabase.getReference();

        databaseReference.child("Pharmacy").child("01").setValue(databaseClass);
        DatabaseClass databaseClass1 = new DatabaseClass("02","http://res.cloudinary.com/tropicalpost/image/upload/v1444848804/Pharmacy_uetbus.jpg","Curifiq","Curifiq Rohini Sector 16 : B2/7 No 3 B Rd Pocket 2 Sector 16B Rohini New Delhi Delhi 110089",00,00,"9999177254","24 hours");
        databaseReference.child("Pharmacy").child("02").setValue(databaseClass1);

        DatabaseClass databaseClass3 = new DatabaseClass("03","https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTp-vcT67zt0Tq-_LYcS5tMlNDZuFD9xeKB6QkJyF-8NbFpDQ-D5A","Medi -Shoppe","Medi -Shoppe : Shop No 32, DDA Market, Behind Sachdev School, Sector 13, Rohini",00,00,"9019286352","6 AM to 4 PM");
        databaseReference.child("Pharmacy").child("03").setValue(databaseClass3);
 */

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        iv1 = (ImageView)findViewById(R.id.imageView);
        final String UTITLE = getIntent().getStringExtra("Title");
        final boolean Ishos = getIntent().getBooleanExtra("is",true);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dsp : dataSnapshot.child(Ishos?"Hospital":"Pharmacy").getChildren()){
                    databaseClass= dsp.getValue(DatabaseClass.class);
                    if(databaseClass.getAddress().equals(UTITLE)){
                        setFunc();
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

       }

    private void setFunc() {
        tv1.setText("Hospital Name : "+databaseClass.getHname());
        tv2.setText("Hospital Address :"+databaseClass.getAddress());
        Picasso.with(getApplicationContext()).load(databaseClass.getImageUrl()).into(iv1);
        if(databaseClass.getNumdoc()!=0) {
            tv5.setText("Number of Rooms Available : " + databaseClass.getNumroom());
        tv6.setText("Number Of Available Doctors :"+ databaseClass.getNumdoc());
         }
        tv3.setText("Reception Contact Number : " + databaseClass.getPhone());
        tv4.setText("Doctor Available Between : " + databaseClass.getTimings());
    }
}


