//Classe: Publicacao (classe abstrata, representa uma publicação genérica)
//Atributos: titulo e data
//Construtor: Crie o construtor com os dois atributos.
//        Métodos: getTitulo() e getData()
import java.util.Objects;

public abstract class Publicacao {

    private final String titulo;
    private final int anoPublicacao;

    // Construtor
    public Publicacao(String titulo, int anoPublicacao) {
        this.titulo = Objects.requireNonNull(titulo, "O título não pode ser nulo");
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("O ano de publicação deve ser maior que zero");
        }
        this.anoPublicacao = anoPublicacao;
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // equals() - Reimplementação
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Publicacao)) return false;
        Publicacao publicacao = (Publicacao) obj;
        return anoPublicacao == publicacao.anoPublicacao && titulo.equals(publicacao.titulo);
    }

    // hashCode() - Reimplementação para garantir consistência com equals()
    @Override
    public int hashCode() {
        return Objects.hash(titulo, anoPublicacao);
    }
}
