package Tasks;

import Exceptions.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }


    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return getDateTime().getDayOfMonth() == dateTime.getDayOfMonth();
    }

    @Override
    public void getNextDate(Task task) {
        System.out.println("Следующее время и дата выполнения задачи " + getTitle()
                + " " + getDateTime().plusMonths(1).format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm")));
    }

}
