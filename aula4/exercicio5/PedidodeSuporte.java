import java.time.LocalDateTime;

public class PedidodeSuporte {
    private String utilizador;
    private LocalDateTime data;
    private String problema;
    private String descricao;
    private String operadorSolucao;
    private LocalDateTime dataTratamento;
    private String descricaoTratamento;

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema, String descricao, 
                          String operadorSolucao, LocalDateTime dataTratamento, String descricaoTratamento) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = descricao;
        this.operadorSolucao = operadorSolucao;
        this.dataTratamento = dataTratamento;
        this.descricaoTratamento = descricaoTratamento;
    }

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema, String descricao) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = descricao;
        this.operadorSolucao = "";
        this.dataTratamento = null;
        this.descricaoTratamento = "";
    }

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = "";
        this.operadorSolucao = "";
        this.dataTratamento = null;
        this.descricaoTratamento = "";
    }

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema, String operadorSolucao, 
                           LocalDateTime dataTratamento, String descricaoTratamento) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = "";
        this.operadorSolucao = operadorSolucao;
        this.dataTratamento = dataTratamento;
        this.descricaoTratamento = descricaoTratamento;
    }

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema, String descricao, String operadorSolucao, LocalDateTime dataTratamento) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = descricao;
        this.operadorSolucao = operadorSolucao;
        this.dataTratamento = dataTratamento;
        this.descricaoTratamento = "";
    }

    public PedidodeSuporte(String utilizador, LocalDateTime data, String problema, String operadorSolucao, LocalDateTime dataTratamento) {
        this.utilizador = utilizador;
        this.data = data;
        this.problema = problema;
        this.descricao = "";
        this.operadorSolucao = operadorSolucao;
        this.dataTratamento = dataTratamento;
        this.descricaoTratamento = "";
    }

    public PedidodeSuporte() {
        this.utilizador = "";
        this.data = null;
        this.problema = "";
        this.descricao = "";
        this.operadorSolucao = "";
        this.dataTratamento = null;
        this.descricaoTratamento = "";
    }

    public PedidodeSuporte (PedidodeSuporte ps){
        this.utilizador = ps.getUtilizador();
        this.data = ps.getData();
        this.problema = ps.getProblema();
        this.descricao = ps.getDescricao();
        this.operadorSolucao = ps.getOperadorSolucao();
        this.dataTratamento = ps.getDataTratamento();
        this.descricaoTratamento = ps.getDescricaoTratamento();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido de Suporte: {");
        if (this.operadorSolucao.equals("")) {
            sb.append("Utilizador: ").append(utilizador)
              .append(" | Data do pedido: ").append(data.toString()).append(" | Problema: ").append(problema)
              .append(" | Descricao: ").append(descricao).append(" | Em espera pela solução").append("}\n");
        } 
        else {
            sb.append("Utilizador: ").append(utilizador)
              .append(" | Data do pedido: ").append(data.toString())
              .append(" | Problema: ").append(problema)
              .append(" | Descricao: ").append(descricao)
              .append(" | Empregado: ").append(operadorSolucao)
              .append(" | Data da resolucao ").append(dataTratamento.toString())
              .append(" | Descriçao da resolucao: ").append(descricaoTratamento)
              .append("}\n");
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o == null || this.getClass() != o.getClass())
            return false;
        PedidodeSuporte s = (PedidodeSuporte) o;
        return (this.utilizador.equals(s.getUtilizador()) 
                && this.data.equals(s.getData()) 
                && this.problema.equals(s.getProblema())
                && this.descricao.equals(s.getDescricao()) 
                && this.operadorSolucao.equals(s.getOperadorSolucao())
                && this.dataTratamento.equals(s.getDataTratamento()) 
                && this.descricaoTratamento.equals(s.getDescricaoTratamento()));
    }

    public PedidodeSuporte clone() {
        return new PedidodeSuporte(this);
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOperadorSolucao() {
        return operadorSolucao;
    }

    public void setOperadorSolucao(String operadorSolucao) {
        this.operadorSolucao = operadorSolucao;
    }

    public LocalDateTime getDataTratamento() {
        return dataTratamento;
    }

    public void setDataTratamento(LocalDateTime dataTratamento) {
        this.dataTratamento = dataTratamento;
    }

    public String getDescricaoTratamento() {
        return descricaoTratamento;
    }

    public void setDescricaoTratamento(String descricaoTratamento) {
        this.descricaoTratamento = descricaoTratamento;
    }
}
