package org.sandec.aplikasiyonexstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRackets;
    private ArrayList<Racket> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRackets = findViewById(R.id.rv_racket);
        rvRackets.setHasFixedSize(true);

        list.addAll(RacketsData.getListData());
        showListAdapter();
    }

    private void showListAdapter() {
        rvRackets.setLayoutManager(new LinearLayoutManager(this));
        CardViewRacketAdapter cardViewRacketAdapter = new CardViewRacketAdapter(list);
        rvRackets.setAdapter(cardViewRacketAdapter);
    }
}

