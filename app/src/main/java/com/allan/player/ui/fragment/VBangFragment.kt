package com.allan.player.ui.fragment

import android.content.AsyncQueryHandler
import android.content.ContentResolver
import android.database.Cursor
import android.graphics.Color
import android.os.AsyncTask
import android.os.Handler
import android.os.Message
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.allan.player.R
import com.allan.player.base.BaseFragment
import com.allan.player.util.CursorUtil

/**
 * Created by Regina on 2017-09-24.
 */
class VBangFragment : BaseFragment() {



    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_vbang, null)
    }


    override fun initData() {
        // load music list
        // start new thread
        val resolver = context.contentResolver
//        MyAudioTask().execute(resolver)

        val handler = object: AsyncQueryHandler(resolver){

            override fun onQueryComplete(token: Int, cookie: Any?, cursor: Cursor?) {
                // query complete callback on main thread
                cursor?.let {
                    CursorUtil.logCursor(cursor)
                }
            }
        }

        handler.startQuery(0, null, MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                arrayOf(MediaStore.Audio.Media.DATA,
                        MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DISPLAY_NAME,
                        MediaStore.Audio.Media.ARTIST),
                null, null, null)

    }

    class MyAudioTask: AsyncTask<ContentResolver, Void, Cursor>() {

        override fun doInBackground(vararg p0: ContentResolver?): Cursor? {
            val cursor = p0[0]?.query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                    arrayOf(MediaStore.Audio.Media.DATA,
                            MediaStore.Audio.Media.SIZE,
                            MediaStore.Audio.Media.DISPLAY_NAME,
                            MediaStore.Audio.Media.ARTIST),
                    null, null, null)

            return cursor
        }


        override fun onPostExecute(result: Cursor?) {
            super.onPostExecute(result)
            val cursor = result as Cursor
            CursorUtil.logCursor(cursor)
        }
    }

}