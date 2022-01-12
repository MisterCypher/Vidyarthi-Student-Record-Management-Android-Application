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

public class ListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<personal> studentlist;
    public ListAdapter(Activity mContext,List<personal> studentlist){
        super(mContext,R.layout.view,studentlist);
        this.mContext=mContext;
        this.studentlist=studentlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        LayoutInflater inflater=mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.view,null,true);

        TextView tvfname= listItemView.findViewById(R.id.tvfname);
        TextView tvmname= listItemView.findViewById(R.id.tvmname);
        TextView tvroll= listItemView.findViewById(R.id.tvroll);
        TextView tvpersonal= listItemView.findViewById(R.id.tvpersonal);
        TextView tvcoll= listItemView.findViewById(R.id.tvcoll);
        TextView tvblood= listItemView.findViewById(R.id.tvblood);
        TextView tvhob= listItemView.findViewById(R.id.tvhob);

         personal personal=studentlist.get(position);
String name=tvfname.getText().toString().trim();
   /*     String mname=tvmname.getText().toString().trim();
        String roln=tvroll.getText().toString().trim();
        String per=tvpersonal.getText().toString().trim();
        String co=tvcoll.getText().toString().trim();
        String blo=tvblood.getText().toString().trim();
        String hob=tvhob.getText().toString().trim();
*/



//personal personal =new personal(name,mname,roln,per,co,blo,hob);
        tvfname.setText(personal.getFullname());
        tvmname.setText(personal.getMothersname());
        tvroll.setText(personal.getRollnumber());
        tvpersonal.setText(personal.getEmail());
        tvcoll.setText(personal.getCollegeemail());
        tvblood.setText(personal.getBloodgroup());
        tvhob.setText(personal.getHobbies());

        return listItemView;



    }
}
