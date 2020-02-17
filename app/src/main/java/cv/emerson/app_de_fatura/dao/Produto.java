package cv.emerson.app_de_fatura.dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produto_table")
public class Produto {
    @PrimaryKey(autoGenerate = true)
    private int id_produto;
    private String nome_produto;
    private float iva_produto;
    private int qtd_produto;
    private float precototal_produto;
    private float precouni_produto;

    public Produto(String nome_produto, float iva_produto, int qtd_produto, float precototal_produto, float precouni_produto) {
        this.nome_produto = nome_produto;
        this.iva_produto = iva_produto;
        this.qtd_produto = qtd_produto;
        this.precototal_produto = precototal_produto;
        this.precouni_produto = precouni_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public float getIva_produto() {
        return iva_produto;
    }

    public int getQtd_produto() {
        return qtd_produto;
    }

    public float getPrecototal_produto() {
        return precototal_produto;
    }

    public float getPrecouni_produto() {
        return precouni_produto;
    }
}
