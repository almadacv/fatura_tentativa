package cv.emerson.app_de_fatura;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cv.emerson.app_de_fatura.dao.Produto;
import cv.emerson.app_de_fatura.dao.ProdutoViewModel;
import cv.emerson.app_de_fatura.dao.Produto_Adapter;

public class MainActivity extends AppCompatActivity {
    private ProdutoViewModel produtoViewModel;
    public static final int ADD_FATURA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Fatura App");

        FloatingActionButton buttonadicionafatura = findViewById(R.id.adicona_main_button);
        buttonadicionafatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AdicionaFatura.class), ADD_FATURA_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final Produto_Adapter adapter = new Produto_Adapter();
        recyclerView.setAdapter(adapter);

        produtoViewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);
        produtoViewModel.selecttdproduto().observe(this, new Observer<List<Produto>>() {
            @Override
            public void onChanged(List<Produto> produtos) {
                adapter.prenchiproutosnarecicler(produtos);
            }
        });

        //keli e pa hrs ke swipe pa paga
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                produtoViewModel.delete(adapter.daposicaodeproduto(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Fatura Apagada", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    //pa pui sincroniza parci, kel botao
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sincronizar_menu:
                //cria kel funçao pa sync ku keycloak
                Toast.makeText(this, "Faturas sincronizadas com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_FATURA_REQUEST && resultCode == RESULT_OK) {
            String nome_do_produto = data.getStringExtra(AdicionaFatura.EXTRA_NOME_PRO);
            Float iva_do_produto = Float.parseFloat(data.getStringExtra(AdicionaFatura.EXTRA_IVA_PRO));
            int qtd_do_produto = Integer.parseInt(data.getStringExtra(AdicionaFatura.EXTRA_QTD_PRO));
            Float preco_do_produto = Float.parseFloat(data.getStringExtra(AdicionaFatura.EXTRA_PRECO_PRO));
            if (iva_do_produto==0){
                iva_do_produto=(float) 1;
            }
            Float precototal_do_produto = (preco_do_produto * iva_do_produto) * qtd_do_produto;

            Produto produto = new Produto(nome_do_produto, iva_do_produto, qtd_do_produto, precototal_do_produto, preco_do_produto);
            produtoViewModel.insert(produto);

            Toast.makeText(this, "Informaçoes Guardadas com Sucesso", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Informaçoes não Guardadas", Toast.LENGTH_LONG).show();

        }
    }
}
