import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;

    public FBFeed(List<FBPost> posts) {
        this.setPosts(posts);
    }

    public FBFeed(FBFeed f) {
        this.setPosts(f.getPosts());
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

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        FBFeed f = (FBFeed) o;
        return this.posts.equals(f.posts);
    }

    /**
     * Devolve o numero de posts de um utilizador
     * @param user Nome do utilizador
     * @return Numero de posts de um utilizador
     */
    public int nrPosts(String user){
        return (int) this.posts.stream().filter(post->post.getNomeUtilizadorCriacaoPost().equals(user)).count();
    }

    /**
     * Dado um user, calcula todos os seus comentarios
     * @param user utilizador
     * @return Comentarios do utilizador
     */
    public List<FBPost> postsOf(String user){
        return (List <FBPost>) this.posts.stream().filter(post -> post.getNomeUtilizadorCriacaoPost().equals(user)).collect(Collectors.toList());
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
        post.getComentarios().add(comentario);
    }

    /**
     * Adiciona um comentario a um post, tendo como argumentos um id e um comentario
     * @param postid id do post
     * @param comentario comentario a adicionar
     */
    public void comment(int postid, String comentario){
        comment(getPost(postid), comentario);
    }

    /**
     * Incrementa o numero de likes de um post
     * @param post Post aonde se vai incrementar os likes
     */
    public void like(FBPost post){
        post.setLikes(post.getLikes()+1);
    }

    /**
     * Incrementa o numero de likes de um post, dando como argumento um id
     * @param postid id do post
     */
    public void like(int postid){
        like(getPost(postid));
    }

    /**
     * Calcula o top5 dos ids com mais comentarios (usando iterador externo)
     * @return Top5 dos mais comentadores
     */
    public List<Integer> top5CommentsIteradorExterno(){
        ArrayList<FBPost> copy = new ArrayList<>(this.posts);
        List<Integer> top5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FBPost maisComentado = null;
            for (FBPost f : copy)
                if (maisComentado == null || maisComentado.getComentarios().size() < f.getComentarios().size())
                    maisComentado = f;
            top5.add(maisComentado.getId()); //adiciona o mais comentado na list top5
            copy.remove(maisComentado);      //remove o mais comentado do arrayList posts
        }
        return top5;
    }


    /**
     * Calcula o top5 dos ids com mais comentarios (usando iterador interno)
     * @return Top5 dos mais comentadores
     */
    public List<Integer> top5CommentsIteradorInterno() {
        return this.posts.stream() //percorre uma stream
                .sorted((Comparator<? super FBPost>) (p1, p2) -> p2.getComentarios().size() - p1.getComentarios().size())
                .limit(5) //máximo 5 elementos na lista
                .map(FBPost::getId) // busca o id dos 5 primeiros posts
                .collect(Collectors.toList()); //mete os ids numa lista
    }


    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.JANUARY, 31, 16, 32);
        FBPost post1 = new FBPost(1, "Darwin"           , dateTime                             , "Amanha vou marcar um golo!"              , 10  , new ArrayList<>());
        FBPost post2 = new FBPost(2, "Seferovic"        , dateTime                             , "Melhor hat-trick da historia do Benfica.", 42  , new ArrayList<>());
        FBPost post3 = new FBPost(3, "Pizzi"            , dateTime                             , "Ninguem cruza melhor do que eu!"         , 0);
        FBPost post4 = new FBPost(4, "Grimaldo"         , dateTime                             , "Excelente piada, Pizzi!"                 , 104);
        FBPost post5 = new FBPost(5, "Taraabt"          , LocalDateTime.of(2021, 3, 12, 10, 41), "Onde é a festa?"                         , 2994, new ArrayList<>());
        FBPost post6 = new FBPost(6, "Otamendi"         , dateTime                             , "Mas isto não é o Porto?"                 , 26);
        FBPost post7 = new FBPost(7, "Éverton Cebolinha", dateTime                             , "Que horas são?"                          , 12  , new ArrayList<>());

        ArrayList<FBPost> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
        posts.add(post7);

        FBFeed feed = new FBFeed(posts);

        feed.comment(5, "Tiki taka à la Benfica");
        feed.comment(7, "Faz o golo alé");
        feed.comment(3, "Chuta daí pah");
        feed.comment(3, "Mete o Weigl");
        feed.comment(3, "Volta Lage, estás perdoado");
        feed.comment(6, "Não queres partilhar um bocadinho? :p");
        feed.comment(1, "Boa tarde!");
        feed.comment(7, "Passa a bola e desmarca-te!");

        feed.like(1);

        System.out.println("Teste função nrPosts: "
                + (feed.nrPosts("Grimaldo") == 2 && feed.nrPosts("Seferovic") == 1 && feed.nrPosts("Éverton Cebolinha") == 0 ? "Passou"
                        : "Não passou"));
        System.out.println("Teste função postsOf: " + feed.postsOf("Pizzi"));

        System.out.println("Teste função postsOf em 2020: "
                + feed.postsOf("Darwin", LocalDateTime.of(2020, 1, 1, 0, 0), LocalDateTime.now()));

        System.out.println("Teste função top 5 ext: " + feed.top5CommentsIteradorExterno());
        System.out.println("Teste função top 5 int: " + feed.top5CommentsIteradorInterno());
    }
}
