package com.semnazri.vgdb.util

import com.orhanobut.hawk.Hawk

object PreferencesManager {
    val GAMESTRING : String = "eventKeyWord"

    var gameKeyword : String
        set(value){
            Hawk.put(GAMESTRING, value)
        }
        get() = Hawk.get(GAMESTRING)
}