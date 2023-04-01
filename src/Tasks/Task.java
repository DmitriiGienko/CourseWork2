package Tasks;

import Exceptions.IncorrectArgumentException;
import Exceptions.RepeatabilityTypeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public abstract class Task {
    private final int id;
    private String title;
    private Type type; //личная или рабочая
    private LocalDateTime dateTime = LocalDateTime.now();
    private String description;
    private static int idGenerator = 1;

    public Task(String title, Type type, String description) throws IncorrectArgumentException {

        if (title.isEmpty() || title.isBlank() || title == null) {
            throw new IncorrectArgumentException(" \"заголовок\" ");
        } else {
            this.title = title;
        }
        if (type.getClass().equals(Type.class)) {
            this.type = type;
        } else {
            throw new IncorrectArgumentException(" \"тип задачи\" ");
        }
        if (description.isEmpty() || description.isBlank()) {
            throw new IncorrectArgumentException(" \"описание\" ");
        } else {
            this.description = description;
        }
        this.id = idGenerator;
        idGenerator++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title.isEmpty() || title.isBlank() || title == null) {
            throw new IncorrectArgumentException(" \"заголовок\" ");
        } else {
            this.title = title;
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws IncorrectArgumentException {
        if (type.getClass().equals(Type.class)) {
            this.type = type;
        } else {
            throw new IncorrectArgumentException(" \"тип задачи\" ");
        }
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

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description.isEmpty() || getDescription().isBlank() || description == null) {
            throw new IncorrectArgumentException(" \"описание\" ");
        } else {
            this.description = description;
        }
    }

    public abstract boolean appearsIn(LocalDateTime dateTime);

    public abstract void getNextDate(Task task) throws RepeatabilityTypeException;

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

