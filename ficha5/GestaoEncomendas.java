import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GestaoEncomendas {

    // Associa o codigo de encomenta a uma lista de encomendas
    private Map<Integer, Encomenda> encomendas;
    
    public GestaoEncomendas(Map<Integer, Encomenda> e){
        encomendas = new TreeMap<>();
        for(Encomenda enc: e.values()){
            encomendas.put(enc.getNumeroEncomenda(), enc.clone());
        }
    }

    public GestaoEncomendas(GestaoEncomendas ge){
        encomendas = new TreeMap<>();
        for(Map.Entry<Integer, Encomenda> enc : ge.getEncomendas().entrySet()){
            encomendas.put(enc.getKey(), enc.getValue().clone());
        }
    }

    public Map<Integer, Encomenda> getEncomendas(){
        return encomendas.values().stream().collect(Collectors.toMap(e-> e.getNEnc(), e-> e.clone()));
    }

    public void setEncomendas(Map<Integer, Encomenda> e){
        encomendas = new TreeMap<>();
        for(Encomenda enc: e.values()){
            encomendas.put(enc.getNEnc(), enc.clone());
        }
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || this.getClass() != o.getClass()) return false;

        GestaoEncomendas ge = (GestaoEncomendas) o;
        return this.encomendas.equals(ge.getEncomendas());
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Encomenda e : encomendas.values()){
            sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
    }


    //ex1
    public Set<Integer> todosCodigosEnc(){
        //se fizessemos apenas return this.encomendas.keySet();, seria possivel apagar chaves do map.
        return new TreeSet<Integer>(this.encomendas.keySet());
    }

    //ex2
    public void addEncomenda(Encomenda enc){
        encomendas.put(enc.getNEnc(), enc.clone());
    }

    //ex3
    public Encomenda getEncomenda(Integer codEnc){
        Encomenda r = encomendas.get(codEnc);
        if (r != null) r = r.clone();
        return r;
    }
    
    public void removeEncomenda(Integer codEnc){
        this.encomendas.remove(codEnc);
    }

    // Nota: criado um metodo em Encomenda que determina a quantidade de produtos encomendados
    public Integer encomendaComMaisProdutos(){
        Comparator<Encomenda> comp = (e1,e2) -> (e1.numProdutos()) - (e2.numProdutos());
        TreeSet<Encomenda> aux = new TreeSet<>(comp);

        aux.addAll(this.encomendas.values());

        return (aux.last()).getEnc();
    }

    public Set<Integer> encomendasAposData(LocalDate d) {
        return this.encomendas.values().stream()
                                       .filter(e -> e.getData().isAfter(d))
                                       .map(Encomenda::getNEnc)
                                       .collect(Collectors.toSet());
    
    }

    public Set<Encomenda> encomendasValorDecrescente(){
        Comparator <Encomenda> comp = new EncVTComp();
        TreeSet<Encomenda> aux = new TreeSet<Encomenda>(comp);
        
        for(Encomenda e: this.encomendas.values())
            aux.add(e.clone());

        return aux;
    }

    public Collection<Encomenda> encomendasValorDecrescenteSafeExt() {
        List<Encomenda> aux = new ArrayList();

        for(Encomenda e: this.encomendas.values()) {
            aux.add(e.clone());
        }

        aux.sort(new EncVTComp());
        return aux;
    }

    public Collection<Encomenda> encomendasValorDecrescenteSafeInt(){
        return this.encomendas.values().stream().map(Encomenda::clone)
                                                .sorted(new EncVTComp())
                                                .collect(Collectors.toList());
    }

    public Map<String,List<Integer>> encomendasDeProduto(){
        Map <String,List<Integer>> aux = new HashMap <>();

        for(Encomenda e: this.encomendas.values()) {
            List <String> lprods = e.getListaProdutos();
            for(String codProd: lprods) {
                if(!aux.containsKey(codProd))
                    aux.put(codProd, new ArrayList<Integer>());
                aux.get(codProd).add(e.getNEnc());
            }
        }
    }
}
