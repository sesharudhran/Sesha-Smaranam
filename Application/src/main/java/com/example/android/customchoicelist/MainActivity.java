
package com.example.android.customchoicelist;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView contactUs;
    Button songsButton, mahathmiyamButton;
    Toolbar mToolbar;
//    ImageButton mapOn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
//        mToolbar.setTitle("Sri Sesha Bhakthi");
//        mToolbar.setTitleTextColor(1);
        mToolbar.setTitle(Html.fromHtml("<font size=\"5\" color=\"#33691E\">" + "<b>"+ getString(R.string.app_name) +"</b>" +"</font>"));

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
                .withDrawerGravity(Gravity.START | Gravity.LEFT)
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
                                Toast.makeText(MainActivity.this, "Please install Google maps application", Toast.LENGTH_LONG).show();
                            }
                        }
                        return true;
                    }
                })

                .build();



        contactUs = (TextView) findViewById(R.id.contactus);
        songsButton = (Button) findViewById(R.id.Bhajans);
        mahathmiyamButton = (Button) findViewById(R.id.mahathmiyam);
//        mapOn = (ImageButton) findViewById(R.id.mapIcon);


        songsButton.setOnClickListener(this);
        mahathmiyamButton.setOnClickListener(this);
        contactUs.setOnClickListener(this);
//        mapOn.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Bhajans:

                try {
//                    Intent intent_1 = new Intent(this, Activity_1.class);

                    Intent intent_Bhajans = new Intent(this, PlayList.class);
                    startActivity(intent_Bhajans);
                }
                catch (Exception intent_Bhajansex){
                    intent_Bhajansex.printStackTrace();
                }
                break;

            case R.id.mahathmiyam:
                try {
                    Intent intent_mahathmiyam = new Intent(this, Activity_2.class);
                    startActivity(intent_mahathmiyam);
                }
                catch (Exception intent_mahathmiyamex){
                    intent_mahathmiyamex.printStackTrace();
                }
                break;

            case R.id.contactus:
                try {
                    final Intent intent_contactus = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://seshadri.info"));
                    startActivity(intent_contactus);
                }
                catch (Exception intent_contactusex){
                    intent_contactusex.printStackTrace();
                }

        }
    }

//    public void onBackPressed() {
//
//        return;
//    }
}
