package com.fabiohong.rubrica;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContattoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Button nomecognome;
    Contatto c;

    public ContattoViewHolder(@NonNull View itemView) {
        super(itemView);
        nomecognome= itemView.findViewById(R.id.nomecognome);
        nomecognome.setOnClickListener(this);
    }

    public void setC(Contatto c) {
        this.c= c;
        nomecognome.setText(c.getNomecognome());
    }

    @Override
    public void onClick(View v) {
        Rubrica r= (Rubrica) v.getContext();
        Intent intent= new Intent(r, MainActivity.class);
        intent.putExtra("Contact", c);
        r.startActivity(intent);
    }
}
