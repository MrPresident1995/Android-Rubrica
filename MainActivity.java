package com.fabiohong.rubrica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nomecognome, cellulare, sito, email;
    ImageButton chiama, sms, visita_sito, manda_email, modifica, rubrica;
    Contatto c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        chiama= findViewById(R.id.chiama);
        sms= findViewById(R.id.sms);
        visita_sito= findViewById(R.id.visita_sito);
        manda_email= findViewById(R.id.manda_email);
        modifica= findViewById(R.id.modifica);
        rubrica= findViewById(R.id.rubrica);

        chiama.setOnClickListener(this);
        sms.setOnClickListener(this);
        visita_sito.setOnClickListener(this);
        manda_email.setOnClickListener(this);
        modifica.setOnClickListener(this);
        rubrica.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.chiama:   //intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + cellulare.getText()));

                                intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + cellulare.getText()));
                                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M &&
                                        ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                                        != PackageManager.PERMISSION_GRANTED) {
                                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                                    return ;
                                }

                                startActivity(intent);
                                break;
            case R.id.sms:  intent= new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: " + cellulare.getText()));
                            intent.putExtra("sms_body", "Contenuto sms");
                            startActivity(intent);
                            break;
            case R.id.visita_sito:  intent= new Intent(Intent.ACTION_VIEW);
                                    intent.setData(Uri.parse(sito.getText().toString()));
                                    //String url= "http://google.com";
                                    //intent.setData(Uri.parse(url));
                                    startActivity(intent);
                                    break;
            case R.id.manda_email:  intent= new Intent(Intent.ACTION_SEND);
                                    intent.setType("text/plain");
                                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email"});
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "Oggetto");
                                    intent.putExtra(Intent.EXTRA_TEXT, "Contenuto email");

                                    startActivity(Intent.createChooser(intent, "Invia email"));
                                    break;
            case R.id.modifica: intent= new Intent(MainActivity.this, ModContatto.class);
                                intent.putExtra("Contact", c);
                                startActivity(intent);
                                break;
            case R.id.rubrica:  intent= new Intent(MainActivity.this, Rubrica.class);
                                startActivity(intent);
                                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] results) {
        super.onRequestPermissionsResult(requestCode, permissions, results);

        for(int grantResults: results) {
            if(grantResults==PackageManager.PERMISSION_GRANTED) {
                Intent intent= new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + cellulare.getText()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }
}