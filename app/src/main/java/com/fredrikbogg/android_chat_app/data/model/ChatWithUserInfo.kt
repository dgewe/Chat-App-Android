package com.fredrikbogg.android_chat_app.data.model

import com.fredrikbogg.android_chat_app.data.db.entity.Chat
import com.fredrikbogg.android_chat_app.data.db.entity.UserInfo

data class ChatWithUserInfo(
    var mChat: Chat,
    var mUserInfo: UserInfo
)
