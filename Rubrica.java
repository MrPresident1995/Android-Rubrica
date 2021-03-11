package com.fabiohong.rubrica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

public class Rubrica extends AppCompatActivity implements View.OnClickListener {

    RecyclerView lista;
    ImageButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubrica);

        lista= findViewById(R.id.lista);

        //DBManager.getInstance(getApplicationContext()).getContattoDAO().deleteAll();

        //DBManager.getInstance(getApplicationContext()).getContattoDAO().insertContatto(new Contatto("pippo", "123", "http://google.com", "pippo@pippo.pippo"));
        //DBManager.getInstance(getApplicationContext()).getContattoDAO().insertContatto(new Contatto("mario", "123", "http://wikipedia.com", "sara@sara.sara"));
        //DBManager.getInstance(getApplicationContext()).getContattoDAO().insertContatto(new Contatto("rossi", "123", "http://youtube.com", "andrea@andrea.andrea"));

        List<Contatto> contatto=  DBManager.getInstance(getApplicationContext()).getContattoDAO().getContatto();

        ContattoAdapter ad_c= new ContattoAdapter(contatto);
        lista.setAdapter(ad_c);
        lista.setLayoutManager(new LinearLayoutManager(this));

        add= findViewById(R.id.add);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Rubrica.this, AddContatto.class);
        startActivity(intent);
    }
}