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

public class PhrasesActivity extends AppCompatActivity {

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

        words.add(new word("Where are you going?","minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?","tinne oyaasene", R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...","oyaaset", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?","michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I'm feeling good.","kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?","eenesaa?", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I'm coming.","hee eenem", R.raw.phrase_yes_im_coming));
        words.add(new word("I'm coming.","eenem", R.raw.phrase_im_coming));
        words.add(new word("Let's go.","yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here.","enninem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word word = words.get(i);

                releaseMediaPlayer();

                mMediaplayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
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
