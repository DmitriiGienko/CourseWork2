import Exceptions.IncorrectArgumentException;
import Exceptions.TaskNotFoundException;
import Tasks.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        task1();  // курсовая без сканнера
        task2(); // Задача на функциональное программирование

    }

    public static void task1() {

        System.out.println("----- Задача №1 -----\n");


        OneTimeTask task1 = null;
        try {
            task1 = new OneTimeTask("врач", Type.PERSONAL, "запись к зубному");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        OneTimeTask task2 = null;
        try {
            task2 = new OneTimeTask("звонок!", Type.PERSONAL, "Позвони жене!");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        DailyTask task3 = null;
        try {
            task3 = new DailyTask("Утро", Type.PERSONAL, "Почисти зубы");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        DailyTask task4 = null;
        try {
            task4 = new DailyTask("Поработать", Type.WORK, "Не забудь сходить на работу");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        WeeklyTask task5 = null;
        try {
            task5 = new WeeklyTask("Отчет", Type.WORK, "Составь и отправь отчет за неделю");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        WeeklyTask task6 = null;
        try {
            task6 = new WeeklyTask("План", Type.PERSONAL, "Распланируй выходные");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        MonthlyTask task7 = null;
        try {
            task7 = new MonthlyTask("ЗП", Type.PERSONAL, "Получить ЗП");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        MonthlyTask task8 = null;
        try {
            task8 = new MonthlyTask("Спланируй", Type.WORK, "Составь план на месяц");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }
        YearlyTask task9 = null;
        try {
            task9 = new YearlyTask("ДР", Type.PERSONAL, "Не пропусти свое ДР");
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }

        TaskService taskService = new TaskService(new HashMap<>(), new ArrayList<>());
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

// получаю задачи на заданный день
        taskService.getAllByDate(LocalDateTime.now().plusYears(1));

        printSeparate();

// перемещаю задачи в корзину
        try {
            taskService.addToRemovedList(1);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            taskService.addToRemovedList(2);
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }

        printSeparate();

// смотрю задачи в корзине
        taskService.printRemovedList();

        printSeparate();

        taskService.printTasks();

        printSeparate();

// изменяю созданную задачу
        try {
            taskService.updateTask(6, "Новый заголовок", "Новое описание");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
        }

        printSeparate();

        taskService.printTasks();

    }

    public static void task2() {

        System.out.println("\n ----- Задача №2 -----\n");

        String text = "yourapp the quick brown fox jumps over the lazy dog";

        Map<String, List<String>> map = Arrays.stream(text.split("\\s+"))
                .collect(Collectors.groupingBy(
                        String::valueOf,
                        Collectors.toList()
                ));


        Map<String, List<String>> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> -a.getValue().size()))

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.printf("В тексте %d слов\nТоп 10:\n", sortedMap.size());
        int i = 0; // счетчик не больше 10 слов, если в тексте больше
        for (Map.Entry<String, List<String>> volume : sortedMap.entrySet()) {
            if (i == 10) {
                return;
            }
            System.out.println(volume.getValue().size() + " - " + volume.getKey());
            i++;
        }
    }

    // печать разделителя
    public static void printSeparate() {
        System.out.println("\n<===================================================>\n");
    }

}