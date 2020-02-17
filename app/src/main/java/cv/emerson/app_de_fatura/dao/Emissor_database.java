package cv.emerson.app_de_fatura.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Emissor.class, version = 1)
public abstract class Emissor_database extends RoomDatabase {

    private static Emissor_database instance;

    public abstract EmissorDao emissorDao();

    public static synchronized Emissor_database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Emissor_database.class, "emissor_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static class Prenchiemissor_dbAsyncTask extends AsyncTask<Void, Void, Void> {
        private EmissorDao emissorDao;

        private Prenchiemissor_dbAsyncTask(Emissor_database dbe) {
            emissorDao = dbe.emissorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            emissorDao.insert(new Emissor(123456789, "nome1", "ponta d' Agua"));
            emissorDao.insert(new Emissor(78485, "nome2", "Calabaceira"));
            emissorDao.insert(new Emissor(414, "nome_emissoe4", "Paiol"));
            return null;
        }
    }


}
