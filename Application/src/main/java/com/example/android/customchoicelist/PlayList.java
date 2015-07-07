package com.example.android.customchoicelist;

/**
 * Created by vabirba on 7/7/15.
 */

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class PlayList extends AppCompatActivity implements OnItemClickListener {

    String _songPlaying = null;
    MediaPlayer mp = new MediaPlayer();
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.swami_smaranam);

        mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbarSwami);
        mToolbar.setTitle(Html.fromHtml("<font size=\"5\" color=\"#33691E\">" + "<b>" + getString(R.string.title_activity_list_view) + "</b>" + "</font>"));

        setSupportActionBar(mToolbar);


        final String[] Song_List =
                new String[]{"Swami Smaranam", "Mahathmiyam", "Sri Swamigal Potri", "Saranagathi Song", "Sri Padhuka Song", "Sri Managala Arthi", "", "", ""};

        ListView lv = (ListView) findViewById(R.id.playList);
        CustomArrayAdapter ca = new CustomArrayAdapter(getApplicationContext(),Song_List);
        lv.setAdapter(ca);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView l, View v, int position, long id) {


        switch (position) {

            case 1:

                int resID_SongA = getResources().getIdentifier("audiomahathmiyam", "raw", getBaseContext().getPackageName());


                if (!mp.isPlaying()) {


                    mp = MediaPlayer.create(getBaseContext(), resID_SongA);
                    mp.start();

                    Toast.makeText(this, "Sri Swamigal Mahathmiyam playing ...", Toast.LENGTH_SHORT).show();

                    _songPlaying = "song1";

                } else {
                    if (_songPlaying == "song1") {
                        Toast.makeText(this, "Sri Swamigal Mahathmiyam stopped!", Toast.LENGTH_SHORT).show();
                        mp.stop();

                        _songPlaying = null;

                    } else {

                        mp.stop();
                        mp = MediaPlayer.create(getBaseContext(), resID_SongA);
                        Toast.makeText(this, "Sri Swamigal Mahathmiyam playing ...", Toast.LENGTH_SHORT).show();
                        mp.start();
                        _songPlaying = "song1";
                    }
                }
                break;


            case 2:

                int resID_Song2 = getResources().getIdentifier("sathgurusriseshadriswamigalpotri", "raw", getBaseContext().getPackageName());


                if (!mp.isPlaying()) {


                    mp = MediaPlayer.create(getBaseContext(), resID_Song2);
                    mp.start();

                    Toast.makeText(this, "Sri Swamigal Potri song playing ...", Toast.LENGTH_SHORT).show();

                    _songPlaying = "song2";

                } else {
                    if (_songPlaying == "song2") {
                        Toast.makeText(this, "Sri Swamigal Potri song stopped!", Toast.LENGTH_SHORT).show();
                        mp.stop();

                        _songPlaying = null;

                    } else {

                        mp.stop();
                        mp = MediaPlayer.create(getBaseContext(), resID_Song2);
                        Toast.makeText(this, "Sri Swamigal Potri song playing ...", Toast.LENGTH_SHORT).show();
                        mp.start();
                        _songPlaying = "song2";
                    }
                }
                break;

            case 3:

                int resID_Song3 = getResources().getIdentifier("athmavinthagamsong", "raw", getBaseContext().getPackageName());


                if (!mp.isPlaying()) {


                    mp = MediaPlayer.create(getBaseContext(), resID_Song3);
                    mp.start();

                    Toast.makeText(this, "Sri Swamigal Saranagathi song playing ...", Toast.LENGTH_SHORT).show();

                    _songPlaying = "song3";

                } else {
                    if (_songPlaying == "song3") {
                        Toast.makeText(this, "Sri Swamigal Saranagathi song stopped!", Toast.LENGTH_SHORT).show();
                        mp.stop();

                        _songPlaying = null;

                    } else {

                        mp.stop();
                        mp = MediaPlayer.create(getBaseContext(), resID_Song3);
                        Toast.makeText(this, "Sri Swamigal Saranagathi song playing ...", Toast.LENGTH_SHORT).show();
                        mp.start();
                        _songPlaying = "song3";
                    }
                }
                break;


            case 4:

                int resID_Song4 = getResources().getIdentifier("padukapujasong", "raw", getBaseContext().getPackageName());

                if (!mp.isPlaying()) {



                    mp = MediaPlayer.create(getBaseContext(), resID_Song4);
                    Toast.makeText(this, "Sri Padhuka song playing ...", Toast.LENGTH_SHORT).show();
                    mp.start();
                    _songPlaying = "song4";

                } else {
                    if (_songPlaying == "song4") {
                        Toast.makeText(this, "Sri Padhuka song stopped!", Toast.LENGTH_SHORT).show();
                        mp.stop();
                        _songPlaying = null;


                    } else {

                        mp.stop();
                        mp = MediaPlayer.create(getBaseContext(), resID_Song4);
                        Toast.makeText(this, "Sri Padhuka song playing ...", Toast.LENGTH_SHORT).show();
                        mp.start();
                        _songPlaying = "song4";

                    }
                }
                break;


            case 5:

                int resID_Song5 = getResources().getIdentifier("mangalaaarti", "raw", getBaseContext().getPackageName());

                if (!mp.isPlaying()) {


                    mp = MediaPlayer.create(getBaseContext(), resID_Song5);
                    Toast.makeText(this, "Sri Mangala Arthi song played...", Toast.LENGTH_SHORT).show();
                    mp.start();
                    _songPlaying = "song5";

                } else {

                    if (_songPlaying == "song5") {
                        Toast.makeText(this, "Sri Mangala Arthi song stopped!", Toast.LENGTH_SHORT).show();
                        mp.stop();
                        _songPlaying = null;


                    } else {

                        mp.stop();
                        mp = MediaPlayer.create(getBaseContext(), resID_Song5);
                        Toast.makeText(this, "Sri Mangala Arthi song playing...", Toast.LENGTH_SHORT).show();
                        mp.start();
                        _songPlaying = "song5";

                    }
                }
                break;
        }

    }

    @Override
    public void onDestroy() {
        if (mp != null){
            super.onDestroy();
            mp.reset();
            mp.release();
            mp = null;

        }

    }



}
