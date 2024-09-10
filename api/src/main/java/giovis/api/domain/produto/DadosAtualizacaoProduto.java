package giovis.api.domain.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProduto(
        @NotNull
        Long id,
        String nome,
        Double preco_unitario,
        Categoria categoria,
        String descricao,
        Status status
) {
}