package com.example.cardvisits

import android.app.Application
import com.example.cardvisits.data.AppDatabase
import com.example.cardvisits.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}
