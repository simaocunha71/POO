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
                     int numFotos, int numApps, ArrayList<String> appsInst, ArrayList<String> mensagens) {
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
        this.numApps = tlm.getNumApps();

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

    public float getArmazenarApps() {
        return armazenarApps;
    }

    public void setArmazenarApps(float armazenarApps) {
        this.armazenarApps = armazenarApps;
    }

    public float getEspacoTotalBytes() {
        return espacoTotalBytes;
    }

    public void setEspacoTotalBytes(float espacoTotalBytes) {
        this.espacoTotalBytes = espacoTotalBytes;
    }

    public int getNumFotos() {
        return numFotos;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public int getNumApps() {
        return numApps;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public ArrayList <String> getAppsInst() {
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

    public Telemovel clone(Telemovel tlm) {
        return (new Telemovel(this));
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Telemovel = {");
        sb.append("Marca = ").append(marca);
        sb.append(", Modelo = ").append(modelo);
        sb.append(", Resoluçao = ").append(x);
        sb.append("X").append(y);
        sb.append(", Tamanho disponivel para mensagens = ").append(armazenarMensagens);
        sb.append(", Tamanho total para mensagens e fotografias = ").append(armazenarFtAppTotal);
        sb.append(", Tamanho disponivel para fotografias = ").append(armazenarFotos);
        sb.append(", Tamanho disponivel para aplicaçoes = ").append(armazenarApps);
        sb.append(", Capacidade do disco usada = ").append(espacoTotalBytes);
        sb.append(", Numero de fotografias = ").append(numFotos);
        sb.append(", Numero de aplicaçoes = ").append(numApps);
        sb.append(", Nome das aplicaçoes = ").append(appsInst);
        sb.append(", Descriçao das mensagens = ").append(mensagens);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Telemovel tlm = (Telemovel) o;
        return (this.getMarca().equals(tlm.getMarca()) 
                && this.getArmazenarApps() == tlm.getArmazenarApps()
                && this.getModelo() == tlm.getModelo()
                && this.getArmazenarMensagens() == tlm.getArmazenarMensagens() 
                && this.getX() == tlm.getX()
                && this.getY() == tlm.getY()
                && this.getAppsInst().toString().equals(this.getAppsInst().toString())
                && this.getMensagens().toString().equals(tlm.getMensagens().toString()) 
                && this.getNumApps() == tlm.getNumApps()
                && this.getNumFotos() == tlm.getNumFotos() 
                && this.getArmazenarFotos() == tlm.getArmazenarFotos() 
                && this.getEspacoTotalBytes() == tlm.getEspacoTotalBytes());
    }

    public boolean existeEspaco(int numeroBytes){
        return (numeroBytes + this.espacoTotalBytes < this.armazenarFtAppTotal + this.armazenarMensagens);
    }

    public void instalaApp(String nome, int tamanho){
        this.numApps++;
        this.armazenarApps += tamanho;
        this.appsInst.add(nome);
    }

    public void recebeMsg(String msg){
        this.armazenarMensagens += msg.length();
        this.mensagens.add(msg);
    }

    public double tamMedioApps(){
        return ((double) this.armazenarApps / this.numApps);
    }

    public String maiorMsg(){
        int maiorM = Integer.MIN_VALUE; // comprimento da menor mensagem possivel
        String res = "";
        for (String msg : this.mensagens)
            if (msg.length() > maiorM) {
                res = msg;
                maiorM = msg.length();
            }
        return res;
    }

    public void removeApp(String nome, int tamanho){
        this.armazenarApps -= tamanho;
        this.numApps--;
        this.appsInst.remove(nome);
    }

    public static void main(String[] args) {

        ArrayList<String> apps = new ArrayList<String>();
        apps.add("NewStarSoccer");
        apps.add("MadFut");
        ArrayList<String> msg = new ArrayList<String>();
        msg.add("Sou lindo");
        msg.add("Sou gostoso!");
        System.out.println(("1º telemovel:"));
        Telemovel t1 = new Telemovel("Xiaomi", "Pocophone F1", 1920, 1080, 2000, 5000, 5000, 20, 2, 2, apps, msg);
        System.out.println(t1.toString());

        System.out.println("--------------------------------------------------------------");
        System.out.println(("2º telemovel:"));
        Telemovel t2 = new Telemovel(t1);
        System.out.println(t2.toString());
        t1.instalaApp("Instagram", 20);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Instalar uma aplicaçao...");
        System.out.println(t1.toString());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Introduzir uma mensagem...");
        t1.recebeMsg("Tenho de evacuar, uma vez que tenho uma consulta às 5h");
        System.out.println("----------------------------------------------------------------");
        System.out.println(t1.toString());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Maior mensagem no sistema: "+ t1.maiorMsg());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Remover uma aplicaçao...");
        t1.removeApp("Instagram", 20);
        System.out.println(t1.toString());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Tamanho medio das aplicaçoes instaladas: " + t1.tamMedioApps()); 
    }
}

