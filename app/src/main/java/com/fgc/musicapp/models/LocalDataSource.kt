package com.fgc.musicapp.models

import android.app.Application
import com.oselot.android.tlilektik.models.ProfileUserDao
import com.oselot.android.tlilektik.models.ProfileUserRoomDatabase
import io.reactivex.Observable
import kotlin.concurrent.thread

open class LocalDataSource (application: Application) {

    private val profileUserDao: ProfileUserDao

    open val allProfileUser: Observable<ProfileUser>

    init {
        val db = ProfileUserRoomDatabase.getDatabase(application)
        profileUserDao = db.profileUserDao()
        allProfileUser = profileUserDao.getProfileUser()
    }


    open fun insert(profileUser: ProfileUser) {
        thread {
            profileUserDao.insert(profileUser)
        }
    }

    open fun update(profileUser: ProfileUser) {
        thread {
            profileUserDao.update(profileUser)
        }
    }

}