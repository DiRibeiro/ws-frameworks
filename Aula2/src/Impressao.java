//Classe: Impressao
//Atributos: data (data da impressão), publicação (qual Livro ou Revista se refere a
//impressão), código (string - código autogerado). O código será gerado com o primeiro dígito
//sendo R (para revista) ou L (para livro) concatenado com o número de objetos instanciados
//        de Impressao, exemplo: R1, L125. Observe que será necessário um atributo privado que
//armazene a quantidade de objetos criados da entidade.
//Construtor: Crie o construtor que receba um objeto de uma Publicacao. No construtor deve
//ser gerado e atribuido um código e para a data, considere a data do sistema.
//        Métodos: getPublicacao(), getCodigo(), getData.
//toString() → retorne String formatada como o exemplo:
//        >“exemplar: R458| Data impressao: 25/03/2021
//        > Revista: TituloInteressante (3/2021) - editora Pamimi - edicao n:15”
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Impressao {

    private static int quantidadeObjetos = 0;
    private final String codigo;
    private final Date data;
    private final Publicacao publicacao;

    // Construtor
    public Impressao(Publicacao publicacao) {
        this.codigo = generateCodigo(publicacao);
        this.data = new Date();
        this.publicacao = Objects.requireNonNull(publicacao, "A publicação não pode ser nula");
        quantidadeObjetos++;
    }

    // Métodos
    public Publicacao getPublicacao() {
        return publicacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getData() {
        return new Date(data.getTime());
    }

    // Método auxiliar para gerar o código
    private String generateCodigo(Publicacao publicacao) {
        char tipo = (publicacao instanceof Livro) ? 'L' : 'R';
        return tipo + String.valueOf(quantidadeObjetos);
    }

    // toString() - Reimplementação
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(data);

        return String.format("exemplar: %s| Data impressao: %s\n%s",
                codigo, dataFormatada, publicacao.toString());
    }
}