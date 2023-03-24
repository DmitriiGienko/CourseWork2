package Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;


public abstract class Task {
    private final int id;
    private String title;
    private Type type; //личная или рабочая
    private LocalDateTime dateTime = LocalDateTime.now();
    private String description;
    private static int count = 1;

    public Task(String title, Type type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
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

    public abstract boolean appearsIn();

    public abstract void getNextDate(Task task);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, dateTime, description);
    }

    @Override
    public String toString() {
        return "Задача " +
                "id: " + id +
                ", заголовок: " + title +
                ", тип: " + type.printType() +
                ", дата и время выполнения: " + dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")) +
                ", описание: " + description;
    }
}

