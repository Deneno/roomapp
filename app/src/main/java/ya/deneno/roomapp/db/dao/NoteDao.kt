package ya.deneno.roomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ya.deneno.roomapp.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("select * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

}