package org.sandec.aplikasiyonexstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static String EXTRA_NAME = "NAME";
    public static String EXTRA_PRICE = "PRICE";
    public String EXTRA_FROM = "FROM";
    public String EXTRA_PHOTO = "PHOTO";

    private int total = 0;
    String name;
    String price;

    ImageView img_item_Photo;
    Button btn_Buy;
    TextView tv_item_Name, tv_item_Price, tv_item_From;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img_item_Photo = findViewById(R.id.img_item_photo);
        tv_item_Name = findViewById(R.id.tv_item_name);
        tv_item_Price = findViewById(R.id.tv_item_price);
        tv_item_From = findViewById(R.id.tv_item_from);
        btn_Buy = findViewById(R.id.btn_buy);

        name = getIntent().getStringExtra(EXTRA_NAME);
        Glide.with(this).load(getIntent().getStringExtra(EXTRA_PHOTO)).into(img_item_Photo);
        String from = getIntent().getStringExtra(EXTRA_FROM);
        price = getIntent().getStringExtra(EXTRA_PRICE);

        tv_item_Name.setText(name);
        tv_item_Price.setText(price);
        tv_item_From.setText(from);

        Button btnBuy = findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_buy:
                Intent moveIntent = new Intent(DetailActivity.this, CheckoutActivity.class);
                moveIntent.putExtra(EXTRA_NAME, name);
                moveIntent.putExtra(EXTRA_PRICE, price);
                startActivity(moveIntent);
                break;
        }
    }
}