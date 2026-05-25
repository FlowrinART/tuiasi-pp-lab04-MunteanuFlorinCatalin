package org.example

interface NoteRepo {

    fun save(note: Note)
    fun findAll(): List<Note>
    fun findById(id: String): Note?
    fun delete(id: String): Boolean
}