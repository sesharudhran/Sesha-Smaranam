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


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.Locale;
import android.net.Uri;




public class Activity_1 extends Activity implements View.OnClickListener {
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    Button locateUS;


    MediaPlayer mp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //button_1 = (Button) findViewById(R.id.button1);

        imageButton1 = (ImageButton) findViewById(R.id.play1);
        imageButton2 = (ImageButton) findViewById(R.id.play2);
        imageButton3 = (ImageButton) findViewById(R.id.play3);
        imageButton4 = (ImageButton) findViewById(R.id.stop1);
        imageButton5 = (ImageButton) findViewById(R.id.stop2);
        imageButton6 = (ImageButton) findViewById(R.id.stop3);
        locateUS = (Button) findViewById(R.id.Map);

        //button_1.setOnClickListener(this);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        locateUS.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.play1:

                try {
                    if(mp != null && mp.isPlaying()) {
                        imageButton1.setImageResource(R.drawable.ic_play);
                        imageButton2.setImageResource(R.drawable.ic_play);
                        mp.pause();
                        Toast.makeText(Activity_1.this,
                                "Song 1 is Paused!", Toast.LENGTH_SHORT).show();

                    }
                    else if(mp != null && mp.getDuration() > 0 ){
                        imageButton1.setImageResource(R.drawable.ic_pause);
//                            int resID = getResources().getIdentifier("test", "raw", getBaseContext().getPackageName()); //a1
//                            mp = MediaPlayer.create(getBaseContext(),resID); //a1
                        Toast.makeText(Activity_1.this,
                                "Song 1 is Playing ******!", Toast.LENGTH_SHORT).show();
                      int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());

                      mp = MediaPlayer.create(getBaseContext(),resID_Song1);

                        mp.start();


                    }else{
                        mp = new MediaPlayer();
                        int resID = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
                        mp = MediaPlayer.create(getBaseContext(),resID);
                       // System.out.println(resID);
                        imageButton1.setImageResource(R.drawable.ic_pause);
                        Toast.makeText(Activity_1.this,
                                "Song 1 is Playing!", Toast.LENGTH_SHORT).show();
                        mp.start();

                    }

                    } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case R.id.stop1:
                try {

                    Toast.makeText(Activity_1.this,
                            "Song 1 has stopped playing!", Toast.LENGTH_SHORT).show();

                    imageButton1.setImageResource(R.drawable.ic_play);
                    mp.stop();
                    mp = null;

                }
                catch (Exception stopex1){

                    stopex1.printStackTrace();

                }
                break;

            case R.id.play2:

                try {
                    if(mp != null && mp.isPlaying()) {
                        imageButton1.setImageResource(R.drawable.ic_play);
                        imageButton2.setImageResource(R.drawable.ic_play);
                        Toast.makeText(Activity_1.this,
                                "Song 2 is Paused!", Toast.LENGTH_SHORT).show();
//                        System.out.print(mp.getAudioSessionId());
                        mp.pause();

                    }
                    else if(mp != null && mp.getDuration() > 0){
                        imageButton2.setImageResource(R.drawable.ic_pause);

//                        int resID = getResources().getIdentifier("song1", "raw", getBaseContext().getPackageName()); //a1
//                        mp = MediaPlayer.create(getBaseContext(),resID);   //a1
                        Toast.makeText(Activity_1.this,
                                "Song 2 is Playing ^^^^^^!", Toast.LENGTH_SHORT).show();
                        int resID_Song2 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
                        mp = MediaPlayer.create(getBaseContext(),resID_Song2);
                        mp.start();
//                        System.out.print(mp.getAudioSessionId());


                    }else{
                        mp = new MediaPlayer();
                        int resID1 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
                        mp = MediaPlayer.create(getBaseContext(),resID1);

//                        System.out.println(resID1);

                        imageButton2.setImageResource(R.drawable.ic_pause);
                        Toast.makeText(Activity_1.this,
                                "Song 2 is Playing!", Toast.LENGTH_SHORT).show();
                        mp.start();



                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;

            case R.id.stop2:

                try{
                    Toast.makeText(Activity_1.this,
                            "Song 2 playing stopped!", Toast.LENGTH_SHORT).show();

                    imageButton2.setImageResource(R.drawable.ic_play);
                    mp.stop();
                    mp = null;
                }
                catch (Exception stopex2) {
                    stopex2.printStackTrace();
                }
                break;

            case R.id.Map:

                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?&daddr=%f,%f (%s)", 12.897852, 80.160976, "Sri Seshadri Swamigal Temple Location, Chennai, Tamil Nadu, India");
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intentMaps.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                try
                {
                    startActivity(intentMaps);
                }
                catch(ActivityNotFoundException ex)
                {
                    try
                    {
                        Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        startActivity(unrestrictedIntent);
                    }
                    catch(ActivityNotFoundException innerEx)
                    {
                        Toast.makeText(this, "Please install Google maps application", Toast.LENGTH_LONG).show();
                    }
                }
                break;

        }
    }

    public void onBackPressed() {
        if(mp != null && mp.isPlaying()) {

            mp.stop();
            Intent intent_A = new Intent(this, MainActivity.class);
            startActivity(intent_A);


        }
        else{
            Intent intent_1 = new Intent(this, MainActivity.class);
            startActivity(intent_1);
//            mp = null;
        }
    }


}
