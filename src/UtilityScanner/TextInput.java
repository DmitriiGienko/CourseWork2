package UtilityScanner;

import com.sun.tools.javac.Main;

import java.util.HashMap;
import java.util.Scanner;

public class TextInput {

    public static Scanner scanner = new Scanner(System.in);


    public static void privet() {
        System.out.println("Привет");
    }

    public static void choiceOfAction() {
        System.out.printf("Выберете действие:\n" +
                "1. Добавить задачу\n" +
                "2. Редактировать задачу\n" +
                "3. Удалить задачу\n" +
                "4. Получить задачи на указанный день\n" +
                "5. Получить архивные задачи\n" +
                "6. Получить сгруппированные по датам задачи\n");

    }

}
