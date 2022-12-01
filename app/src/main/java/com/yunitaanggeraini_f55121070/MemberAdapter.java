package com.yunitaanggeraini_f55121070;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunitaanggeraini_f55121070.aplikasi_uts.R;

import java.util.ArrayList;
import java.util.Locale;

public class MemberAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Member> members;

    public MemberAdapter(Context context) {
        this.context = context;
        members = new ArrayList<>();
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int i) {
        return members.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_member,
                    viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Member member = (Member) getItem(i);
        viewHolder.bind(member);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind (Member member) {
            txtName.setText(member.getName());
            txtDescription.setText(member.getDescription());
            imgPhoto.setImageResource(member.getPhoto());
        }
    }
}
