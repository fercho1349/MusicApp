package com.fgc.musicapp.activities.gallery

import com.fgc.musicapp.models.ProfileUser

class GalleryContract {

    interface PresenterInterface {
        fun getProfileUser()
        fun stop()
    }

    interface ViewInterface {
        fun displayProfileUser(profileUser: ProfileUser?)
        fun navigationToGalleryDetail()
    }

}