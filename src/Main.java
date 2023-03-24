import Tasks.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static UtilityScanner.TextInput.*;

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
        System.out.println(task1.getId());
        System.out.println(task2.getId());
        System.out.println(task3.getId());
        System.out.println(task4.getId());
        System.out.println(task5.getId());

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
        System.out.println("__________________________________");

//Получаю дату следующего события задачи
        taskService.printNextData(task1);
        taskService.printNextData(task3);
        taskService.printNextData(task5);
        taskService.printNextData(task7);
        taskService.printNextData(task9);
        System.out.println("__________________________________");


//удаляю задачу из ежедневника и распечатываю его вновь
        taskService.removeTask(1);
        taskService.removeTask(3);
        taskService.removeTask(4);
        taskService.removeTask(7);
        System.out.println("__________________________________");

        taskService.printTasks();
        System.out.println("__________________________________");







/*        choiceOfAction();
        TaskService taskService2 = new TaskService(new HashMap<>());
        taskService2.addTask(new OneTimeTask("врач",Type.PERSONAL,"Запись к зубному"));
        taskService2.addTask(new OneTimeTask("Звонок",Type.PERSONAL,"Позвони жене!"));
        taskService2.addTask(new DailyTask("Утро",Type.PERSONAL,"Почисти зубы"));
        taskService2.addTask(new DailyTask("Поработать",Type.WORK,"Не забудь сходить на работу"));
        taskService2.addTask(new WeeklyTask("Отчет",Type.WORK,"Составь и отправь отчет за неделю"));
        taskService2.addTask(new WeeklyTask("План",Type.PERSONAL,"Распланируй выходные"));
        taskService2.addTask(new MonthlyTask("ЗП",Type.PERSONAL,"Получить ЗП"));
        taskService2.addTask(new MonthlyTask("Спланируй",Type.WORK,"Составь план на месяц"));
        taskService2.addTask(new YearlyTask("ДР",Type.PERSONAL,"Не пропусти свое ДР"));
        taskService2.addTask(new YearlyTask("Премия",Type.WORK,"Выпиши себе годовую премию побольше"));

        taskService2.printTasks();

        ArrayList<Integer> arrayId = (ArrayList<Integer>) taskService2.getTaskMap().entrySet().stream()
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(arrayId);
        System.out.println("++++++++++++++++++++++");

        ArrayList<Task> arrayTask = (ArrayList<Task>) taskService2.getTaskMap().entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        System.out.println(arrayTask);
        System.out.println("++++++++++++++++++++++");



        task2.getNextDate(task2);

      taskService2.printNextData(arrayTask.get(8));

*/

    }
}