package cv.emerson.app_de_fatura.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface  EmissorDao {


    @Insert
    void insert(Emissor emissor);

    @Update
    void update(Emissor emissor);

    @Delete
    void delete(Emissor emissor);

    //@Query( "SELECT * FROM produto_table WHERE ")
    @Query("SELECT * FROM emissor_table ORDER BY NIF_emissor ASC")
    LiveData<List<Emissor>> selecttdemissor();
}
