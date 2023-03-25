import Exceptions.RepeatabilityTypeException;
import Exceptions.TaskNotFoundException;
import Tasks.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskService {

    private Map<Integer, Task> taskMap;

    public TaskService(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    // добавить задачу в ежедневник
    public void addTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    // удалить задачу из ежедневника
    public void removeTask(int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задачи с id = " + id + " не существует!");
        }
        System.out.println("Задача: \"" + taskMap.get(id).getDescription() + "\" -> удалена");
        taskMap.remove(id);
    }


    //распечатать все задачи в ежедневнике
    public void printTasks() {
        System.out.println("В ежедневнике следующие задачи:");
        for (Map.Entry<Integer, Task> volume : taskMap.entrySet()) {
            System.out.println(volume.getValue().getDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"))
                    + " " + volume.getValue().getDescription());
        }
        System.out.println("Всего задач - " + taskMap.size());

    }

    //получить следующую дату события
    public void printNextData(Task task) {
        try {
            task.getNextDate(task);
        } catch (RepeatabilityTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    //получить все задачи на выбранную дату
    public void getAllByDate(LocalDateTime date) {
        Set<Task> taskHashSet = new HashSet<>();
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().appearsIn(date)) {
                taskHashSet.add(entry.getValue());
            }
        }
        System.out.println("Список дел на " + date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")) + ":");
        for (Task task : taskHashSet) {
            System.out.println(task.getDateTime().format(DateTimeFormatter.ofPattern("hh:mm")) + "  " +
                    task.getDescription());
        }
    }
}
