package casainteligente;

/**
 * The class SmartBulb.
 *
 * @author  Tiago Silva and Simão Cunha
 * @version 14/4/2021
 */

public class SmartBulb extends SmartDevice{
    public static final int NEUTRAL = 0;
    public static final int WARM = 1;
    public static final int COLD = -1;

    private int tone;

    public SmartBulb() {
        super();
        this.tone = NEUTRAL;
    }

    public SmartBulb(String id) {
        super(id);
        this.tone = NEUTRAL;
    }

    public SmartBulb(String id, int tone) {
        super(id);
        this.setTone(tone);
    }

    public SmartBulb(SmartBulb outrosb) {
        super(outrosb);
        this.setTone(outrosb.getTone());
    }

    public int getTone() {
        return tone;
    }

    public void setTone(int tone) {
        if (tone >= WARM )this.tone = WARM;
        else if (tone <= COLD) this.tone = COLD;
        else this.tone = NEUTRAL;this.tone = tone;
    }

    public SmartBulb clone() {
        return new SmartBulb(this);
    }

    public boolean equals(Object o) {
        SmartBulb sb = (SmartBulb) o;
        return super.equals(o) && this.tone == sb.tone;
    }
}
