package notebook;

public class Note {

    private String text;
    private String header;

    public Note(String header, String text) {
        this.text = text;
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public String getHeader() {
        return header;
    }
}
