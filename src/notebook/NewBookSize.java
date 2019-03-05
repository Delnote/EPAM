package notebook;

import java.util.Scanner;

public class NewBookSize extends NewNote {

    static int size;
    private String[] notebook = new String[size];

    protected int size() {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите начальную длину блокнота не более 5 строк:");
            while (!sc.hasNextInt()) {
                System.out.println("Это не число!");
                sc.next();
            }
            size = sc.nextInt();
        } while (size <= 0 || size > 5);

        return size;
    }

    protected void notebookFilling(String notes) {
        int i = 0;
        while (i < notebook.length && notebook[i] == null)  {
            notebook[i] = notes;
        }
        /*       for (int i = 0; i < notebook.length; i++) {
            if (notebook[i] == null) {
                notebook[i] = notes;
            }

        }
*/
        System.out.println("Хотите добавить? (Y/N)");
        moreText();
    }

    protected void printBook() {
        for (int i = 0; i < notebook.length; i++) {
            System.out.println("№ " + (i + 1) + ".  " + notebook[i]);
        }

    }

}