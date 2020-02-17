/*
package cv.emerson.app_de_fatura.dao;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Emissor_Repository {

    private EmissorDao emissorDao;
    private LiveData<List<Emissor>> tdemissor;

    public Emissor_Repository(Application application) {
        Emissor_database database = Emissor_database.getInstance(application);
        emissorDao = database.emissorDao();
        tdemissor = emissorDao.selecttdemissor();
    }

    public void insert(Emissor emissor) {
        new InsertEmissorAsyncTask(emissorDao).execute(emissor);
    }

    private static class InsertEmissorAsyncTask extends AsyncTask<Produto, Void, Void> {

        private Emissor emissorDao;

        private InsertEmissorAsyncTask(EmissorDao emissorDao) {
            this.emissorDao = emissorDao;
        }

        @Override
        protected Void doInBackground(Emissor... emissors) {
            emissorDao.i
            return null;
        }
    }
}
*/
