package com.jemutai.notesapp.Presentation

import com.jemutai.notesapp.Data.Note

sealed  interface NotesEvent {

    object SortNotes:NotesEvent

    data class  DeleteNote(
        val  note :Note
    ):NotesEvent

    data class SaveNote(
        val  title :String,
        val description :String
    ):NotesEvent
}