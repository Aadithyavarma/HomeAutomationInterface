package com.example.aadithyavarma.homeautomationinterface;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LightsAndFans extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("device_status");

    Switch mySwitch1, mySwitch2, mySwitch3, mySwitch4, mySwitch5, mySwitch6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_and_fans);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mySwitch1 = (Switch) findViewById(R.id.switch1);
        mySwitch2 = (Switch) findViewById(R.id.switch2);
        mySwitch3 = (Switch) findViewById(R.id.switch3);
        mySwitch4 = (Switch) findViewById(R.id.switch4);
        mySwitch5 = (Switch) findViewById(R.id.switch5);
        mySwitch6 = (Switch) findViewById(R.id.switch6);

        getSwitchStates();

        mySwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("bathroom_light").setValue("on");
                }
                else{
                    myRef.child("bathroom_light").setValue("off");
                }
            }
        });

        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("bedroom_fan").setValue("on");
                }
                else{
                    myRef.child("bedroom_fan").setValue("off");
                }
            }
        });

        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("bedroom_light").setValue("on");
                }
                else{
                    myRef.child("bedroom_light").setValue("off");
                }
            }
        });

        mySwitch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("kitchen_light").setValue("on");
                }
                else{
                    myRef.child("kitchen_light").setValue("off");
                }
            }
        });

        mySwitch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("livingroom_fan").setValue("on");
                }
                else{
                    myRef.child("livingroom_fan").setValue("off");
                }
            }
        });

        mySwitch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    myRef.child("livingroom_light").setValue("on");
                }
                else{
                    myRef.child("livingroom_light").setValue("off");
                }
            }
        });
    }

    private void getSwitchStates() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("device_status");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                for (DataSnapshot data:
                        dataSnapshot.getChildren()){
                    String s = (String) data.getValue();
                    Boolean bool = true;
                    if(s.equals("off")){
                        bool = false;
                    }
                    if (i == 0){
                        mySwitch1.setChecked(bool);
                    }
                    if (i == 1){
                        mySwitch2.setChecked(bool);
                    }

                    if (i == 2){
                        mySwitch3.setChecked(bool);
                    }

                    if (i == 3){
                        mySwitch4.setChecked(bool);
                    }

                    if (i == 4){
                        mySwitch5.setChecked(bool);
                    }

                    if (i == 5){
                        mySwitch6.setChecked(bool);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
