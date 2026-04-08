fun main() {
    val tracker = TaskTracker()

    tracker.addTask(ProgrammingTask("Kotlin App", "Mobile app", "Kotlin"))
    tracker.addTask(WritingTask("Documentation", "API docs", 500))
    tracker.addTask(DesignTask("UI Design", "App interface", "UI", 10f))

    while (true) {
        println("\n1. Aktiv olanlara bax  2.Funksiya əlavə elə  3. Vaxt əlavə elə   4. Funksiyanı yığışdır  5. Çıx")
        print("Seçildi: ")

        when (readlnOrNull()) {
            "1" -> tracker.displayTasks()
            "2" -> {
                print("Hansı cür olsun? (1. Programming, 2. Yazı, 3. Dizayn): ")
                val choice = readlnOrNull()?.toIntOrNull() ?: 0

                if (choice !in 1..3) {
                    println("Səhv seçmə!")
                    continue
                }
                when (choice) {
                    1 -> {
                        print("Ad: ")
                        val name = readlnOrNull() ?: ""
                        print("İzah: ")
                        val description = readlnOrNull() ?: ""
                        print("Dil: ")
                        val language = readlnOrNull() ?: ""

                        tracker.addTask(ProgrammingTask(name, description, language))
                    }

                    2 -> {
                        print("Ad: ")
                        val name = readlnOrNull() ?: ""
                        print("İzah: ")
                        val description = readlnOrNull() ?: ""
                        print("Dil: ")
                        val wordCount = readlnOrNull()?.toIntOrNull() ?: 0

                        tracker.addTask(WritingTask(name, description, wordCount))
                    }

                    3 -> {
                        print("Ad: ")
                        val name = readlnOrNull() ?: ""
                        print("İzah: ")
                        val description = readlnOrNull() ?: ""
                        print("Dizayn Tipi (UI, UX): ")
                        val designType = readlnOrNull() ?: ""
                        print("Əsas vaxt (saat): ")
                        val baseTime = readlnOrNull()?.toFloatOrNull() ?: 0f

                        tracker.addTask(DesignTask(name, description, designType, baseTime))
                    }
                }

            }
            "3" -> {
                tracker.displayTasks()
                print("Nömrə: ")
                val index = readlnOrNull()?.toIntOrNull()?.minus(1) ?: -1
                if (index in tracker.tasks.indices) {
                    print("Əlavə ediləcək saatlar: ")
                    val hours = readlnOrNull()?.toFloatOrNull() ?: 0f
                    tracker.tasks[index].timeSpent += hours
                    println("Vaxt əlavə edildi!")
                }
            }
            "4" -> {
                tracker.displayTasks()
                print("Silinməli nömrə: ")
                val index = readlnOrNull()?.toIntOrNull()?.minus(1) ?: -1
                tracker.removeTask(index)
            }
            "5" -> break
            else -> println("Səhv!")
        }
    }
}