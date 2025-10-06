import java.util.Date;

/**
 * Клас для представлення штормового попередження
 */
public class Попередження {
    private String текст;
    private Date час;
    private ПорігПодії поріг;

    public Попередження(String текст, Date час, ПорігПодії поріг) {
        this.текст = текст;
        this.час = час;
        this.поріг = поріг;
    }

    public String getDetails() {
        return "Попередження: " + текст + ", час: " + час + ", поріг: " + поріг.getLevel();
    }

    public Date getЧас() {
        return час;
    }

    public ПорігПодії getПоріг() {
        return поріг;
    }
}