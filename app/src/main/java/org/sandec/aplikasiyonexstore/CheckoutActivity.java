package org.sandec.aplikasiyonexstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView eNamaRacket;
    private EditText eNamaPembeli;
    private EditText eAlamat;
    private EditText eCatatan;
    private TextView eHarga;
    private Button btnBuy;
    private TextView eOutputRacket;
    private TextView eOutputPembeli;
    private TextView eOutputAlamat;
    private TextView eOutputCatatan;
    private TextView eOutputHarga;
    String name;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        eNamaRacket = findViewById(R.id.tv_item_name);
        eNamaPembeli = findViewById(R.id.idnama);
        eAlamat = findViewById(R.id.idalamat);
        eCatatan = findViewById(R.id.idcatatan);
        eHarga = findViewById(R.id.tv_item_price);
        btnBuy = findViewById(R.id.btn_buy);
        eOutputRacket = findViewById(R.id.idoutputracket);
        eOutputPembeli = findViewById(R.id.idoutputnama);
        eOutputAlamat = findViewById(R.id.idoutputalamat);
        eOutputCatatan = findViewById(R.id.idoutputcatatan);
        eOutputHarga = findViewById(R.id.idoutputharga);
        name = getIntent().getStringExtra(DetailActivity.EXTRA_NAME);
        price = getIntent().getStringExtra(DetailActivity.EXTRA_PRICE);
        eNamaRacket.setText(name);
        eHarga.setText(price);

        btnBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String inputNamaPembeli = eNamaPembeli.getText().toString();
        String inputAlamat = eAlamat.getText().toString();
        String inputCatatan = eCatatan.getText().toString();

        if (inputNamaPembeli.length()==0){
            eNamaPembeli.setError("Data tidak boleh kosong");
        } else {
            eOutputPembeli.setText(inputNamaPembeli);
        } if (inputAlamat.length()==0){
            eAlamat.setError("Data tidak boleh kosong");
        } else {
            eOutputAlamat.setText(inputAlamat);
        } if (inputCatatan.length()==0){
            eCatatan.setError("Data tidak boleh kosong");
        } else {
            eOutputCatatan.setText(inputCatatan);
            eOutputRacket.setText(name);
            eOutputHarga.setText(price);
        }
    }
}
