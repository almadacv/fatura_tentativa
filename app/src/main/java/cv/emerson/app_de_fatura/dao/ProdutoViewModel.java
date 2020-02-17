package cv.emerson.app_de_fatura.dao;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ProdutoViewModel extends AndroidViewModel {
    private Produto_Repository repository;
    private LiveData<List<Produto>> tdproduto;

    public ProdutoViewModel(@NonNull Application application) {
        super(application);
        repository = new Produto_Repository(application);
        tdproduto = repository.selecttdproduto();
    }

    public void insert(Produto produto) {
        repository.insert(produto);
    }

    public void delete(Produto produto) {
        repository.delete(produto);
    }

    public void update(Produto produto) {
        repository.update(produto);
    }
    public LiveData<List<Produto>> selecttdproduto(){
        return tdproduto;
    }
}
