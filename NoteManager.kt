package org.example

import java.io.File
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class NoteManager : NoteRepo {

    private val dir = File("notes")

    init {
        if (!dir.exists()) {
            dir.mkdir()
        }
    }

    override fun save(note: Note) {
        val file = File(dir, note.id + ".txt")

        file.writeText(
            note.id + "\n" +
                    note.author + "\n" +
                    note.date + "\n" +
                    note.time + "\n" +
                    note.text
        )
    }

    override fun findAll(): List<Note> {
        val list = mutableListOf<Note>()
        val files = dir.listFiles() ?: return list

        for (file in files) {
            val note = fileToNote(file)
            if (note != null) {
                list.add(note)
            }
        }
        return list
    }

    override fun findById(id: String): Note? {
        val file = File(dir, id + ".txt")
        if (!file.exists()) return null
        return fileToNote(file)
    }

    override fun delete(id: String): Boolean {
        val file = File(dir, id + ".txt")
        return file.exists() && file.delete()
    }

    private fun fileToNote(file: File): Note? {
        val lines = file.readLines()
        if (lines.size < 5) return null

        val id = lines[0]
        val author = lines[1]
        val date = lines[2]
        val time = lines[3]

        var text = ""
        for (i in 4 until lines.size) {
            text += lines[i] + "\n"
        }

        return Note(id, author, date, time, text)
    }

    private fun nextId(): String {
        val notes = findAll()
        if (notes.isEmpty()) return "1"

        val max = notes.maxOf { it.id.toLong() }
        return (max + 1).toString()
    }

    fun create(user: User, text: String) {
        val id = nextId()
        val date = LocalDate.now().toString()
        val time = LocalTime.now().format(
            DateTimeFormatter.ofPattern("HH:mm:ss")
        )

        val note = Note(id, user.name, date, time, text)
        save(note)

        println("Saved with id: $id")
    }
}