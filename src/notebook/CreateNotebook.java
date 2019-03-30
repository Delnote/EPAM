package notebook;

import java.util.Arrays;

public class CreateNotebook {

    private String row;
    private int noteNumber;
    private static String[] notebook = new String[0];


//    private String[] bufferNotebook = new String[1];


    protected CreateNotebook (String row) {
        this.row = row;
    }

    protected CreateNotebook (int num) {
        this.noteNumber = num;
    }

    protected CreateNotebook() {

    }

//  adding rows to the notebook

    protected void notebookAddRow () {

        String[] bufferNotebook = {row};
        notebook = Arrays.copyOf(notebook, notebook.length + 1);
        System.arraycopy(bufferNotebook, 0, notebook, notebook.length - 1, 1);
        for (int i = 0; i < notebook.length; i++) {
            System.out.println((i + 1) + ". " + notebook[i]);
        }
//        System.out.println(Arrays.toString(notebook));
    }
//  removing rows from the notebook

    protected void notebookDelRow() {
        String[] arr = new String[notebook.length - 1];
        System.arraycopy(notebook, 0, arr, 0, noteNumber - 1);
        System.arraycopy(notebook, noteNumber, arr, noteNumber - 1, notebook.length - noteNumber);
        notebook = arr;
        for (int i = 0; i < notebook.length; i++) {
            System.out.println((i + 1) + ". " + notebook[i]);
        }
    }

    protected String[] getNotebook() {
        return notebook;
    }

}
