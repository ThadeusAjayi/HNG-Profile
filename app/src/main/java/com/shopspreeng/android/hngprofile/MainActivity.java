package com.shopspreeng.android.hngprofile;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.os.Build.VERSION_CODES.M;
import static com.shopspreeng.android.hngprofile.R.id.slack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CollapsingToolbarLayout mToolbar;

    TextView github, twitter, slack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToolbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mToolbar.setExpandedTitleTypeface(Typeface.MONOSPACE);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mailMe = new Intent(Intent.ACTION_SEND);
                mailMe.setType("text/email");
                mailMe.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"ainojie@gmail.com"});  //developer 's email
                mailMe.putExtra(Intent.EXTRA_SUBJECT,
                        "Nice to meet you"); // Email 's Subject
                mailMe.putExtra(Intent.EXTRA_TEXT, "Dear Ajayi Thadeus, \n" + "");
                startActivity(Intent.createChooser(mailMe,"Select Mail Client"));
            }
        });

        ImageView profile = (ImageView) findViewById(R.id.poster);

        Picasso.with(this).load(R.drawable.profile).fit().into(profile);

        github = (TextView) findViewById(R.id.github_detail);
        twitter = (TextView) findViewById(R.id.twitter_detail);
        slack = (TextView) findViewById(R.id.slack_detail);

        github.setText(R.string.git);
        twitter.setText(R.string.twit);
        slack.setText(R.string.slak);

        github.setOnClickListener(this);
        twitter.setOnClickListener(this);
        slack.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.github_detail:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_details))));
                break;
            case R.id.twitter_detail:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitter_details))));
                break;
            case R.id.slack_detail:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.slack_details))));
                break;
            default:
                break;
        }

    }
}
