package Tasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) throws IncorrectArgumentException {
        super.setTitle(title);
    }

    @Override
    public Type getType() {
        return super.getType();
    }

    @Override
    public void setType(Type type) throws IncorrectArgumentException {
        super.setType(type);
    }

    @Override
    public LocalDateTime getDateTime() {
        return super.getDateTime();
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        super.setDateTime(dateTime);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) throws IncorrectArgumentException {
        super.setDescription(description);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return true;
    }

    @Override
    public void getNextDate(Task task) {
        System.out.println("Следующее время и дата выполнения задачи " + getTitle()
                + " " + getDateTime().plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")));
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
