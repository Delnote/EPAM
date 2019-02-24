package notebook;

import java.util.Scanner;

public class NewBook {

    protected static void size() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите начальнй размер блокнота, не более 5 строк: ");
        int rows = input.nextInt();
        while (rows <= 0 || rows > 5) {
            System.out.println("Неправильный размер, попробуйте еще раз: ");
            rows = input.nextInt();
        }
        String[] notebook = new String[rows];
    }



}
