import java.util.ArrayList;

public class FBPost {
    private int id;
    private String nomeUtilizadorCriacaoPost;
    private LocalDateTime data;
    private String conteudoPost;
    private int likes;
    private ArrayList <comentario> comentarios;

    public FBPost(int id, String nomeUtilizadorCriacaoPost,
                  LocalDateTime data, String conteudoPost,int likes,
                  ArrayList<String> comentarios ){
        this.id = id;
        this.nomeUtilizadorCriacaoPost = nomeUtilizadorCriacaoPost;
        this.data = data;
        this.conteudoPost = conteudoPost;
        this.likes = likes;
        this.setComentarios (comentarios);
    }

    public FBPost (int id, String nomeUtilizadorCriacaoPost,
                  LocalDateTime data, String conteudoPost, int likes){
        this.id = id;
        this.nomeUtilizadorCriacaoPost = nomeUtilizadorCriacaoPost;
        this.data = data;
        this.likes = likes;
        this.conteudoPost = conteudoPost;
        this.comentarios = new ArrayList<>();
    }

    public FBPost (FBPost f){
        this.id = f.getId();
        this.nomeUtilizadorCriacaoPost = getNomeUtilizadorCriacaoPost();
        this.data = getData();
        this.conteudoPost = getConteudoPost();
        this.likes = getLikes();
        this.comentarios = getComentarios();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        FBPost f = (FBPost) o;
        return (this.id == f.getId()                                                          && 
                this.nomeUtilizadorCriacaoPost.equals(f.getNomeUtilizadorCriacaoPost())       && 
                this.data.equals(f.getData())                                                 && 
                this.conteudoPost.equals(f.getConteudoPost())                                 && 
                this.likes == f.getLikes()                                                    && 
                this.comentarios.equals(f.getComentarios()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FBPost: ").append("Id da publicação: ").append(id).append(" | Utilizador: ")
                .append(user).append(" | Data da publicação: ").append(date).append(" | Conteudo do post: ").append(content)
                .append(" | Likes: ").append(likes).append(" | Comentários: ").append(coms.toString()).append("\n");
        return sb.toString();
    }

    public FBPost clone() {
        return new FBPost(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUtilizadorCriacaoPost() {
        return nomeUtilizadorCriacaoPost;
    }

    public void setNomeUtilizadorCriacaoPost(String nomeUtilizadorCriacaoPost) {
        this.nomeUtilizadorCriacaoPost = nomeUtilizadorCriacaoPost;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getConteudoPost() {
        return conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
