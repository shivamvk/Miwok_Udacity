package com.example.shivamvk.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<word>{

    private int mcolorResourceId;

    public WordAdapter(Activity context, ArrayList<word> wordd, int colorResourceId){
        super(context,0, wordd);
        mcolorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        word currentWord = getItem(position);

        TextView defaultTranslation = (TextView)listItemView.findViewById(R.id.default_text_view);
        TextView miwokTranslation = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        defaultTranslation.setText(currentWord.getDeafultTranslation());
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mcolorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
