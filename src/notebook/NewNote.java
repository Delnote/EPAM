package notebook;

import java.util.Scanner;

import static java.lang.System.in;


public class NewNote {


    String row = "";

    public String text() {

        Scanner input = new Scanner(in);
        System.out.println("Введите текст заметки, не более 30 символов: ");
        row = input.next();
        while (row.length() > 30 || row.length() == 0) {
            System.out.println("Упс..... попробуйте еще: ");
            row = input.next();
        }
        NewBookSize temp = new NewBookSize();
        temp.notebookFilling(row);

        System.out.println("Хотите добавить? (Y/N)");
        moreText();

        return row;

    }

     protected void moreText() {

        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            text();
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Спасибо, пока..");
            NewBookSize temp = new NewBookSize();
            temp.printBook();
        } else {
            System.out.println("Не правильный ввод!");
            moreText();
        }
    }


}
