package com.jemutai.notesapp.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
   suspend fun insertNote(note: Note)

   @Delete
   suspend fun  deleteNote(note: Note)
    @Query("SELECT * FROM NOTE ORDER BY dateAdded")
    fun getNoteOrderedByDateAdded(): Flow<List<Note>>
  // suspend fun  getNoteOrderedByDateAdded():Flow<List<Note>>

    @Query("SELECT * FROM NOTE ORDER BY title  ASC")
     fun  getNoteOrderedByTitle():Flow<List<Note>>


}