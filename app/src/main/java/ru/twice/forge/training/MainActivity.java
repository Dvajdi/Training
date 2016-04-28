package ru.twice.forge.training;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

private SwipeRefreshLayout mSwipeRefreshLayout;
private TextView mCatTextView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mCatTextView = (TextView) findViewById(R.id.textViewCat);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);


        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        // Альтернативный способ
        //  mSwipeRefreshLayout.setColorSchemeColors(
        //  Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        // Устаревший код
        //  mSwipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
        //          android.R.color.holo_green_light,
        //          android.R.color.holo_orange_light,
        //          android.R.color.holo_red_light);
        }

@Override
public void onRefresh() {
        new Handler().postDelayed(new Runnable() {

@Override
public void run() {
        mSwipeRefreshLayout.setRefreshing(false);
        Random rand = new Random();
        mCatTextView.setText("Котика пора кормить. Его не кормили уже "
        + (1 + rand.nextInt(10)) + " мин.");
        }
        }, 4000);
        }
        }
