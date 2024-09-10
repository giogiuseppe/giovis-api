package giovis.api.domain.produto;

public record DadosListagemProduto(
        Long id,
        String nome,
        Double preco_unitario,
        Categoria categoria,
        String descricao,
        Status status
) {
    public DadosListagemProduto(Produto produto) {
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