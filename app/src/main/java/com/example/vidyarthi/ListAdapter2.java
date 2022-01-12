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

public class ListAdapter2 extends ArrayAdapter {
    private Activity mContext2;
    List<extra> studentlist2;
    public ListAdapter2(Activity mContext2,List<extra> studentlist2){
        super(mContext2,R.layout.view2,studentlist2);
        this.mContext2=mContext2;
        this.studentlist2=studentlist2;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        LayoutInflater inflater=mContext2.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.view2,null,true);

        TextView cert = listItemView.findViewById(R.id.tvcert);
        TextView sport= listItemView.findViewById(R.id.tvsport);
        TextView seminar= listItemView.findViewById(R.id.tvseminar);
        TextView course= listItemView.findViewById(R.id.tvcourse);
        TextView other= listItemView.findViewById(R.id.tvother);



        extra extra=studentlist2.get(position);


        cert.setText(extra.getCert());
        sport.setText(extra.getSport());
        seminar.setText(extra.getSemi());
        course.setText(extra.getCourse());
        other.setText(extra.getrollextra());

        return listItemView;



    }
}
