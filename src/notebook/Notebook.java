package notebook;

public class Notebook {
    public static void main(String[] args) {

        NewBook book = new NewBook();
        book.size();

        NewNote note = new NewNote();
        note.text();
        note.moreText();

    }
}
