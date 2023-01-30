package com.semnazri.vgdb.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semnazri.vgdb.data.local.LikedGameLocalSource
import com.semnazri.vgdb.model.CacheGame

@Database(entities = [CacheGame::class], version = Migrations.DB_VERSION)
abstract class GameDatabase : RoomDatabase() {

    abstract fun cachedGameDao(): LikedGameLocalSource

}
