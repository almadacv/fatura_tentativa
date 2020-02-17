package cv.emerson.app_de_fatura.dao;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Produto.class, version = 1)
public abstract class Produto_database extends RoomDatabase {

    private static Produto_database instance;

    public abstract ProdutoDao produtoDao();

    public static synchronized Produto_database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Produto_database.class, "produto_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PrenchidbAsyncTask(instance).execute();
        }
    };

    private static class PrenchidbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProdutoDao produtoDao;

        private PrenchidbAsyncTask(Produto_database db) {
            produtoDao = db.produtoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            produtoDao.insert(new Produto("Acer GFX", (float) 15.4, 45, 450, 74));
            produtoDao.insert(new Produto("HP Pavilon", (float) 41.5, 54, 050, 774));
            produtoDao.insert(new Produto("Honor Lite 10", (float) 10, 1, 1, 170));
            return null;
        }
    }
}
