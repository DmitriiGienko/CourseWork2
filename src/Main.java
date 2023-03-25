import Exceptions.TaskNotFoundException;
import Tasks.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import static UtilityScanner.TextInput.printSeparate;

public class Main {

    public static void main(String[] args) {

        OneTimeTask task1 = new OneTimeTask("врач", Type.PERSONAL, "Запись к зубному");
        OneTimeTask task2 = new OneTimeTask("Звонок", Type.PERSONAL, "Позвони жене!");
        DailyTask task3 = new DailyTask("Утро", Type.PERSONAL, "Почисти зубы");
        DailyTask task4 = new DailyTask("Поработать", Type.WORK, "Не забудь сходить на работу");
        WeeklyTask task5 = new WeeklyTask("Отчет", Type.WORK, "Составь и отправь отчет за неделю");
        WeeklyTask task6 = new WeeklyTask("План", Type.PERSONAL, "Распланируй выходные");
        MonthlyTask task7 = new MonthlyTask("ЗП", Type.PERSONAL, "Получить ЗП");
        MonthlyTask task8 = new MonthlyTask("Спланируй", Type.WORK, "Составь план на месяц");
        YearlyTask task9 = new YearlyTask("ДР", Type.PERSONAL, "Не пропусти свое ДР");
        YearlyTask task10 = new YearlyTask("Премия", Type.WORK, "Выпиши себе годовую премию побольше");

        TaskService taskService = new TaskService(new HashMap<>());
// Добавляем задачи в ежедневник
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        taskService.addTask(task5);
        taskService.addTask(task6);
        taskService.addTask(task7);
        taskService.addTask(task8);
        taskService.addTask(task9);
        taskService.addTask(task10);

// Распечатываю все задачи в ежедневнике
        taskService.printTasks();

        printSeparate();

//Получаю дату следующего события задачи

        taskService.printNextData(task1);
        taskService.printNextData(task3);

        printSeparate();

//удаляю задачу из ежедневника и распечатываю его вновь
        try {
            taskService.removeTask(1);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            taskService.removeTask(3);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());

        }

        try {
            taskService.removeTask(258);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }

        printSeparate();

        taskService.printTasks();

        printSeparate();

        taskService.getAllByDate(LocalDateTime.now().plusYears(1));

        printSeparate();

    }
}