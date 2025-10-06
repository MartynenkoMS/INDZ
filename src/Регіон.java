import java.util.ArrayList;
import java.util.List;

/**
 * Клас для представлення регіону
 */
public class Регіон {
    private String назва;
    private List<Попередження> попередження;

    public Регіон(String назва) {
        this.назва = назва;
        this.попередження = new ArrayList<>();
    }

    public void додатиПопередження(Попередження п) {
        попередження.add(п);
    }

    public String getНазва() {
        return назва;
    }
}