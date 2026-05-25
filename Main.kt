package org.example

fun main() {

    val user = User("Catalin_Linux")
    val manager = NoteManager()

    while (true) {

        println("\nMenu")
        println("1 - List notes")
        println("2 - Load note")
        println("3 - Create note")
        println("4 - Delete note")
        println("0 - Exit")

        print("Choose: ")
        val opt = readLine()

        when (opt) {

            "1" -> {
                val notes = manager.findAll()

                if (notes.isEmpty()) {
                    println("No notes.")
                } else {
                    println("\n=== NOTES ===")
                    for (n in notes) {
                        println("ID: ${n.id}")
                        println("Author: ${n.author}")
                        println("Date: ${n.date}")
                        println("Time: ${n.time}")
                        println("Text: ${n.text}")
                        println("----------------")
                    }
                }
            }

            "2" -> {
                print("Note ID: ")
                val id = readLine()?.trim()

                if (id.isNullOrEmpty()) {
                    println("Invalid ID.")
                } else {
                    val note = manager.findById(id)

                    if (note == null) {
                        println("Not found.")
                    } else {
                        println("\n=== NOTE ===")
                        println("ID: ${note.id}")
                        println("Author: ${note.author}")
                        println("Date: ${note.date}")
                        println("Time: ${note.time}")
                        println("Text: ${note.text}")
                    }
                }
            }

            "3" -> {
                print("Enter text: ")
                val text = readLine()?.trim()

                if (text.isNullOrEmpty()) {
                    println("Invalid text.")
                } else {
                    manager.create(user, text)
                }
            }

            "4" -> {
                print("ID to delete: ")
                val id = readLine()?.trim()

                if (id.isNullOrEmpty()) {
                    println("Invalid ID.")
                } else {
                    val ok = manager.delete(id)
                    println(if (ok) "Deleted." else "Not found.")
                }
            }

            "0" -> {
                println("Bye.")
                return
            }

            else -> println("Invalid option.")
        }
    }
}