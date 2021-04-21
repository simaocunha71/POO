package casainteligente;

/**
 * The class SmartSpeaker.
 *
 * @author  Tiago Silva and Simão Cunha
 * @version 14/4/2021
 */

public class SmartSpeaker extends SmartDevice{

    public final static int MAX = 20;
    public final static int MIN = 0;

    private String channel;
    private int volume;

    public SmartSpeaker() {
        super();
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker(String id){
        super(id);
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker(String id, String channel, int volume) {
        super(id);
        this.channel = channel;
        if (volume >= MIN && volume <= MAX) this.volume = volume;
        else if (volume < MIN) this.volume = MIN;
        else this.volume = MAX;
    }

    public SmartSpeaker(SmartSpeaker outroSpeaker){
        super(outroSpeaker);
        this.volume = outroSpeaker.volume;
        this.channel = outroSpeaker.channel;
    }

    public int getVolume() {
        return volume;
    }

    public String getChannel() {
        return channel;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void volumeUp() {
        if (this.volume < MAX) this.volume +=1;
        else this.volume = MAX;
    }

    public void volumeDown() {
        if (this.volume > MIN) this.volume -=1;
        else this.volume = MIN;
    }

    public SmartSpeaker clone() {
        return new SmartSpeaker(this);
    }
}
