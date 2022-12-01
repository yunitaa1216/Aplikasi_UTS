package com.yunitaanggeraini_f55121070.aplikasi_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.yunitaanggeraini_f55121070.DetailMember;
import com.yunitaanggeraini_f55121070.Member;
import com.yunitaanggeraini_f55121070.MemberAdapter;
import com.yunitaanggeraini_f55121070.aplikasi_uts.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private MemberAdapter adapter;
    private ArrayList<Member> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MemberAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, members.get(i).getName(), Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, DetailMember.class));
                }
            }
        });

    }

    private void prepare() {
        dataName = getResources(). getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        members = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Member member = new Member();
            member.setPhoto(dataPhoto.getResourceId(i, -1));
            member.setName(dataName[i]);
            member.setDescription(dataDescription[i]);
            members.add(member);
        }
        adapter.setMembers(members);
    }
}