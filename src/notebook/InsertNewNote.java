package notebook;

import java.util.Scanner;

import static java.lang.System.in;

public class InsertNewNote {

    private CreateNotebook crNotebook = new CreateNotebook();

    protected void text() {
//  input row in notebook

        Scanner input = new Scanner(in);
        System.out.println("Введите текст заметки, не более 30 символов: ");
        String newRow = input.nextLine();
        while (newRow.length() > 30 || newRow.length() == 0) {
            System.out.println("Упс..... попробуйте еще: ");
            newRow = input.nextLine();
        }

        Note note = new Note();
        note.setNote(newRow);

        CreateNotebook createNotebook = new CreateNotebook (note.getNote());
        createNotebook.notebookAddRow();
        moreText();
    }
//  suggestion to add more rows

    private void moreText() {
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

    private void lessText() {
        System.out.println("Удалить заметку? (y/n)");
        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            System.out.println("Ваш блокнот:");
            for (int i = 0; i < crNotebook.getNotebook().length; i++) {
                System.out.println((i + 1) + ". " + crNotebook.getNotebook()[i]);
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

            CreateNotebook createNotebook = new CreateNotebook (delNoteNumber);
            createNotebook.notebookDelRow();
            if (crNotebook.getNotebook().length > 0) {
                System.out.println("Заметка удалена, хотите удалить еще одну?");
                lessText();
            } else {
                System.out.println("Все записи удалены!");
            }
//            System.out.println(Arrays.toString(crNotebook.getNotebook()));
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Ваш блокнот сохранен.");
        } else {
            System.out.println("Не правильный ввод!");

        }
    }

}
