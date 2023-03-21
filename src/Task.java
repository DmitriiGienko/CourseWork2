import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private int idGenerator;
    private String title;
    private TaskRepeatability type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(int idGenerator, String title, TaskRepeatability type, int id, LocalDateTime dateTime, String description) {
        this.idGenerator = idGenerator;
        this.title = title;
        this.type = type;
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
    }

    public int getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(int idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskRepeatability getType() {
        return type;
    }

    public void setType(TaskRepeatability type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idGenerator == task.idGenerator && id == task.id && Objects.equals(title, task.title)
                && Objects.equals(type, task.type) && Objects.equals(dateTime, task.dateTime)
                && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Задача " +
                "idGenerator=" + idGenerator +
                ", title='" + title +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description;
    }
}
