import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;



    public Tarefa(String titulo, String descricao, LocalDate dataEntrega){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;

    }

    //Métodos
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() { //Retorna o objeto
        return "Tarefa {" +
                "titulo = '" + titulo + '\'' +
                ", descricao ='" + descricao + '\'' +
                ", dataEntrega =" + dataEntrega +
                ", concluida =" + concluida +
                '}';
    }
}

