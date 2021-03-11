package com.fabiohong.rubrica;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Contatto implements Serializable {
    @PrimaryKey (autoGenerate = true) private int id;

    @ColumnInfo private String nomecognome;
    @ColumnInfo private String cellulare;
    @ColumnInfo private String sito;
    @ColumnInfo private String email;

    public Contatto(){}

    public Contatto(String nomecognome, String cellulare, String sito, String email) {
        this.nomecognome= nomecognome;
        this.cellulare= cellulare;
        this.sito= sito;
        this.email= email;
    }

    public int getId() {
        return id;
    }

    public String getNomecognome() {
        return nomecognome;
    }

    public String getCellulare() {
        return cellulare;
    }

    public String getSito() {
        return sito;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomecognome(String nomecognome) { this.nomecognome = nomecognome; }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public void setSito(String sito) {
        this.sito = sito;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
