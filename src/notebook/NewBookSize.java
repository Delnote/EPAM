package notebook;

import java.util.Scanner;

public class NewBookSize extends NewNote {

    int size;
    String[] notebook = new String[size];

    protected int size() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите начальный размер блокнота, не более 5 строк: ");
        size = input.nextInt();
        while (size <= 0 || size > 5) {
            System.out.println("Неправильный размер, попробуйте еще раз: ");
            size = input.nextInt();
        }

        text();

        return size;

    }


    protected String[] notebookFilling (String notes) {
        int i = 0;
        while (i < size && notebook[i] == null) {
            notebook[i] = notes;
        }

        return notebook;
    }

    public void printBook () {
        for (int i = 0; i < notebook.length; i++) {
            System.out.println("№ " + i + ".  " + notebook[i]);
        }

    }

}
