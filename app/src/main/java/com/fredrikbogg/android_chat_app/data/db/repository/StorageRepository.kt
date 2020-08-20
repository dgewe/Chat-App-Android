package com.fredrikbogg.android_chat_app.data.db.repository

import android.net.Uri
import com.fredrikbogg.android_chat_app.data.db.remote.FirebaseStorageSource
import com.fredrikbogg.android_chat_app.data.Result

class StorageRepository {
    private val firebaseStorageService = FirebaseStorageSource()

    fun updateUserProfileImage(userID: String, byteArray: ByteArray, b: (Result<Uri>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.uploadUserImage(userID, byteArray).addOnSuccessListener {
            b.invoke((Result.Success(it)))
        }.addOnFailureListener {
            b.invoke(Result.Error(it.message))
        }
    }
}