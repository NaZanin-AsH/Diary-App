package com.example.mydiary;

import com.example.mydiary.entities.Note;

public interface NotesListener {
    void onNoteClicked(Note note , int position);
}
