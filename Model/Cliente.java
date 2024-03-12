package Model;

public class Cliente {
    private String identificador;
    private String nome;

    public Cliente(String identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


