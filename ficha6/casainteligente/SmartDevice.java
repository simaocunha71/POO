package casainteligente;

/**
 * The class SmartDevice.
 *
 * @author  Tiago Silva and Simão Cunha
 * @version 14/4/2021
 */

public class SmartDevice {
    private String id;
    private boolean on;

    public SmartDevice() {
        this.id = "";
        this.on = false;
    }

    public SmartDevice(String id) {
        this.id = id;
        this.on = false;
    }

    public SmartDevice(String id, boolean status) {
        this.id = id;
        this.on = status;
    }

    public SmartDevice(SmartDevice outroDevice) {
        this.id = outroDevice.id;
        this.on = outroDevice.on;
    }

    public String getID() {

        return id;
    }

    public void setID(String id) {

        this.id = id;
    }

    public boolean getOn() {

        return this.on;
    }

    public void setOn(boolean status) {

        this.on = status;
    }

    public SmartDevice clone() {
        return new SmartDevice(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartDevice sd = (SmartDevice) o;
        return on == sd.on && this.id.equals(sd.id);
    }

}
