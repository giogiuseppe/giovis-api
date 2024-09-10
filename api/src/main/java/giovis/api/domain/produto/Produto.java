package giovis.api.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco_unitario;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Boolean ativo;

    public Produto(DadosCadastroProduto dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.preco_unitario = dados.preco_unitario();
        this.categoria = dados.categoria();
        this.descricao = dados.descricao();
        this.status = dados.status();
    }

    public void atualizarInformacoes(DadosAtualizacaoProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.preco_unitario() != null) {
            this.preco_unitario = dados.preco_unitario();
        }
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}