package Tasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfWeek() == dateTime.getDayOfWeek();
    }

    @Override
    public void getNextDate(Task task) {
        System.out.println("Следующяя дата и время выполнения задачи " + getTitle()
                + " " + getDateTime().plusWeeks(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")));
    }

}
