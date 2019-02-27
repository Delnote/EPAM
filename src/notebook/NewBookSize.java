package notebook;

import java.util.Scanner;

public class NewBookSize {

    public static int size;

    protected int size() {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите начальнй размер блокнота, не более 5 строк: ");
        size = input.nextInt();
        while (size <= 0 || size > 5) {
            System.out.println("Неправильный размер, попробуйте еще раз: ");
            size = input.nextInt();
        }

        return size;

    }

}
