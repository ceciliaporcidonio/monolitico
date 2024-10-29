package service;

import model.Pessoa;
import repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public void salvar(Pessoa pessoa) {
        // Validação das regras de negócio
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if (pessoa.getEmail() == null || pessoa.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }

        // Salva a pessoa no repositório
        repository.save(pessoa);
    }
}
