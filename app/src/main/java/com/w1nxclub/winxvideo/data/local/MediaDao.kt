package com.w1nxclub.winxvideo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.w1nxclub.winxvideo.data.model.Media

@Dao
interface MediaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(media: Media)

    @Query("delete from media where id =:id")
    suspend fun deleteMedia(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM media WHERE id = :mediaId LIMIT 1)")
    suspend fun checkMediaExists(mediaId: Int): Boolean

    @Query("SELECT * FROM media")
    fun getAllMedia(): LiveData<List<Media>>

}