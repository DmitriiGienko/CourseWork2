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
                4. Получить задачи на указанный день
                5. Получить архивные задачи
                6. Получить сгруппированные по датам задачи
                """);

    }

}
