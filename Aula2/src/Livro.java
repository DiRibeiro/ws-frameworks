import java.lang.reflect.Array;

//Classe: Livro (herda de Publicacao)
//Atributos: paginas (nº de páginas) e autores (vetor de String)
//Construtor: Crie o construtor com todos atributos, considere que os autores são passados
//por último usando varargs (para saber mais pesquise por “Java varargs”).
//Métodos: getAutores() e getPaginas()
//equals() → reimplemente o equals para testar se dois livros são iguais
//toString() → retorne String formatada como o exemplo:
//        >“Livro: titulo legal (2012) - 154 paginas - Autores: Julio Gil, Carla Silva”
import java.util.Arrays;
import java.util.Objects;

public class Livro extends Publicacao {

    private final int paginas;
    private final String[] autores;

    // Construtor
    public Livro(String titulo, int anoPublicacao, int paginas, String... autores) {
        super(titulo, anoPublicacao);
        if (paginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser maior que zero");
        }
        this.paginas = paginas;
        this.autores = Objects.requireNonNull(autores, "A lista de autores não pode ser nula");
    }

    // Métodos
    public String[] getAutores() {
        return Arrays.copyOf(autores, autores.length);
    }

    public int getPaginas() {
        return paginas;
    }

    // equals() - Reimplementação
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Livro)) return false;
        Livro livro = (Livro) obj;
        return super.equals(obj) && paginas == livro.paginas && Arrays.equals(autores, livro.autores);
    }

    // toString() - Reimplementação
    @Override
    public String toString() {
        return String.format("Livro: %s (%d) - %d páginas - Autores: %s",
                getTitulo(), getAnoPublicacao(), paginas, Arrays.toString(autores));
    }
}
