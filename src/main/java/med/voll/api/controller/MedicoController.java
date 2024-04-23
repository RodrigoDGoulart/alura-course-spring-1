package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.entities.Medico;
import med.voll.api.records.DadosAtualizacaoMedico;
import med.voll.api.records.DadosCadastroMedico;
import med.voll.api.records.DadosListagemMedico;
import med.voll.api.repositories.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private MedicoRepository repository;
  
  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
    repository.save(new Medico(dados));
  }

  @GetMapping
  public Page<DadosListagemMedico> listar(
    // alterar padrão para trazer 10 registros por página e ordenar em ordem alfabética pela coluna "nome"
    @PageableDefault(
      size = 10,
      sort = {"nome"}
    ) 
    Pageable paginacao
  ) {
    short ativo = 1;
    return repository.findAllByAtivo(ativo, paginacao).map(DadosListagemMedico::new);
  }

  @PutMapping
  @Transactional
  public void editar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
    var medico = repository.getReferenceById(dados.id());
    medico.atualizarInfos(dados);
  }
  
  @DeleteMapping("/{id}")
  @Transactional
  public void excluir(@PathVariable Long id) {
    // literal delete
    // repository.deleteById(id);

    // logical delete
    var medico = repository.getReferenceById(id);
    medico.excluir();
  }

}
