package com.allan.player.util

import android.database.Cursor

/**
 * Created by Regina on 2017-10-01.
 */
object CursorUtil {

    fun logCursor(cursor: Cursor) {
        cursor?.let {
            // move cursor
            it.moveToPosition(-1)
            while (it.moveToNext()) {
                for (index in 0 until it.columnCount) {
                    println("key = ${it.getColumnName(index)}, value = ${it.getString(index)}")
                }
            }
        }
    }
}