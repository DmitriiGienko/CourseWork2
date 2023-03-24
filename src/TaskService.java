import Tasks.Task;

import java.time.format.DateTimeFormatter;
import java.util.Map;

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
    public void removeTask(int id) {
        System.out.println(taskMap.get(id).getDescription() + "   удалена");
        taskMap.remove(id);
    }

//    public void printNextDate(int id) {



    //распечатать все задачи в ежедневнике
    public void printTasks() {
        for (Map.Entry<Integer, Task> volume : taskMap.entrySet()) {
            System.out.println(volume.getValue().getDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"))
                    + " " + volume.getValue().getDescription());
        }
    }

    public void printNextData(Task task) {
        if (task.appearsIn()) {
            task.getNextDate(task);
        } else {
            System.out.println("Задача одноразовая");
        }
    }
}
