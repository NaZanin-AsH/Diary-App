package com.example.mydiary.database;


import android.content.Context;
import  androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.mydiary.entities.Note;
import com.example.mydiary.mydao.MyDao;


@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase notesDatabase;

    public static synchronized NotesDatabase getNotesDatabase(Context context){
        if (notesDatabase==null){
            notesDatabase= Room.databaseBuilder(
                    context,
                    NotesDatabase.class,
                    "notes_db"
            ).build();
        }
        return notesDatabase;
    }
    public abstract MyDao myDao();
}
