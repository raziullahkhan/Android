package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    int cl;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int cl) {
        super(context,0,words);
        this.cl=cl;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord=getItem(position);
        RelativeLayout lnr=(RelativeLayout)listItemView.findViewById(R.id.text_container);
        lnr.setBackgroundResource(cl);
        TextView miwok_text_view=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        TextView default_text_View=(TextView)listItemView.findViewById(R.id.default_text_view);
        miwok_text_view.setText(currentWord.getMiwokTranslation());
        default_text_View.setText(currentWord.getDefaultMiwokTranslation());
       // miwok_text_view.setBackgroundResource(cl);
        //default_text_View.setBackgroundResource(cl);
        ImageView iv=(ImageView)listItemView.findViewById(R.id.image);
        if(currentWord.getImageResource()!=0){
            iv.setImageResource(currentWord.getImageResource());
        }
        else{
            iv.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
