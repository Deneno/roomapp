package ya.deneno.roomapp.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ya.deneno.roomapp.REPOSITORY
import ya.deneno.roomapp.model.NoteModel

class AddNoteViewModel: ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }
}