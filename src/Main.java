import Tasks.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static UtilityScanner.TextInput.*;

public class Main {


    public static void main(String[] args) {

//        Map<Integer, Task> myTasks = new HashMap<Integer,Task>();
//        DailyTask task1 = new DailyTask("Утро",
//                Type.PERSONAL,
//                LocalDateTime.now(),
//                "Почистить зубы");
//        WeeklyTask task2 = new WeeklyTask("Отчет", Type.WORK, LocalDateTime.now(), "Подать отчет");
//
//
//        System.out.println(task1);
//
//        Map<Integer, Task> myTasks = new HashMap<>();
//        myTasks.put(task1.getId(), task1);
//        myTasks.put(task2.getId(), task2);
//
//        System.out.println(task2);
//
//        for (Map.Entry<Integer, Task> volum : myTasks.entrySet()) {
//            System.out.println(volum.getValue().getDescription());
//        }

        privet(); //приветствие

        OneTimeTask task1 = new OneTimeTask("врач", Type.PERSONAL, "Запись к зубному");
        OneTimeTask task2 = new OneTimeTask("Звонок", Type.PERSONAL, "Позвони жене!");
        DailyTask task3 = new DailyTask("Утро", Type.PERSONAL, "Почисти зубы");
        DailyTask task4 = new DailyTask("Поработать", Type.WORK, "Не забудь сходить на работу");
        WeeklyTask task5 = new WeeklyTask("Отчет", Type.WORK, "Составь и отправь отчет за неделю");
        MonthlyTask task6 = new MonthlyTask("Спланируй", Type.WORK, "Составь план на месяц");
        YearlyTask task7 = new YearlyTask("Премия", Type.WORK, "Выпиши себе годовую премию побольше");

        Map<Integer, Task> map = new HashMap<>();
        map.put(task1.getId(), task1);
        map.put(task2.getId(), task2);
        map.put(task3.getId(), task3);
        map.put(task4.getId(), task4);
        map.put(task5.getId(), task5);
        map.put(task6.getId(), task6);
        map.put(task7.getId(), task7);

        for (Map.Entry<Integer,Task> val: map.entrySet()){
            System.out.println(val);

        }

        System.out.println();
        map.remove(task6.getId());
        for (Map.Entry<Integer,Task> val: map.entrySet()){
            System.out.println(val);

        }




//        choiceOfAction();
//        TaskService taskService = new TaskService(new HashMap<>());
//        taskService.addTask(new OneTimeTask("врач",Type.PERSONAL,"Запись к зубному"));
//        taskService.addTask(new OneTimeTask("Звонок",Type.PERSONAL,"Позвони жене!"));
//        taskService.addTask(new DailyTask("Утро",Type.PERSONAL,"Почисти зубы"));
//        taskService.addTask(new DailyTask("Поработать",Type.WORK,"Не забудь сходить на работу"));
//        taskService.addTask(new WeeklyTask("Отчет",Type.WORK,"Составь и отправь отчет за неделю"));
//        taskService.addTask(new WeeklyTask("План",Type.PERSONAL,"Распланируй выходные"));
//        taskService.addTask(new MonthlyTask("ЗП",Type.PERSONAL,"Получить ЗП"));
//        taskService.addTask(new MonthlyTask("Спланируй",Type.WORK,"Составь план на месяц"));
//        taskService.addTask(new YearlyTask("ДР",Type.PERSONAL,"Не пропусти свое ДР"));
//        taskService.addTask(new YearlyTask("Премия",Type.WORK,"Выпиши себе годовую премию побольше"));
//
//        taskService.printTasks();
//        System.out.println();
//
//        ArrayList<Task> arrayList = taskService.;

//        taskService.removeTask();
//        System.out.println();
//
//        taskService.printTasks();


//        int a = scanner.nextInt();


    }
}