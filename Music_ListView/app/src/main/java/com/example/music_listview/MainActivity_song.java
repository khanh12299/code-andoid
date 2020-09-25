package com.example.music_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity_song extends AppCompatActivity {
    ListView listView2;
    ArrayList<List_bai_hat> list_bai_hat;
    MediaPlayer mediaPlayer;
    ImageButton play,pause,nextright,nextleft;

    int possition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_song);
        anhxa();
        addsong();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                play.setImageResource(R.drawable.play);
                khoitao();
            }
        });
        nextright.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                possition++;
                if(possition>list_bai_hat.size()-1)
                {
                    possition = 0;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                khoitao();
                mediaPlayer.start();
                play.setImageResource(R.drawable.pause);
            }
        });
        nextleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                possition--;
                if(possition < 0)
                {
                    possition = list_bai_hat.size()-1;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                khoitao();
                mediaPlayer.start();
                play.setImageResource(R.drawable.pause);
            }
        });
    }
    private void addsong()
    {
        list_bai_hat = new ArrayList<>();
        list_bai_hat.add(new List_bai_hat("gac lai au lo",R.raw.gac_lai_au_lo));
        list_bai_hat.add(new List_bai_hat(" buon lam chi em oi",R.raw.buon_lam_chi_em_oi));
        list_bai_hat.add(new List_bai_hat("nang tho",R.raw.nang_tho));
    }
    private  void khoitao()
    {
        mediaPlayer  = MediaPlayer.create(MainActivity_song.this,list_bai_hat.get(possition).getFile());
    }
    private void anhxa()
    {
        play        = (ImageButton) findViewById(R.id.play);
        pause       = (ImageButton) findViewById(R.id.pause);
        nextleft    = (ImageButton) findViewById(R.id.nextleft);
        nextright   = (ImageButton) findViewById(R.id.nextright);
    }


}