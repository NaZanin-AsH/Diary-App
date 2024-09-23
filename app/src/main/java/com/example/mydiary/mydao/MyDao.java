package com.example.mydiary.mydao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mydiary.entities.Note;

import java.util.List;

@Dao
public interface MyDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<Note>getAllNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

}
