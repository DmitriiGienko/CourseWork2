package Tasks;

import Exceptions.IncorrectArgumentException;
import Exceptions.RepeatabilityTypeException;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String title, Type type, String description) throws IncorrectArgumentException {
        super(title, type, description);
    }


    @Override
    public boolean appearsIn(LocalDateTime dateTime) {
        return false;
    }

    @Override
    public void getNextDate(Task task) throws RepeatabilityTypeException {
        throw new RepeatabilityTypeException("Задача однократная! повторов нет!");
    }

}
