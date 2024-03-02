//Classe: Livraria
//Atributos: nome e estoque (ArrayList - lista de impressões)
//Construtor: Crie o construtor que receba o nome e inicialize a lista
//Métodos: getNome().
//getExemplares(Publicacao) → retorna o número de impressões existentes no estoque da
//publicação passada por parâmetro.
//addEstoque(Publicacao) → cria e adiciona uma impressão da publicação no estoque.
//addEstoque(Publicacao, x:int) → cria e adiciona X impressões da publicação no estoque.
//vende(Publicacao) → procura, retira do estoque e retorna o primeiro exemplar (impressão)
//da publicação passada por parâmetro. Caso não encontre, retornar null
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Livraria {

    private String nome;
    private List<Impressao> estoque;

    // Construtor
    public Livraria(String nome) {
        this.nome = nome;
        this.estoque = new ArrayList<>();
    }

    // Método para obter o nome da livraria
    public String getNome() {
        return nome;
    }

    // Método para obter o número de exemplares (impressões) no estoque para uma publicação
    public int getExemplares(Publicacao publicacao) {
        int count = 0;
        for (Impressao impressao : estoque) {
            if (impressao.getPublicacao().equals(publicacao)) {
                count++;
            }
        }
        return count;
    }

    // Método para adicionar uma impressão da publicação ao estoque
    public void addEstoque(Publicacao publicacao) {
        Impressao novaImpressao = new Impressao(publicacao);
        estoque.add(novaImpressao);
    }

    // Método para adicionar X impressões da publicação ao estoque
    public void addEstoque(Publicacao publicacao, int x) {
        for (int i = 0; i < x; i++) {
            addEstoque(publicacao);
        }
    }

    // Método para vender uma impressão da publicação
    public Impressao vende(Publicacao publicacao) {
        Iterator<Impressao> iterator = estoque.iterator();

        while (iterator.hasNext()) {
            Impressao impressao = iterator.next();
            if (impressao.getPublicacao().equals(publicacao)) {
                iterator.remove();
                return impressao;
            }
        }

        return null; // Retorna null se não encontrar a publicação no estoque
    }
}
