package com.fabiohong.rubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddContatto extends AppCompatActivity implements View.OnClickListener {

    EditText nomecognome, cellulare, sito, email;
    ImageButton salva, rubrica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contatto);

        nomecognome= findViewById(R.id.nomecognome);
        cellulare= findViewById(R.id.cellulare);
        sito= findViewById(R.id.sito);
        email= findViewById(R.id.email);

        salva= findViewById(R.id.salva);
        rubrica= findViewById(R.id.rubrica);

        salva.setOnClickListener(this);
        rubrica.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.salva:    DBManager.getInstance(getApplicationContext()).getContattoDAO().insertContatto(new Contatto(nomecognome.getText().toString(),
                                                                                                                            cellulare.getText().toString(),
                                                                                                                            sito.getText().toString(),
                                                                                                                            email.getText().toString()));
                                intent= new Intent(AddContatto.this, Rubrica.class);
                                startActivity(intent);
                                break;
            case R.id.rubrica:  intent= new Intent(AddContatto.this, Rubrica.class);
                                startActivity(intent);
                                break;
        }
    }
}