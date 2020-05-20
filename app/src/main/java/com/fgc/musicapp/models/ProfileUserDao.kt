package com.oselot.android.tlilektik.models

import androidx.room.*
import com.fgc.musicapp.models.ProfileUser
import io.reactivex.Observable

@Dao
interface ProfileUserDao {
    @Query("SELECT * from profileuser_table")
    fun getProfileUser(): Observable<ProfileUser>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: ProfileUser)

    @Update
    fun update(note: ProfileUser)
}