import java.util.ArrayList;

public class Youtube {
    private String nome;
    private long bytes;
    private int dia;
    private int mes;
    private int ano;
    private int x;
    private int y;
    private int minutos;
    private int segundos;
    private ArrayList <String> comentarios;
    private int likes;
    private int dislikes;

    /**
     * 
     * @param nome Nome do video
     * @param bytes conteudo do video em bytes
     * @param dia dia do carregamento
     * @param mes mes do carregamento
     * @param ano ano do carregamento
     * @param x Resoluçao x
     * @param y Resoluçao y
     * @param minutos Minutos gravados
     * @param segundos Segundos gravados
     * @param comentarios Array de comentarios
     * @param likes Numero de likes
     * @param dislikes Numero de dislikes
     */
    public Youtube (String nome, long bytes, int dia, int mes, int ano, int x, int y, int minutos, int segundos, ArrayList <String> comentarios, int likes, int dislikes){
        this.nome = nome;
        this.bytes = bytes;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.x = x;
        this.y = y;
        this.minutos = minutos;
        this.segundos = segundos;
        this.comentarios = new ArrayList<String>(comentarios.size());
        for (String c : comentarios)
            this.comentarios.add(c);
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Youtube(Youtube y) {
        this.nome = y.getNome();
        this.bytes = y.getBytes();
        this.dia = y.getDia();
        this.mes = y.getMes();
        this.ano = y.getAno();
        this.x = getX();
        this.y = getY();
        this.minutos = getMinutos();
        this.segundos = getSegundos();
        this.comentarios = new ArrayList<String>(comentarios.size());
        for (String c : comentarios)
            this.comentarios.add(c);
        this.likes = getLikes();
        this.dislikes = getDislikes();
    }

    public Youtube clone (Youtube y){
        return new Youtube(this);
    }

    public String getNome() {
        return this.nome;
    }

    public long getBytes() {
        return this.bytes;
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public int getSegundos() {
        return this.segundos;
    }

    public ArrayList<String> getComentarios() {
        return this.comentarios;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("VideoYouTube = {");
        sb.append("Nome = ").append(nome);
        sb.append(", Conteudo em bytes = ").append(bytes);
        sb.append(", Resoluçao = ").append(x);
        sb.append("X").append(y);
        sb.append(", Data da publicação = ").append(dia);
        sb.append("/").append(mes);
        sb.append("/").append(ano);
        sb.append(", Duração do video ").append(minutos);
        sb.append(":").append(segundos);
        sb.append(", Comentarios: ").append(comentarios);
        sb.append(", Likes: ").append(likes);
        sb.append(", Dislikes: ").append(dislikes);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Youtube yt = (Youtube) o;
        return (this.getNome().equals(yt.getNome()) 
                && this.getBytes() == yt.getBytes()
                && this.getDia() == yt.getDia()
                && this.getMes() == yt.getMes() 
                && this.getAno() == yt.getAno()
                && this.getX() == yt.getX()
                && this.getY() == yt.getY()
                && this.getMinutos() == yt.getMinutos()
                && this.getSegundos() == yt.getSegundos()
                && this.getComentarios().toString().equals(yt.getComentarios().toString()) 
                && this.getLikes() == yt.getLikes()
                && this.getDislikes() == yt.getDislikes());
    }

    public void insereComentario(String c) {
        this.comentarios.add(c);
    }


    public void thumbsUp() {
        this.likes++;
    }

    public String processa() {
        return ("" + this.bytes);
    }

    public static void main(String[] args) {
        ArrayList<String> comms = new ArrayList<String>();
        comms.add("Ès o maior");
        comms.add("És fixe Riczao");

        System.out.println("VIDEO1");
        Youtube video1 = new Youtube("Trollei meu amigo e olha no que deu", 225454, 25,10,2001, 1024,1024, 25, 12, comms, 25, 12);
        System.out.println(video1.toString());

        System.out.println("----------------------------------------------------------------");

        //System.out.println("VIDEO2");
        //Youtube video2 = new Youtube(video1);

        //System.out.println(video2.toString());

        System.out.println("Mais um like");
        System.out.println("");
        video1.thumbsUp();
        //System.out.println(video2.toString());
        System.out.println("----------------------------------------------------------------");

        System.out.println("Adicionar comentario");
        System.out.println("");
        video1.insereComentario("Olha os paysafes vski");
        System.out.println(video1.toString());
        System.out.println("---------------------------------------------------------------");
       // POR FAZER -> System.out.println("Dias depois do upload do video: " + video1.qtsDiasDepois());
        System.out.println("Conteudo a processar: " + video1.processa());
    }
    
}
