import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.picpay.desafio.android.data.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg users: List<User>)

    @Query("DELETE from user")
    fun deleteAll()
}
    