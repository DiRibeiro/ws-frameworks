//Implementar um sistemas de exemplares de uma uma livraria. Para tanto deve ser
//implementado as classes: Livraria, Impressao, Publicacao, Livro e Revista. Considere a
//implementação pública dos métodos solicitados, outros métodos bem como os atributos
//devem ser encapsulados. Os atributos imutáveis, devem ser implementados assim. Para a
//validação dos valores (por exemplo o parâmetro de um setter) considere lançar Exceptions
//não verificadas. Para melhor representar as classes solicitadas, segue o diagrama de
//classes do problema:

public class Main {
    public static void main(String[] args) {
        try {
            // Criando instâncias de Livro e Revista
            Livro livro = new Livro("O Senhor dos Anéis", 1954, 1200, "J.R.R. Tolkien");
            Revista revista = new Revista("National Geographic", 2022, 3, "Editora Nacional");

            // Criando instâncias de Impressao e Livraria
            Impressao impressaoLivro1 = new Impressao(livro);
            Impressao impressaoLivro2 = new Impressao(livro);
            Impressao impressaoRevista = new Impressao(revista);

            Livraria livraria = new Livraria("Minha Livraria");

            // Adicionando exemplares ao estoque da livraria
            livraria.addEstoque(livro);
            livraria.addEstoque(livro, 2);
            livraria.addEstoque(revista);

            // Imprimindo informações
            System.out.println("Informações da Livraria:");
            System.out.println("Nome: " + livraria.getNome());

            System.out.println("\nExemplares no estoque:");
            System.out.println("Livro: O Senhor dos Anéis - " + livraria.getExemplares(livro) + " exemplar(es)");
            System.out.println("Revista: National Geographic - " + livraria.getExemplares(revista) + " exemplar(es)");

            // Venda de um exemplar
            Impressao venda = livraria.vende(livro);
            if (venda != null) {
                System.out.println("\nExemplar Vendido:");
                System.out.println(venda.toString());
            } else {
                System.out.println("\nExemplar não encontrado no estoque.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}