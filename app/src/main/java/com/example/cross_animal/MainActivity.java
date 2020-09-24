package com.example.cross_animal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    ImageButton imageButton;
    CheckBox checkBox1,checkBox2,checkBox3;
    SeekBar seekBar1,seekBar2,seekBar3;
    int sodiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        seekbar();
        final CountDownTimer countDownTimer =new CountDownTimer(60000,300)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three =random.nextInt(number);

                seekBar1.setProgress(seekBar1.getProgress() +one);
                seekBar2.setProgress(seekBar2.getProgress() +two);
                seekBar3.setProgress(seekBar3.getProgress() +three);

                //kiểm tra win1
                if (seekBar1.getProgress()>=seekBar1.getMax())
                {
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    if(checkBox1.isChecked())
                    {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this,"bạn đặt cược chính xác",Toast.LENGTH_LONG).show();
                        textView.setText(String.valueOf(sodiem));
                    }
                    else
                    {
                        sodiem = sodiem -5;
                        textView.setText(String.valueOf(sodiem));
                        Toast.makeText(MainActivity.this,"bạn đặt cược không chính xác",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(MainActivity.this,"mặt cười win",Toast.LENGTH_LONG).show();
                    enable();
                }

                //kiểm tra win2
                if (seekBar2.getProgress()>=seekBar2.getMax())
                {
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    if(checkBox2.isChecked())
                    {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this,"bạn đặt cược chính xác",Toast.LENGTH_LONG).show();
                        textView.setText(String.valueOf(sodiem));
                    }
                    else
                    {
                        sodiem = sodiem - 5;
                        textView.setText(String.valueOf(sodiem));
                        Toast.makeText(MainActivity.this,"bạn đặt cược không chính xác",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(MainActivity.this,"mặt trái tim win",Toast.LENGTH_LONG).show();
                    enable();
                }
                //kiểm tra win3
                if (seekBar3.getProgress()>=seekBar3.getMax())
                {
                    this.cancel();
                    imageButton.setVisibility(View.VISIBLE);
                    if(checkBox3.isChecked())
                    {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this,"bạn đặt cược chính xác",Toast.LENGTH_LONG).show();
                        textView.setText(String.valueOf(sodiem));
                    }
                    else
                    {
                        sodiem = sodiem - 5;
                        textView.setText(String.valueOf(sodiem));
                        Toast.makeText(MainActivity.this,"bạn đặt cược không chính xác",Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(MainActivity.this,"mặt buồn win",Toast.LENGTH_LONG).show();
                    enable();
                }

            }

            @Override
            public void onFinish()
            {

            }
        };
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }

            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }

            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    checkBox2.setChecked(false);
                    checkBox1.setChecked(false);
                }
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if(checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked())
                {
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);
                    imageButton.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    disenable();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"vui lòng đặt cược trước khi chơi",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private  void enable()
    {
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    private void disenable()
    {
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
    private void anhxa()
    {
        textView = (TextView) findViewById(R.id.texview);
        imageButton = (ImageButton) findViewById(R.id.button);
        checkBox1   = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2   = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3   = (CheckBox) findViewById(R.id.checkbox3);
        seekBar1    = (SeekBar)  findViewById(R.id.seebar1);
        seekBar2    = (SeekBar) findViewById(R.id.seebar2);
        seekBar3    = (SeekBar) findViewById(R.id.seebar3);
    }
    private void seekbar()
    {
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
    }
}