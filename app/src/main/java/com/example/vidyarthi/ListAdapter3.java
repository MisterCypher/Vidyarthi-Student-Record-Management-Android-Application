package com.example.vidyarthi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter3 extends ArrayAdapter {
    private Activity mContext3;
    List<current> studentlist3;
    public ListAdapter3(Activity mContext3,List<current> studentlist3){
        super(mContext3,R.layout.view3,studentlist3);
        this.mContext3=mContext3;
        this.studentlist3=studentlist3;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        LayoutInflater inflater=mContext3.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.view3,null,true);

        TextView currentbehave= listItemView.findViewById(R.id.tvcurrentbehave);
        TextView remarksbyin= listItemView.findViewById(R.id.tvremarksbyin);

        current current=studentlist3.get(position);


       currentbehave.setText(current.getroll());
        remarksbyin.setText(current.getRemarksbyin());


        return listItemView;







    }

}
