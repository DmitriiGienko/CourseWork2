package UtilityScanner;


import java.util.Scanner;

public class TextInput {

    // сканнер для всех
    public static Scanner scanner = new Scanner(System.in);

    // печать разделителя
    public static void printSeparate() {
        System.out.println("\n<===================================================>\n");
    }

    public static void privet() {
        System.out.println("Привет");
    }

    public static void choiceOfAction() {
        System.out.print("""
                Выберете действие:
                1. Добавить задачу
                2. Редактировать задачу
                3. Удалить задачу
                4. Получить все задачи в ежедневнике
                5. Получить задачи на указанный день
                6. Получить архивные задачи
                7. Получить сгруппированные по датам задачи
                """);
    }

    public static void choiceOfTypeTask() {
        System.out.print("""
                Выберете тип задачи:
                1. Однократная задача
                2. Ежедневная задача
                3. Еженедельная задача
                4. Еженедельная задача
                5. Ежегодная задача
                """);
    }

    public static void choiceOfRemoveTask() {
        System.out.print("Введите id задачи для удаления");
    }

}
