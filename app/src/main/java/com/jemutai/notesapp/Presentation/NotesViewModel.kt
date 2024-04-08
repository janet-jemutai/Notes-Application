package com.jemutai.notesapp.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jemutai.notesapp.Data.Note
import com.jemutai.notesapp.Data.NoteDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel(
    private val  dao: NoteDao
) : ViewModel(){

    private  val   isSortedByDateAdded = MutableStateFlow(true)

    private  val  notes =
        isSortedByDateAdded.flatMapLatest {  sort ->
            if (sort) {
           dao.getNoteOrderedByDateAdded()

            }
            else {
                dao.getNoteOrderedByTitle()
            }
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())





    fun  onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    dao.deleteNote(event.note)
                }
            }

            is NotesEvent.SaveNote -> {



            }


            NotesEvent.SortNotes -> {

                isSortedByDateAdded.value = ! isSortedByDateAdded.value
            }


        }
    }
}