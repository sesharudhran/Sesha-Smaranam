

package com.example.android.customchoicelist;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Locale;

public class Activity_1 extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6;
    Button locateUS;
    Toolbar mToolbar;
    int counter1 = 0 , counter2 = 0;

    MediaPlayer mp1 = new MediaPlayer();
    MediaPlayer mp2 = new MediaPlayer();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar1);
        mToolbar.setTitle("Swami Smaranam");
        mToolbar.setTitle(Html.fromHtml("<font color=\"#33691E\">" + "<b>" + getString(R.string.app_name) + "</b>" + "</font>"));
        setSupportActionBar(mToolbar);

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

        mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar2);
        mToolbar.setTitle("Swami Mahamithyam");
        setSupportActionBar(mToolbar);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(true)
                .withHeaderBackground(R.drawable.header_image)
                .withProfileImagesClickable(false)
                .withSelectionListEnabledForSingleProfile(false)
                .build();

        DrawerBuilder result = new DrawerBuilder();
        result.withActivity(this)
                .withToolbar(mToolbar)
                .withTranslucentStatusBar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerResult)
                .withDrawerGravity(Gravity.START | Gravity.LEFT)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Locate Temple").withIcon(R.drawable.ic_location_on),
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?&daddr=%f,%f (%s)", 12.897852, 80.160976, "Sri Seshadri Swamigal Temple Location, Chennai, Tamil Nadu, India");
                        Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        intentMaps.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                        try {
                            startActivity(intentMaps);
                        } catch (ActivityNotFoundException ex) {
                            try {
                                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                startActivity(unrestrictedIntent);
                            } catch (ActivityNotFoundException innerEx) {
                                Toast.makeText(Activity_1.this, "Please install Google maps application", Toast.LENGTH_LONG).show();
                            }
                        }
                        return true;
                    }
                })

                .build();

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.play1:

                try {
                    if ((mp1 != null || mp2 != null) && (mp1.isPlaying() || mp2.isPlaying())) {
                        imageButton1.setImageResource(R.drawable.ic_play);
                        imageButton2.setImageResource(R.drawable.ic_play);

                        if (mp2.isPlaying()) {

                            mp2.pause();
                            int resID = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
                            mp1 = MediaPlayer.create(getBaseContext(), resID);
                            mp1.start();
                            imageButton1.setImageResource(R.drawable.ic_pause);

                        } else {
                            mp1.pause();

                        }

//                        Toast.makeText(Activity_1.this,
//                                "Song 1 is Paused!", Toast.LENGTH_SHORT).show();

                    }
//                    else if((mp1 != null && mp1.getDuration() > 0 ) && (!mp2.isPlaying())){
                    else if((mp1 != null) && (mp1.getDuration() ==0 && !mp1.isPlaying() && !mp2.isPlaying())){
                        imageButton1.setImageResource(R.drawable.ic_pause);
//                            int resID = getResources().getIdentifier("test", "raw", getBaseContext().getPackageName()); //a1
//                            mp = MediaPlayer.create(getBaseContext(),resID); //a1
                        Toast.makeText(Activity_1.this,
                                "Song 1 is Playing ******!", Toast.LENGTH_SHORT).show();
//                      int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());

//                      mp1 = MediaPlayer.create(getBaseContext(),resID_Song1);

                        int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
                        mp1 = MediaPlayer.create(getBaseContext(),resID_Song1);
                        imageButton1.setImageResource(R.drawable.ic_pause);
                        mp1.start();
                        counter1 = 0;


//                        if (counter1 == 0) {
//                            imageButton1.setImageResource(R.drawable.ic_pause);
////                            int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
////                            mp1 = MediaPlayer.create(getBaseContext(),resID_Song1);
//
////                            mp1.seekTo(mp1.getCurrentPosition());
//                            mp1.seekTo(0);
//                            mp1.start();
//
//                        }
//                        else{
//                            int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
//                            mp1 = MediaPlayer.create(getBaseContext(),resID_Song1);
//                            imageButton1.setImageResource(R.drawable.ic_pause);
//                            mp1.start();
//                            counter1 = 0;
//
//                        }


                    }else{
                        if ((mp1 != null) && (mp1.getDuration() > 0) && !mp2.isPlaying()) {

                            if (counter1 == 0) {
                                imageButton1.setImageResource(R.drawable.ic_pause);
                                mp1.seekTo(mp1.getCurrentPosition());
                                //                            mp1.seekTo(0);
                                mp1.start();

                            } else {
                                int resID_Song1 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());
                                mp1 = MediaPlayer.create(getBaseContext(), resID_Song1);
                                imageButton1.setImageResource(R.drawable.ic_pause);
                                mp1.start();
                                counter1 = 0;

                            }

                        }
                     else{

                            mp2.stop();
                        }

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
                    mp1.stop();
                    counter1 = counter1 + 1;
//                    mp1 = null;

                }
                catch (Exception stopex1){

                    stopex1.printStackTrace();

                }
                break;

            case R.id.play2:

                try {
                    if((mp1 != null || mp2 != null) && (mp1.isPlaying() || mp2.isPlaying())) {
                        imageButton1.setImageResource(R.drawable.ic_play);
                        imageButton2.setImageResource(R.drawable.ic_play);
                        Toast.makeText(Activity_1.this,
                                "Song 2 is Paused!", Toast.LENGTH_SHORT).show();
//                        System.out.print(mp.getAudioSessionId());

                        if (mp1.isPlaying()) {
                            mp1.pause();
                            int resID1 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
                            mp2 = MediaPlayer.create(getBaseContext(), resID1);
                            mp2.start();
                            imageButton2.setImageResource(R.drawable.ic_pause);
                        } else {
                            mp2.pause();

                        }


                    }
                    else if((mp2 != null && mp2.getCurrentPosition() > 0) && (!mp2.isPlaying())){
                        imageButton2.setImageResource(R.drawable.ic_pause);
                          //  mp2.getCurrentPosition();
//                        int resID = getResources().getIdentifier("song1", "raw", getBaseContext().getPackageName()); //a1
//                        mp = MediaPlayer.create(getBaseContext(),resID);   //a1
                        Toast.makeText(Activity_1.this,
                                "Song 2 is Playing ^^^^^^!", Toast.LENGTH_SHORT).show();
//                        int resID_Song2 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
//                        mp2 = MediaPlayer.create(getBaseContext(),resID_Song2);

                        if (counter2 ==0) {
                            imageButton2.setImageResource(R.drawable.ic_pause);
                            mp2.start();
                        }
                        else{
                            int resID_Song2 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
                            mp2 = MediaPlayer.create(getBaseContext(),resID_Song2);
                            imageButton2.setImageResource(R.drawable.ic_pause);
                            mp2.start();
                            counter2 =0;
                        }
//                        System.out.print(mp.getAudioSessionId());


                    }else{
                        if (!mp1.isPlaying()) {
//                            mp2 = new MediaPlayer();
                            int resID1 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());
                            mp2 = MediaPlayer.create(getBaseContext(), resID1);

//                        System.out.println(resID1);

                            imageButton2.setImageResource(R.drawable.ic_pause);
                            Toast.makeText(Activity_1.this,
                                    "Song 2 is Playing!", Toast.LENGTH_SHORT).show();
                            mp2.start();
                        }
                        else{
                            mp1.stop();

                        }

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
                    mp2.stop();
                    counter2 = counter2 + 1;
//                    mp2 = null;
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
        if(mp1 != null && mp1.isPlaying()) {

            mp1.stop();
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