package cv.emerson.app_de_fatura.dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "emissor_table")
public class Emissor {
    @PrimaryKey(autoGenerate = true)
    private int NIF_emissor;
    private String nome_emissor;
    private String adress_emissor;

    public Emissor(int NIF_emissor, String nome_emissor, String adress_emissor) {
        this.NIF_emissor = NIF_emissor;
        this.nome_emissor = nome_emissor;
        this.adress_emissor = adress_emissor;
    }

    public int getNIF_emissor() {
        return NIF_emissor;
    }

    public String getNome_emissor() {
        return nome_emissor;
    }

    public String getAdress_emissor() {
        return adress_emissor;
    }
}


