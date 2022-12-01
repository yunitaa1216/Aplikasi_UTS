package com.yunitaanggeraini_f55121070;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunitaanggeraini_f55121070.aplikasi_uts.R;

public class DetailMember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_member);

        ImageView poster = findViewById(R.id.imgDetail);
        TextView title = findViewById(R.id.DetailTitle);
        TextView desc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        poster.setImageResource(bundle.getInt("Name"));
        title.setText(bundle.getString("posisi"));
        desc.setText(bundle.getString("desc"));
    }
}