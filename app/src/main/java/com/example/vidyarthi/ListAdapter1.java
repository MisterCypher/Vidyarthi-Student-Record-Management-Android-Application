package com.example.vidyarthi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter1 extends ArrayAdapter {
    private Activity mContext1;
    List<academic> studentlist1;
    public ListAdapter1(Activity mContext1,List<academic> studentlist1){
        super(mContext1,R.layout.view1,studentlist1);
        this.mContext1=mContext1;
        this.studentlist1=studentlist1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        LayoutInflater inflater=mContext1.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.view1,null,true);

        TextView tv10= listItemView.findViewById(R.id.tv10);
        TextView tv12= listItemView.findViewById(R.id.tv12);
        TextView tvgrad= listItemView.findViewById(R.id.tvgrad);
        TextView tvjoin= listItemView.findViewById(R.id.tvjoin);
        TextView tvseat= listItemView.findViewById(R.id.tvseat);

        academic academic=studentlist1.get(position);


        tv10.setText(Integer.toString(academic.getTenmarks()));
        tv12.setText(Integer.toString(academic.getTwelvemarks()));
        tvgrad.setText(Integer.toString(academic.getGraduationmarks()));
        tvjoin.setText(academic.getRoll());
        tvseat.setText(Integer.toString(academic.getSeatnumber()));

        return listItemView;




    }
}
