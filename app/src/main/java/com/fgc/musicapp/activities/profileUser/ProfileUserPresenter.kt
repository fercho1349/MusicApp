package com.fgc.musicapp.activities.profileUser

import com.fgc.musicapp.models.LocalDataSource
import com.fgc.musicapp.models.ProfileUser

class ProfileUserPresenter (private var viewInterface: ProfileUserContract.ViewInterface,
                            private var dataSource: LocalDataSource
): ProfileUserContract.PresenterInterface {

    override fun addProfileUser(username: String, name: String, lastname: String, description: String) {
        if (username.isEmpty() || description.isEmpty()) {
            viewInterface.showToast("Ingrese los datos requeridos")
        } else {
            val profileUser = ProfileUser(username,name, lastname, description)
            dataSource.insert(profileUser)
            viewInterface.navigationToGallery()
        }
    }
}