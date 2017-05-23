package rubikstudio.roomlibrary.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import rubikstudio.roomlibrary.converter.ChatMessageConverter

/**
 * Created by kiennguyen on 5/22/17.
 */
@Entity(tableName = "chat_table")
@TypeConverters(ChatMessageConverter::class)
data class ChatMessage (
    @PrimaryKey(autoGenerate = true)
    val id:Long,

    val message:String? = null,
    val time:Long? = null,
    val sender:Sender? = null
)