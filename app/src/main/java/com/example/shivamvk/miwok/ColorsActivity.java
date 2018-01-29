package com.example.shivamvk.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mMediaplayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public void releaseMediaPlayer(){
        if (mMediaplayer != null){
            mMediaplayer.release();
            mMediaplayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<word> words = new ArrayList<word>();

        words.add(new word("red","wetetti", R.drawable.color_red, R.raw.color_red));
        words.add(new word("green","chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new word("brown","takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new word("gray","topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new word("black","kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new word("white","kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new word("dusty yellow","topiise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new word("mustard yellow","chiwiite", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word word = words.get(i);

                releaseMediaPlayer();

                mMediaplayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mMediaplayer.start();
                mMediaplayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
