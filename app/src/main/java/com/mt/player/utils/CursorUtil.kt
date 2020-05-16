package com.mt.player.utils

import android.database.Cursor
import android.util.Log

object CursorUtil {
    fun logCursor(cursor: Cursor) {
        cursor?.let {
            Log.e("mengteng", "logCursor1 cursor = $cursor")
            //先将cursor游标复位
            it.moveToPosition(-1)
            Log.e("mengteng", "logCursor2 cursor = $cursor")
            while (it.moveToNext()) {
                Log.e("mengteng", "logCursor3 cursor = $cursor")
                // until 是不包含最后一个数据
                for (index in 0 until it.columnCount) {
                    Log.e("mengteng", "logCursor key = ${it.getColumnName(index)} -- value = ${it.getString(index)}")
                }
            }
        }
    }
}