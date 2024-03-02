//Classe: Revista (herda de Publicacao)
//Atributos: edicao (nº da edicao) e editora
//Construtor: Crie o construtor com todos atributos.
//Métodos: getEdicao() e getEditora()
//equals() → reimplemente o equals para testar se duas revistas são iguais
//toString() → retorne String formatada como o exemplo:
//        >“Revista: TituloInteressante (3/2021) - editora Pamimi - edicao n:15”
import java.util.Objects;

public class Revista extends Publicacao {

    private final int edicao;
    private final String editora;

    // Construtor
    public Revista(String titulo, int anoPublicacao, int edicao, String editora) {
        super(titulo, anoPublicacao);
        if (edicao <= 0) {
            throw new IllegalArgumentException("O número da edição deve ser maior que zero");
        }
        this.edicao = edicao;
        this.editora = Objects.requireNonNull(editora, "A editora não pode ser nula");
    }

    // Métodos
    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    // equals() - Reimplementação
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Revista)) return false;
        Revista revista = (Revista) obj;
        return super.equals(obj) && edicao == revista.edicao && editora.equals(revista.editora);
    }

    // toString() - Reimplementação
    @Override
    public String toString() {
        return String.format("Revista: %s (%d) - editora %s - edicao n:%d",
                getTitulo(), getAnoPublicacao(), editora, edicao);
    }
}
