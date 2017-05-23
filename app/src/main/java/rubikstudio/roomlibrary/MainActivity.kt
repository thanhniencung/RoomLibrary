package rubikstudio.roomlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rubikstudio.roomlibrary.model.ChatMessage
import rubikstudio.roomlibrary.model.Sender
import rubikstudio.roomlibrary.repository.ChatMessageRepo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sender = Sender("Ryan Nguyen")
        val message = ChatMessage(0, "message", System.currentTimeMillis(), sender)

        val chatRepo = ChatMessageRepo(this)

        chatRepo?.insert(message)

        chatRepo?.loadMessage()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{ listMessage ->
                    for (chatMessage in listMessage) {
                        println(chatMessage.id)
                    }
                }
    }
}
