package casainteligente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class CasaInteligente.
 *
 * @author  Tiago Silva and Simão Cunha
 * @version 14/4/2021
 */

public class CasaInteligente {
    private String morada;
    private Map <String, SmartDevice> devices;
    private Map <String, List <String>> idsPorDivisao;

    public CasaInteligente() {
        this.morada = "";
        this.devices = new HashMap<>();
        this.idsPorDivisao = new HashMap<>();
    }

    public CasaInteligente(String morada) {
        this.morada = morada;
        this.devices = new HashMap<>();
        this.idsPorDivisao = new HashMap<>();
    }

    public CasaInteligente(CasaInteligente outraCasa) {
        this.morada = outraCasa.morada;
        this.devices = outraCasa.devices;
        this.idsPorDivisao = outraCasa.idsPorDivisao;
    }

    public String getMorada() {
        return morada;
    }

    public Map<String, SmartDevice> getDevices() {
        return devices;
    }

    public Map<String, List<String>> getIdsPorDivisao() {
        return idsPorDivisao;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setDevices(Map<String, SmartDevice> devices) {
        this.devices = devices;
    }

    public void setIdsPorDivisao(Map<String, List<String>> idsPorDivisao) {
        this.idsPorDivisao = idsPorDivisao;
    }


    public void addDevice(SmartDevice device) {
        this.devices.put(device.getID(),device.clone());
    }

    public SmartDevice getDevice(String id) {

        return this.devices.get(id).clone();
    }

    public boolean existsDevice(String b1) {
        return this.devices.containsKey(b1);
    }

    public void setAllOn(boolean on) {
        this.devices.forEach((k, v) -> {
            v.setOn(on);
            this.devices.replace(k, v);
        });
    }


    public void addRoom(String room) {
        if(!hasRoom(room)) this.idsPorDivisao.put(room,new ArrayList<>());
    }

    public boolean hasRoom(String room) {
        return this.idsPorDivisao.containsKey(room);
    }

    public void addToRoom(String room, String id) {
        if(!roomHasDevice(room,id)) this.idsPorDivisao.get(room).add(id);
    }

    public boolean roomHasDevice(String room, String id) {
        return this.idsPorDivisao.get(room).contains(id);
    }
}
