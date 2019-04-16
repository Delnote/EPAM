package notebook;

import java.util.Scanner;

import static java.lang.System.in;

public class InsertNewNote {

    private CreateNotebook crNotebook = new CreateNotebook();

    protected void text() {
//  input row in notebook

        Scanner input = new Scanner(in);
        System.out.println("Введите текст заголовка, не более 10 символов: ");
        String newHeader = input.nextLine();
        while (newHeader.length() > 10 || newHeader.length() == 0) {
            System.out.println("Упс..... попробуйте еще: ");
            newHeader = input.nextLine();
        }
        System.out.println("Введите текст заметки, не более 30 символов: ");
        String newRow = input.nextLine();
        while (newRow.length() > 30 || newRow.length() == 0) {
            System.out.println("Упс..... попробуйте еще: ");
            newRow = input.nextLine();
        }

        crNotebook.notebookAddRow(new Note(newHeader, newRow));
        moreText();
    }
//  suggestion to add more rows

    protected void moreText() {
        System.out.println("Хотите ввести следующую заметку? (y/n)");
        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            text();
        } else if (rowYes.equalsIgnoreCase("n")) {
//            System.out.println("Спасибо, пока..");
            lessText();
        } else {
            System.out.println("Не правильный ввод!");
            moreText();
        }
    }
//  suggestion to remove rows

    public void lessText() {
        System.out.println("Удалить заметку? (y/n)");
        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            System.out.println("Ваш блокнот:");
            for (int i = 0; i < crNotebook.getNotebook().length; i++) {
                System.out.printf("%d. \t Header: \t %s \n \t Text: \t %s \n", (i + 1), crNotebook.getNotebook()[i].getHeader(), crNotebook.getNotebook()[i].getText());
            }
            System.out.println("Удалить запись:");
            int delNoteNumber;

//  validating number of removing note
            do {
                while (!input.hasNextInt()) {
                    System.out.println("Не верный ввод");
                    input.next();
                }
                delNoteNumber = input.nextInt();
            } while (delNoteNumber <= 0 || delNoteNumber > crNotebook.getNotebook().length);

            new CreateNotebook (delNoteNumber).notebookDelRow();
            if (crNotebook.getNotebook().length > 0) {
                System.out.println("Заметка удалена, хотите удалить еще одну?");
                lessText();
            } else {
                System.out.println("Все записи удалены!");
            }
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Ваш блокнот сохранен, спасибо.");
        } else {
            System.out.println("Не правильный ввод!");

        }
    }

}
