/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.customchoicelist;

//import android.app.ListActivity;
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.media.MediaPlayer;
import android.content.Context;


/**
 * This sample demonstrates how to create custom single- or multi-choice
 * {@link android.widget.ListView} UIs. The most interesting bits are in
 * the <code>res/layout/</code> directory of this sample.
 */


public class MainActivity extends Activity implements View.OnClickListener {
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;

    MediaPlayer mp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);
//        addListenerOnButton();

        imageButton1 = (ImageButton) findViewById(R.id.play1);
        imageButton2 = (ImageButton) findViewById(R.id.play2);
        imageButton3 = (ImageButton) findViewById(R.id.play3);
        imageButton4 = (ImageButton) findViewById(R.id.stop1);
        imageButton5 = (ImageButton) findViewById(R.id.stop2);
        imageButton6 = (ImageButton) findViewById(R.id.stop3);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);



    }

    public void onClick(View v) {



        switch (v.getId()) {

            case R.id.play1:

//                Toast.makeText(MainActivity.this,
//                        "Song 1 Played!", Toast.LENGTH_SHORT).show();
                try {
                    if(mp != null && mp.isPlaying()) {
                        imageButton1.setImageResource(R.drawable.ic_play);
                            mp.pause();
                        Toast.makeText(MainActivity.this,
                                "Song 1 is Paused!", Toast.LENGTH_SHORT).show();
                    }
                    else if(mp != null && mp.getDuration() > 0 ){
                            imageButton1.setImageResource(R.drawable.ic_pause);
                            mp.start();
                    }else{
                        mp = new MediaPlayer();
                        int resID = getResources().getIdentifier("test", "raw", getBaseContext().getPackageName());
                        mp = MediaPlayer.create(getBaseContext(),resID);
                        imageButton1.setImageResource(R.drawable.ic_pause);
                        mp.start();
                        Toast.makeText(MainActivity.this,
                                "Song 1 is Playing!", Toast.LENGTH_SHORT).show();
                    }

                    } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case R.id.stop1:
                Toast.makeText(MainActivity.this,
                        "Song 1 has stopped playing!", Toast.LENGTH_SHORT).show();
                if(mp.isPlaying()) {
                    imageButton1.setImageResource(R.drawable.ic_play);
                    mp.stop();
                    mp = null;
                }
            break;
        }
    }
}
