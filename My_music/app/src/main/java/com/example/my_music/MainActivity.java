package com.example.my_music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    TextView textView1,textView2,textView3;
    ImageButton play,pause,nextright,nextleft;
    SeekBar seekBar;
    ArrayList<Song> arraysong;
    MediaPlayer mediaPlayer;
    int possition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        addsong();
        khoitaomedia();
        nextright.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                possition++;
                if(possition>arraysong.size()-1)
                {
                    possition = 0;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                khoitaomedia();
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
                    possition = arraysong.size()-1;
                }
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.stop();
                }
                khoitaomedia();
                mediaPlayer.start();
                play.setImageResource(R.drawable.pause);
            }
        });

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.play);
                }
                else
                {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.pause);
                }
                settime();
            }
        });
        pause.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                mediaPlayer.stop();
                mediaPlayer.release();
                play.setImageResource(R.drawable.play);
                khoitaomedia();

            }
        });
    }
    private void settime()
    {
        SimpleDateFormat dinhdanggio = new SimpleDateFormat("mm:ss");
        textView2.setText(dinhdanggio.format(mediaPlayer.getDuration()));
    }
    private void khoitaomedia()
    {
        mediaPlayer  = MediaPlayer.create(MainActivity.this,arraysong.get(possition).getFile());
        textView1.setText(arraysong.get(possition).getTitle());
    }
    private void addsong()
    {
        arraysong = new ArrayList<>();
        arraysong.add(new Song("hoa no khong mau", R.raw.hoa_no_khong_mau));
        arraysong.add(new Song("gac lai au lo",R.raw.gac_lai_au_lo));
        arraysong.add(new Song(" buon lam chi em oi",R.raw.buon_lam_chi_em_oi));
        arraysong.add(new Song("nang tho",R.raw.nang_tho));
    }
    private void anhxa()
    {
        play      = (ImageButton) findViewById(R.id.btn4);
        pause     = (ImageButton) findViewById(R.id.btn3);
        nextright = (ImageButton) findViewById(R.id.btn2);
        nextleft  = (ImageButton) findViewById(R.id.btn1);
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
    }

}