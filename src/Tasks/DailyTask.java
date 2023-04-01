package Tasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
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

}
