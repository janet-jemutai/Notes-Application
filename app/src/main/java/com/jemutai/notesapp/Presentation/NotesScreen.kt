package com.jemutai.notesapp.Presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jemutai.notesapp.R

@Composable
fun  NotesScreen(
    state: NoteState,
    navController: NavController,
onEvent: (NotesEvent) ->Unit
){
    Scaffold  (
        topBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(16.dp),
                verticalAlignment =  Alignment.CenterVertically
            ){
                
                Text(text = stringResource(id = R.string.app_name),
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color =  MaterialTheme.colorScheme.onPrimary
                )
                
                IconButton(onClick = {
                    onEvent(NotesEvent.SortNotes)
                }) {

                    Icon(
                        imageVector =Icons.Rounded.List,contentDescription = "Sort Notes",
                        modifier = Modifier.size(35.dp),
                    tint =  MaterialTheme.colorScheme.onPrimary
                    )


                }

            }
        },
        
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.title.value =""
                state.description.value =""
                navController.navigate("AddNoteScreen")
            }) {

                Icon(imageVector = Icons.Rounded.Add , contentDescription = "Add Note")

            }
        }
    ) {

    }

}