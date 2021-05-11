/*********************************************************************************/
/** DISCLAIMER: Este codigo foi criado e alterado durante as aulas praticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** Até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canonica,  */
/** ou mesmo acabada. Ã‰ disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos sÃ£o encorajados a testar adequadamente o cÃ³digo fornecido e a      */
/** procurar soluÃ§Ãµes alternativas, Ã  medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/ 
package veiculos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe veiculo, para utilizaçao na Ficha 6.
 *
 * @author MaterialPOO
 * @version 20210420
 */

public abstract class Veiculo implements Comparable<Veiculo>, Serializable {
    private String marca;
    private String modelo;
    private String matricula;
    private int ano;
    private double velocidadeMedia;
    private double precokm;
    private ArrayList<Integer> classificacao;
    private int kms;
    private int kmsUltimo; // kms da ultima viagem??

    /**
     * Construtores
    */


    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.matricula = "";
        this.ano = 0;
        this.velocidadeMedia = 0;
        this.precokm = 0;
        this.classificacao = new ArrayList<>();
        this.kms = 0;
        this.kmsUltimo = 0;
    }
    
    public Veiculo(String marca, String modelo, String matricula,
                   int ano, double velocidadeMedia, double precokm,
                   ArrayList<Integer> classificacao,
                   int kms, int kmsUltimo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.ano = ano;
        this.velocidadeMedia = velocidadeMedia;
        this.precokm = precokm;
        this.classificacao = new ArrayList<>(classificacao);
        this.kms = kms;
        this.kmsUltimo = kmsUltimo;
    }

    

    public Veiculo(Veiculo v){
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.matricula = v.getMatricula();
        this.ano = v.getAno();
        this.velocidadeMedia = v.getVelocidadeMedia();
        this.precokm = v.getPrecokm();
        this.classificacao = v.getClassificacao();
        this.kms = v.getKms();
        this.kmsUltimo = v.getKmsUltimo();

    }
    
    
    
    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public double getPrecokm() {
        return precokm;
    }

    
    /**
     * Se a implementação fosse:
     *   return this.classificacao;
     *   
     *   
     * No programa principal:
     *   List<Integer> l = v.getClassificacao();
     *   
     *   l.clear(); --> acontecia que internamente o arraylist de classificaÃ§Ãµes
     *                  tb era "apagado". Isso é uma quebra de encapsulamento.
     */
    
    public ArrayList<Integer> getClassificacao() {
        return new ArrayList<>(classificacao);
    }

    public int getKms() {
        return kms;
    }

    public int getKmsUltimo() {
        return kmsUltimo;
    }

    public void setVelocidadeMedia(double vm) {
        this.velocidadeMedia = vm;
    }

    public void setPrecokm(double precokm) {
        this.precokm = precokm;
    }

    public void addViagem(int nkms){
        this.kms += nkms;
        this.kmsUltimo = nkms;
    }

    
    /**
     * Esta implementação poderá ser alterada.
     * Neste momento considera-se que o custo é 10% acima do custo teórico. 
     * Poderia ser também em função dos kms realizados.
     */
    
    public double custoRealKM(){
        return this.precokm*1.1;
    }

    
    public int classificacao(){
       return (int) this.classificacao.stream().mapToInt(k->k.intValue()).average().getAsDouble();
    }

    public void addClassificacao(int v){
        this.classificacao.add(v);
    }

    public abstract Veiculo clone();
    
    

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        Veiculo v = (Veiculo) o;
        return  this.marca.equals(v.getMarca()) &&
            this.modelo.equals(v.getModelo())&&
            this.matricula.equals(v.getMatricula()) &&
            this.ano == v.getAno() &&
            this.velocidadeMedia == v.getVelocidadeMedia() &&
            this.precokm == v.getPrecokm() &&
            this.classificacao.equals(v.getClassificacao()) &&
            this.kms == v.getKms() &&
            this.kmsUltimo == v.getKmsUltimo() ;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro: {");
        sb.append("Marca: ").append(marca);
        sb.append(", Modelo: ").append(modelo);
        sb.append(", Matricula: ").append(matricula);
        sb.append(", Ano: ").append(ano);
        sb.append(", Velocidade média: ").append(velocidadeMedia);
        sb.append(", Preço/km: ").append(precokm);
        sb.append(", Classificaçao: ").append(classificacao.toString());
        sb.append(", Kms: ").append(kms);
        sb.append(", Km na ultima viagem: ").append(kmsUltimo);
        sb.append("}");
        return sb.toString();
    }


    /**
     * Implementação da ordem natural dos veiculos
     */
    public int compareTo(Veiculo v) {
      if(this.marca.compareTo(v.getMarca()) == 0)
        return (this.modelo.compareTo(v.getModelo()));
      else
        return (this.marca.compareTo(v.getMarca()));        
    }   
}