/**
 * Клас для представлення порогу події
 */
public class ПорігПодії {
    private int рівеньОпасності;

    public ПорігПодії(int level) {
        this.рівеньОпасності = level;
    }

    public int getLevel() {
        return рівеньОпасності;
    }
}