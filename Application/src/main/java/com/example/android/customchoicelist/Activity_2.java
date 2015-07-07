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
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.Locale;

public class Activity_2 extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar2);
        mToolbar.setTitle(Html.fromHtml("<font size=\"5\" color=\"#33691E\">" + "<b>" + getString(R.string.mahathmiyam_view_name) + "</b>" + "</font>"));

//        mToolbar.setTitle("Swami Mahamithyam");
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
                                Toast.makeText(Activity_2.this, "Please install Google maps application", Toast.LENGTH_LONG).show();
                            }
                        }
                        return true;
                    }
                })

                .build();

    }
//    public void onBackPressed() {
//        // do something on back.
//
//        this.finish();
//        return;
//    }


}