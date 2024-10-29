package test;

import model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.PessoaRepository;
import service.PessoaService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setEmail("joao@example.com");

        pessoaService.salvar(pessoa); // Chama o método salvar

        // Verifica se o repositório foi chamado uma vez
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testSalvarPessoaNomeVazio() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(""); // Nome vazio
        pessoa.setEmail("joao@example.com");

        // Espera uma exceção ser lançada
        try {
            pessoaService.salvar(pessoa);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().equals("Nome não pode ser vazio"));
        }
    }

    // Outros testes...
}
