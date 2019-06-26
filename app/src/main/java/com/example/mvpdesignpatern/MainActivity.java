package com.example.mvpdesignpatern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpdesignpatern.model.MainModel;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText edtPanjang, edtLebar;
    private TextView tvLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        tvLuas = findViewById(R.id.tv_result);
        Button btnHitung = findViewById(R.id.btn_hitung);
        final MainPresenter presenter = new MainPresenter(this);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                boolean isEmpty = false;

                if (TextUtils.isEmpty(panjang)){
                    isEmpty = true;
                    edtPanjang.setError("isi");
                }

                if (TextUtils.isEmpty(lebar)){
                    isEmpty = true;
                    edtLebar.setError("isi");
                }

                if (!isEmpty){
                    int p = Integer.parseInt(panjang);
                    int l = Integer.parseInt(lebar);
                    presenter.hitungLuas(p, l);
                }

            }
        });
    }

    @Override
    public void showLuas(MainModel model) {
        tvLuas.setText(String.valueOf(model.getLuas()));
    }
}
