package com.fabiohong.rubrica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContattoAdapter extends RecyclerView.Adapter<ContattoViewHolder> {

    List<Contatto> contatto;

    public ContattoAdapter(List<Contatto> contatto) {
        this.contatto = contatto;
    }

    @NonNull
    @Override
    public ContattoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contatto, parent, false);
        return new ContattoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ContattoViewHolder holder, int position) {
        Contatto c= contatto.get(position);
        holder.setC(c);
    }

    @Override
    public int getItemCount() {
        return contatto.size();
    }
}
