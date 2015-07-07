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
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.net.Uri;




public class MainActivity extends Activity implements View.OnClickListener {

    TextView contactUs;
    Button songsButton, mahathmiyamButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        contactUs = (TextView) findViewById(R.id.contactus);
        songsButton = (Button) findViewById(R.id.Bhajans);
        mahathmiyamButton = (Button) findViewById(R.id.mahathmiyam);


        songsButton.setOnClickListener(this);
        mahathmiyamButton.setOnClickListener(this);
        contactUs.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.Bhajans:

//                setContentView(R.layout.activity_1);

                Intent intent_1 = new Intent(this, Activity_1.class);
                startActivity(intent_1);
                break;

            case R.id.mahathmiyam:

                Intent intent_2 = new Intent(this, Activity_2.class);
                startActivity(intent_2);
                break;

            case R.id.contactus:
                final Intent intent_3 = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://seshadri.info"));
                startActivity(intent_3);

        }
    }

    public void onBackPressed() {

        return;
    }
}
