package com.androidchill.niki.parcebleandroid.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidchill.niki.parcebleandroid.R;
import com.androidchill.niki.parcebleandroid.models.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Activity A");
        btn = (Button) findViewById(R.id.btnSend);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                // User Info
                UserInfo userinfo = createContact("Niki", "Izvorski", 1);

                //Pass the UserInfo
                //i.putExtra("contact", userinfo);

                //Pass List of UserInfo
                List<UserInfo> cList = createContactList();

                //Add Extra
                i.putParcelableArrayListExtra("contact", (ArrayList<? extends Parcelable>) cList);

                //Pass to Activity
                startActivity(i);
            }
        });
    }

    private UserInfo createContact(String name, String surname, int index) {

        UserInfo ci = new UserInfo();
        ci.setName("Niki" + index);
        ci.setSurname("Izvorski" + index);
        ci.setIdx(index);

        UserInfo.Address add = new UserInfo.Address();
        add.setCity("London");
        add.setStreet("str SummerHill");
        add.setNumber(1);

        ci.setAddress(add);

        return ci;
    }

    private List<UserInfo> createContactList() {
        List<UserInfo> cList = new ArrayList<UserInfo>();
        for (int i=0; i < 10; i++)
            cList.add(createContact("Name " + i, "Surname " + i, i));

        return cList;
    }

    private TreeSet<UserInfo> createSetList() {

        TreeSet<UserInfo> sList = new TreeSet<>();
        sList.addAll(createContactList());

        return sList;
    }

    private TreeMap<UserInfo, UserInfo.Address> createMapInfo() {

        TreeMap<UserInfo, UserInfo.Address> theList = new TreeMap<>();
        theList.putAll(new ConcurrentHashMap<UserInfo, UserInfo.Address>());

        return theList;
    }


    @Override
    protected void onPause() {
        super.onPause();
        //Remove transitions we don't use them right now.
        overridePendingTransition(0, 0);
    }
}
