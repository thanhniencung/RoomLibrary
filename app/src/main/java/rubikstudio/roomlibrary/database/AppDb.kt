package rubikstudio.roomlibrary.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import rubikstudio.roomlibrary.dao.ChatMessageDao
import rubikstudio.roomlibrary.model.ChatMessage

/**
 * Created by kiennguyen on 5/22/17.
 */
@Database(
        entities = arrayOf(ChatMessage::class),
        version = DbConfig.DATABASE_VERSION
)
abstract class AppDb : RoomDatabase() {
    abstract fun chatMessageDao(): ChatMessageDao
}