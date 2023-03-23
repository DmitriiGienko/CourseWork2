package Tasks;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private Type type; //личная или рабочая
//    private int id;
    private ListOfTaskOptions taskDateOptions; // как часто повторяется
    private LocalDateTime dateTime;
    private String description;

    public Task(int id, String title, Type type, ListOfTaskOptions taskDateOptions,
                LocalDateTime dateTime, String description) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.taskDateOptions = taskDateOptions;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListOfTaskOptions getTaskDateOptions() {
        return taskDateOptions;
    }

    public void setTaskDateOptions(ListOfTaskOptions taskDateOptions) {
        this.taskDateOptions = taskDateOptions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && taskDateOptions == task.taskDateOptions && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, taskDateOptions, dateTime, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "idGenerator=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", taskDateOptions=" + taskDateOptions +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
