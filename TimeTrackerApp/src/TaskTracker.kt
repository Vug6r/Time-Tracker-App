class TaskTracker {
    val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
        println("Funksiya əlavə edildi: ${task.name}")
    }

    fun removeTask(index: Int) {
        if (index in tasks.indices) {
            val removed = tasks.removeAt(index)
            println("Funksiya yığışdırıldı: ${removed.name}")
        }
    }

    fun getTotalTime(): Float {
        return tasks.sumOf { it.timeSpent.toDouble() }.toFloat()
    }

    fun displayTasks() {
        if (tasks.isEmpty()) {
            println("Funksiya yoxdur!")
            return
        }
        println("\nTasks (Total: ${getTotalTime()}h):")
        tasks.forEachIndexed { i, task ->
            println("${i + 1}. ")
            task.displayInfo()
        }
    }
}