package com.fabiohong.rubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ModContatto extends AppCompatActivity implements View.OnClickListener {

    EditText nomecognome, cellulare, sito, email;
    ImageButton salva, cancella, rubrica;
    static Contatto c;
    static ContattoDAO contattoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_contatto);

        nomecognome= findViewById(R.id.nomecognome);
        cellulare= findViewById(R.id.cellulare);
        sito= findViewById(R.id.sito);
        email= findViewById(R.id.email);

        Intent intent= getIntent();
        if(intent!= null) {
            c = (Contatto) intent.getSerializableExtra("Contact");
            nomecognome.setText(c.getNomecognome());
            cellulare.setText(c.getCellulare());
            sito.setText(c.getSito());
            email.setText(c.getEmail());
        }

        salva= findViewById(R.id.salva);
        cancella= findViewById(R.id.cancella);
        rubrica= findViewById(R.id.rubrica);

        salva.setOnClickListener(this);
        cancella.setOnClickListener(this);
        rubrica.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.salva:    c.setNomecognome(nomecognome.getText().toString());
                                c.setCellulare(cellulare.getText().toString());
                                c.setSito(sito.getText().toString());
                                c.setEmail(email.getText().toString());
                                DBManager.getInstance(getApplicationContext()).getContattoDAO().updateContatto(c);
                                intent= new Intent(ModContatto.this, Rubrica.class);
                                startActivity(intent);
                                break;
            case R.id.cancella: DBManager.getInstance(getApplicationContext()).getContattoDAO().deleteContact(c);
                                intent= new Intent(ModContatto.this, Rubrica.class);
                                startActivity(intent);
                                break;
            case R.id.rubrica:  intent= new Intent(ModContatto.this, Rubrica.class);
                                startActivity(intent);
                                break;
        }
    }
}