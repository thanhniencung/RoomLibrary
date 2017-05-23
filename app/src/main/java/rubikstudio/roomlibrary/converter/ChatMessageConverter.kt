package rubikstudio.roomlibrary.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import rubikstudio.roomlibrary.model.Sender

/**
 * Created by kiennguyen on 5/22/17.
 */
class ChatMessageConverter {
    @TypeConverter
    fun stringToSender(data : String) : Sender {
        return Gson().fromJson(data, Sender::class.java)
    }

    @TypeConverter
    fun senderToString(data : Sender) : String {
        return Gson().toJson(data)
    }
}