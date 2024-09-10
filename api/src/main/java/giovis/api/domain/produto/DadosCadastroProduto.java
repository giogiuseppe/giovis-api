package giovis.api.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank
        String nome,
        @NotNull
        Double preco_unitario,
        @NotNull
        Categoria categoria,
        @NotBlank
        String descricao,
        @NotNull
        Status status
) {
}