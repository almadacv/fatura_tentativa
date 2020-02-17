package cv.emerson.app_de_fatura.dao;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Produto_Repository {
    private ProdutoDao produtoDao;
    private LiveData<List<Produto>> tdproduto;

    public Produto_Repository(Application application) {
        Produto_database database = Produto_database.getInstance(application);
        produtoDao = database.produtoDao();
        tdproduto = produtoDao.selecttdproduto();
    }

    public void insert(Produto produto) {
        new InsertProdutoAsyncTask(produtoDao).execute(produto);
    }

    public void update(Produto produto) {
        new UpdateProdutoAsyncTask(produtoDao).execute(produto);

    }

    public void delete(Produto produto) {
        new DeleteProdutoAsyncTask(produtoDao).execute(produto);

    }

    public LiveData<List<Produto>> selecttdproduto() {
        return tdproduto;
    }

    private static class InsertProdutoAsyncTask extends AsyncTask<Produto, Void, Void> {
        private ProdutoDao produtoDao;

        private InsertProdutoAsyncTask(ProdutoDao produtoDao) {
            this.produtoDao = produtoDao;
        }

        @Override
        protected Void doInBackground(Produto... produtos) {
            produtoDao.insert(produtos[0]);
            return null;
        }
    }

    private static class UpdateProdutoAsyncTask extends AsyncTask<Produto, Void, Void> {
        private ProdutoDao produtoDao;

        private UpdateProdutoAsyncTask(ProdutoDao produtoDao) {
            this.produtoDao = produtoDao;
        }

        @Override
        protected Void doInBackground(Produto... produtos) {
            produtoDao.update(produtos[0]);
            return null;
        }
    }

    private static class DeleteProdutoAsyncTask extends AsyncTask<Produto, Void, Void> {
        private ProdutoDao produtoDao;

        private DeleteProdutoAsyncTask(ProdutoDao produtoDao) {
            this.produtoDao = produtoDao;
        }

        @Override
        protected Void doInBackground(Produto... produtos) {
            produtoDao.delete(produtos[0]);
            return null;
        }
    }


}
