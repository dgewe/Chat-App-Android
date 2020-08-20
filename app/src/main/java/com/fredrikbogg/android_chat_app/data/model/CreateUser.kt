package com.fredrikbogg.android_chat_app.data.model

data class CreateUser(
    var displayName: String = "",
    var email: String = "",
    var password: String = ""
)