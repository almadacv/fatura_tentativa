package cv.emerson.app_de_fatura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionaFatura extends AppCompatActivity {
    public static final String EXTRA_NOME_PRO = "cv.emerson.app_de_fatura.EXTRA_NOME_PRO";
    public static final String EXTRA_IVA_PRO = "cv.emerson.app_de_fatura.EXTRA_IVA_PRO";
    public static final String EXTRA_QTD_PRO = "cv.emerson.app_de_fatura.EXTRA_QTD_PRO";
    public static final String EXTRA_PRECO_PRO = "cv.emerson.app_de_fatura.EXTRA_PRECO_PRO";

    private EditText produto_edit_main;
    private EditText iva_edit_main;
    private EditText qtd_edit_main;
    private EditText preco_edit_main;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_fatura);

        produto_edit_main = findViewById(R.id.add_Produto);
        iva_edit_main = findViewById(R.id.add_Iva);
        qtd_edit_main = findViewById(R.id.add_Qtd);
        preco_edit_main = findViewById(R.id.add_Preco);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Adicionar Fatura");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_fatura_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.guarda_fatura:
                guardar_fatura();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void guardar_fatura() {
        String nome_do_produto_add = produto_edit_main.getText().toString();
        String iva_add = iva_edit_main.getText().toString();
        String qtd_add = qtd_edit_main.getText().toString();
        String preco_add = preco_edit_main.getText().toString();

        if (nome_do_produto_add.trim().isEmpty() || iva_add.trim().isEmpty() || qtd_add.trim().isEmpty() || preco_add.trim().isEmpty()) {
            Toast.makeText(this, "Por favor insira as informaçoes requesitadas", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_NOME_PRO,nome_do_produto_add);
        data.putExtra(EXTRA_IVA_PRO,iva_add);
        data.putExtra(EXTRA_QTD_PRO,qtd_add);
        data.putExtra(EXTRA_PRECO_PRO,preco_add);

        setResult(RESULT_OK,data);
        finish();
    }

}
