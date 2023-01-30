package com.semnazri.vgdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.semnazri.vgdb.db.CacheConstants

@Entity(tableName = CacheConstants.GAME_TABLE_NAME)
data class CacheGame(
    @PrimaryKey
    @ColumnInfo(name = "games_id")
    var gameId: Long,

    @ColumnInfo(name = "games_name")
    var gameName: String? = "",

    @ColumnInfo(name = "games_rating")
    var gameRating: Double? = 0.0,

    @ColumnInfo(name = "img_url")
    var imgUrl: String? = "",

    @ColumnInfo(name = "release_date")
    var releaseDate: String? = ""
)