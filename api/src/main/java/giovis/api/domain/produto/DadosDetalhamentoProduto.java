package giovis.api.domain.produto;

public record DadosDetalhamentoProduto(
        Long id,
        String nome,
        Double preco_unitario,
        Categoria categoria,
        String descricao,
        Status status

) {
    public DadosDetalhamentoProduto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco_unitario(),
                produto.getCategoria(),
                produto.getDescricao(),
                produto.getStatus()
        );
    }
}