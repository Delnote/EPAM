package notebook;

import java.util.Scanner;

import static java.lang.System.in;

public class NewNote {

    protected static void text() {

        Scanner input = new Scanner(in);
        System.out.println("Введите текст заметки, не более 30 символов: ");
        String row = input.next();
        while (row.length() <= 30 && row.length() == 0) {
            System.out.println("Упс..... попробуйте еще: ");
        }
        System.out.println("Хотите еще? (Y/N)");
        moreText();
    }



    protected static void moreText() {

        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            text();
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Спасибо, пока..");
        } else {
            System.out.println("Не правильный ввод!");
            moreText();
        }
    }

}
