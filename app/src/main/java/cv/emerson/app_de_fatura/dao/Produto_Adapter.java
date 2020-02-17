package cv.emerson.app_de_fatura.dao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cv.emerson.app_de_fatura.R;

public class Produto_Adapter extends RecyclerView.Adapter<Produto_Adapter.ProdutoHolder> {
    private List<Produto> produtos = new ArrayList<>();

    @NonNull
    @Override
    public ProdutoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item, parent, false);
        return new ProdutoHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoHolder holder, int position) {
        Produto produtoatual = produtos.get(position);
        holder.nome_produto_adapter.setText(produtoatual.getNome_produto());
        holder.Qtd_produto.setText(String.valueOf(produtoatual.getQtd_produto()));
        holder.preco_unitario.setText(String.valueOf(produtoatual.getPrecouni_produto()));
        holder.precototal_adapter.setText(String.valueOf(produtoatual.getPrecototal_produto()));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public void prenchiproutosnarecicler(List<Produto> produtos) {
        this.produtos = produtos;
        notifyDataSetChanged();
    }

    public Produto daposicaodeproduto(int position) {
        return produtos.get(position);
    }

    class ProdutoHolder extends RecyclerView.ViewHolder {
        private TextView nome_produto_adapter;
        private TextView Qtd_produto;
        private TextView preco_unitario;
        private TextView precototal_adapter;

        public ProdutoHolder(@NonNull View itemView) {
            super(itemView);
            nome_produto_adapter = itemView.findViewById(R.id.nome_produto);
            Qtd_produto = itemView.findViewById(R.id.Qtd_produto);
            preco_unitario = itemView.findViewById(R.id.preco_unitario);
            precototal_adapter = itemView.findViewById(R.id.precototal_item);
        }
    }
}
