package giovis.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import giovis.api.domain.produto.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroProduto> dadosCadastroProdutoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoProduto> dadosDetalhamentoProdutoJson;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/produtos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var nome = "nome xyz";
        var preco_unitario = 100.0;
        var categoria = Categoria.manual;
        var descricao = "descricao xyz";
        var status = Status.disponivel;

        var response = mvc
                .perform(
                        post("/produtos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosCadastroProdutoJson.write(
                                        new DadosCadastroProduto(nome, preco_unitario, categoria, descricao, status)
                                ).getJson())
                )
                .andReturn().getResponse();

        assertEquals(201, response.getStatus());

        var jsonEsperado = dadosDetalhamentoProdutoJson.write(
                new DadosDetalhamentoProduto(null, nome, preco_unitario, categoria, descricao, status)
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}