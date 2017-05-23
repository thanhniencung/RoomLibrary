package rubikstudio.roomlibrary.repository

import android.app.Activity
import android.arch.persistence.room.Room
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rubikstudio.roomlibrary.dao.ChatMessageDao
import rubikstudio.roomlibrary.database.AppDb
import rubikstudio.roomlibrary.database.DbConfig
import rubikstudio.roomlibrary.model.ChatMessage

/**
 * Created by kiennguyen on 5/22/17.
 */
class ChatMessageRepo (activity: Activity) {
    var chatMessageDao:ChatMessageDao? = null

    init {
        try {
            var appDb = Room.databaseBuilder(activity, AppDb::class.java, DbConfig.DATABASE_NAME).build()
            chatMessageDao = appDb.chatMessageDao();
        } catch (e:Exception) {
            e.printStackTrace();
        }
    }

    fun insert(chatMessage: ChatMessage) : Unit {
        Single.fromCallable {
            chatMessageDao?.insert(chatMessage)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe();
    }

    fun loadMessage() : Flowable<List<ChatMessage>>? {
        return chatMessageDao?.loadMessage();
    }
}