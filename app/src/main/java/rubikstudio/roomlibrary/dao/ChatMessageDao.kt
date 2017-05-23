package rubikstudio.roomlibrary.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import rubikstudio.roomlibrary.model.ChatMessage

/**
 * Created by kiennguyen on 5/22/17.
 */
@Dao
interface ChatMessageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(message: ChatMessage)

    @Query("SELECT * FROM chat_table")
    fun loadMessage(): Flowable<List<ChatMessage>>
}