package com.worldline.shared.data.repository

import com.worldline.shared.data.local.Local
import com.worldline.shared.data.remote.Remote

class CommonPoiRepository(private val local: Local, private val remote: Remote) : PoiRepository {
}