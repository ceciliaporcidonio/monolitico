package controller;

import model.Pessoa;
import service.PessoaService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean
@ViewScoped
public class PessoaController {
    private Pessoa pessoa = new Pessoa();

    @Autowired
    private PessoaService service;

    public void salvar() {
        service.salvar(pessoa);
        pessoa = new Pessoa(); // Limpa os campos após salvar
    }

    // Getters e Setters
}
