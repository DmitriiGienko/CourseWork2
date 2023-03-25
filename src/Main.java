import Exceptions.TaskNotFoundException;
import Tasks.*;
import UtilityScanner.TextInput;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import static UtilityScanner.TextInput.scanner;

import static UtilityScanner.TextInput.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();  // первая часть курсовой без сканнера
        task2(); // первая часть курсовой со сканнером

    }

    public static void task1() {

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

    public static void task2() {
        TaskService taskService = new TaskService(new HashMap<>());

        choiceOfAction();

        OUTER:
        switch (scanner.nextInt()) {
            case 1 -> {
                choiceOfTypeTask();
                INNER:
                switch (scanner.nextInt()) {
                    case 1 -> taskService.addTask(new OneTimeTask("врач", Type.PERSONAL, "Запись к зубному"));
                    case 2 -> taskService.addTask(new DailyTask("Утро", Type.PERSONAL, "Почисти зубы"));
                    case 3 ->
                            taskService.addTask(new WeeklyTask("Отчет", Type.WORK, "Составь и отправь отчет за неделю"));
                    case 4 -> taskService.addTask(new MonthlyTask("ЗП", Type.PERSONAL, "Получить ЗП"));
                    case 5 ->
                            taskService.addTask(new YearlyTask("Премия", Type.WORK, "Выпиши себе годовую премию побольше"));
                    default -> {
                        System.out.println("Неправильный выбор");
                    }
                }
            }
            case 2 -> System.out.println("Выбери задачу для редактора");
            case 3 -> {
                choiceOfRemoveTask();
                try {
                    taskService.removeTask(scanner.nextInt());
                } catch (TaskNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 4 -> taskService.printTasks();
            case 5-> taskService.getAllByDate(LocalDateTime.now().plusMonths(1));
            case 6 -> System.out.println("В архиве такие задачи");
            case 7 -> System.out.println("bla-bla-bla");
        }


//        OneTimeTask task44 = new OneTimeTask("врач", Type.PERSONAL, "Запись к зубному");
//        OneTimeTask task2 = new OneTimeTask("Звонок", Type.PERSONAL, "Позвони жене!");
//        DailyTask task3 = new DailyTask("Утро", Type.PERSONAL, "Почисти зубы");
//        DailyTask task4 = new DailyTask("Поработать", Type.WORK, "Не забудь сходить на работу");
//        WeeklyTask task5 = new WeeklyTask("Отчет", Type.WORK, "Составь и отправь отчет за неделю");
//        WeeklyTask task6 = new WeeklyTask("План", Type.PERSONAL, "Распланируй выходные");
//        MonthlyTask task7 = new MonthlyTask("ЗП", Type.PERSONAL, "Получить ЗП");
//        MonthlyTask task8 = new MonthlyTask("Спланируй", Type.WORK, "Составь план на месяц");
//        YearlyTask task9 = new YearlyTask("ДР", Type.PERSONAL, "Не пропусти свое ДР");
//        YearlyTask task10 = new YearlyTask("Премия", Type.WORK, "Выпиши себе годовую премию побольше");

// Добавляем задачи в ежедневник
//        taskService.addTask(task1);
//        taskService.addTask(task2);
//        taskService.addTask(task3);
//        taskService.addTask(task4);
//        taskService.addTask(task5);
//        taskService.addTask(task6);
//        taskService.addTask(task7);
//        taskService.addTask(task8);
//        taskService.addTask(task9);
//        taskService.addTask(task10);

// Распечатываю все задачи в ежедневнике
        taskService.printTasks();

        printSeparate();

//Получаю дату следующего события задачи

//        taskService.printNextData(task1);
//        taskService.printNextData(task3);

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