import java.util.List;

public class FBFeed {
    private List<FBPost> posts;

    public FBFeed(List<FBPost> posts) {
        this.setPosts(ps);
    }

    public FBFeed(FBFeed f) {
        this.setPosts(f.getPosts());
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        FBFeed f = (FBFeed) o;
        return (f.getPosts().equals(o.getPosts()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FBFeed: ").append(posts).append("\n");
        return sb.toString();
    }

    public FBFeed clone() {
        return new FBFeed(this);
    }

    public List<FBPost> getPosts() {
        return posts;
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = posts;
    }

    /**
     * Devolve o numero de posts de um utilizador
     * @param user Nome do utilizador
     * @return Numero de posts de um utilizador
     */
    public int nrPosts(String user){
        return (int) this.posts.stream().filter(ps->post.getNomeUtilizadorCriacaoPost().equals(user)).count();
    }

    /**
     * Dado um user, calcula todos os seus comentarios
     * @param user utilizador
     * @return Comentarios do utilizador
     */
    public List<FBPost> postsOf(String user){
        return (List <FBPost>) this.posts.stream().filter(post -> post.getNomeUtilizadorCriacaoPost().equals(user)).count()
                .collect(Collectors.toList());
    }

    /**
     * Dado um user, calcula todos os seus comentarios num intervalo de tempo
     * @param user utilizador
     * @param inicio instante inicial
     * @param fim instante final
     * @return Comentarios do utilizador
     */
    public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
        return (List<FBPost>) this.posts.stream().filter(post -> post.getNomeUtilizadorCriacaoPost().equals(user)
                                                                 && post.getData().compareTo(inicio) > 0
                                                                 && post.getData().compareTo(fim) < 0)
                            .count()
                            .collect(Collectors.toList());
    }

    /**
     * Dado um id, devolve o respetivo post
     * @param id identificador do post
     * @return Post
     */
    public FBPost getPost(int id){
        for (FBPost post : this.posts)
            if (post.getId() == id)
                return post;
        return null;
    }

    /**
     * Adiciona um comentario à lista de comentarios de um post
     * @param post Post onde adicionar
     * @param comentario Comentario a adicionar
     */
    public void comment(FBPost post, String comentario){
        this.post.getComentarios().add(comentario);
    }

    /**
     * Adiciona um comentario a um post, tendo como argumentos um id e um comentario
     * @param postid id do post
     * @param comentario comentario a adicionar
     */
    public void comment(int postid, String comentario){
        this.posts.comment(getPost(postid), comentario);
    }

    /**
     * Incrementa o numero de likes de um post
     * @param post Post aonde se vai incrementar os likes
     */
    public void like(FBPost post){
        this.posts.setLikes(post.getLikes()+1);
    }

    /**
     * Incrementa o numero de likes de um post, dando como argumento um id
     * @param postid id do post
     */
    public void like(int postid){
        this.posts.setLikes(getPost(postid).getLikes() + 1);
    }

    
}
