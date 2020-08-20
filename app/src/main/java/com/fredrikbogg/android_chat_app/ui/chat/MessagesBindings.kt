package com.fredrikbogg.android_chat_app.ui.chat

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fredrikbogg.android_chat_app.data.db.entity.Message
import kotlin.math.abs

@BindingAdapter("bind_messages_list")
fun bindMessagesList(listView: RecyclerView, items: List<Message>?) {
    items?.let {
        (listView.adapter as MessagesListAdapter).submitList(items)
        listView.scrollToPosition(items.size - 1)
    }
}

@BindingAdapter("bind_message", "bind_message_viewModel")
fun View.bindShouldMessageShowTimeText(message: Message, viewModel: ChatViewModel) {
    val halfHourInMilli = 1800000
    val index = viewModel.messagesList.value!!.indexOf(message)

    if (index == 0) {
        this.visibility = View.VISIBLE
    } else {
        val messageBefore = viewModel.messagesList.value!![index - 1]

        if (abs(messageBefore.epochTimeMs - message.epochTimeMs) > halfHourInMilli) {
            this.visibility = View.VISIBLE
        } else {
            this.visibility = View.GONE
        }
    }
}

