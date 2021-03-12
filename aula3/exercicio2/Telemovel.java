import java.util.ArrayList;

public class Telemovel {
    private String marca; //Marca do telemovel
    private String modelo;//Modelo do telemovel
    private int x; //Resoluçao x 
    private int y; //Resolucao y
    private float armazenarMensagens; // dimensao do armazenamento para as mensagens
    private float armazenarFotos; // dimensao para o armazenamento para as fotos
    private float armazenarApps; // dimensao para o armazenamento para as aplicaçoes
    private float armazenarFtAppTotal = armazenarApps + armazenarFotos; // dimensao total para fotos e aplicaçoes
    private float espacoTotalBytes; // espaço total ocupado em bytes
    private int numFotos; // numero de fotos existentes
    private int numApps; // numero de aplicaçoes instaladas
    private ArrayList<String> appsInst; // Array com o nome das aplicaçoes instaladas
    private ArrayList<String> mensagens; // Array com as mensagens no sistema
    
    public Telemovel (String marca, String modelo, int x, int y, float armazenarMensagens, 
                      float armazenarFotos, float armazenarApps, ArrayList<String> appsInst, ArrayList<String> mensagens){
        this.marca = marca;
        this.modelo = modelo;
        this.x = x;
        this.y = y;
        this.armazenarMensagens = armazenarMensagens;
        this.armazenarFotos = armazenarFotos;
        this.armazenarApps = armazenarApps;
        this.numFotos = 0;
        this.numApps = 0;
        this.espacoTotalBytes = 0;
        this.appsInst = new ArrayList<String>(numApps);
        this.mensagens = new ArrayList<String>(mensagens.size());
    }

    public Telemovel(String marca, String modelo, int x, int y, float armazenarMensagens, float armazenarFotos, float armazenarApps, float espacoTotalBytes, 
                     float numFotos, int numApps, ArrayList<String> appsInst, ArrayList<String> mensagens) {
        this.marca = marca;
        this.modelo = modelo;
        this.x = x;
        this.y = y;
        this.armazenarMensagens = armazenarMensagens;
        this.armazenarFotos = armazenarFotos;
        this.armazenarApps = armazenarApps;
        this.espacoTotalBytes = espacoTotalBytes;
        this.numFotos = numFotos;
        this.numApps = numApps;

        this.appsInst = new ArrayList<String>(numApps);
        for (String app : appsInst) 
            this.appsInst.add(app);

        this.mensagens = new ArrayList<String>(mensagens.size());
        for(String msg : mensagens) 
            this.mensagens.add(msg);
    }

    public Telemovel(Telemovel tlm){
        this.marca = tlm.getMarca();
        this.modelo = tlm.getModelo();
        this.x = tlm.getX();
        this.y = tlm.getY();
        this.armazenarMensagens = tlm.getArmazenarMensagens();
        this.armazenarFotos = tlm.getArmazenarFotos();
        this.armazenarApps = tlm.getArmazenarApps();
        this.espacoTotalBytes = tlm.getEspacoTotalBytes();
        this.numFotos = tlm.getNumFotos();
        this.numApps = tlm.getnumApps();

        this.appsInst = new ArrayList<String>(numApps);
        for (String app : tlm.appsInst) 
            this.appsInst.add(app);

        this.mensagens = new ArrayList<String>(tlm.mensagens.size());
        for(String msg : tlm.mensagens) 
            this.mensagens.add(msg);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getArmazenarMensagens() {
        return armazenarMensagens;
    }

    public void setArmazenarMensagens(float armazenarMensagens) {
        this.armazenarMensagens = armazenarMensagens;
    }

    public float getArmazenarFotos() {
        return armazenarFotos;
    }

    public void setArmazenarFotos(float armazenarFotos) {
        this.armazenarFotos = armazenarFotos;
    }

    public long getArmazenarApps() {
        return armazenarApps;
    }

    public void setArmazenarApps(float armazenarApps) {
        this.armazenarApps = armazenarApps;
    }

    public long getEspacoTotalBytes() {
        return espacoTotalBytes;
    }

    public void setEspacoTotalBytes(float espacoTotalBytes) {
        this.espacoTotalBytes = espacoTotalBytes;
    }

    public long getNumFotos() {
        return numFotos;
    }

    public void setNumFotos(float numFotos) {
        this.numFotos = numFotos;
    }

    public int getNumApps() {
        return numApps;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public ArrayList <String> get() {
        return this.appsInst;
    }

    public void setAppsInst(ArrayList<String> appsInst) {
        this.appsInst = new ArrayList<String>(this.numApps);
        for (String app : appsInst)
            this.appsInst.add(app);
    }

    public ArrayList <String> getMensagens() {
        return this.mensagens;
    }

    public void setMensagens(ArrayList<String> mensagens) {
        this.mensagens = new ArrayList<String>(mensagens.size());
        for (String msg : mensagens)
            this.mensagens.add(msg);
    }

    public Phone clone(Telemovel tlm) {
        return (new Telemovel(this));
    }

    public void tlmtoString() {
        System.out.println(("Telemóvel: "));
        System.out.println(("   Marca: "));
        
    }

}
