package ya.deneno.roomapp.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ya.deneno.roomapp.REPOSITORY
import ya.deneno.roomapp.db.NoteDatabase
import ya.deneno.roomapp.db.repository.NoteRealization
import ya.deneno.roomapp.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {
    val context = application

    fun initDataBase() {
        val noteDao = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(noteDao)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }


}