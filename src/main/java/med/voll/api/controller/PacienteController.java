package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.entities.Paciente;
import med.voll.api.records.DadosCadastroPaciente;
import med.voll.api.records.DadosListagemPaciente;
import med.voll.api.repositories.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

  @Autowired
  private PacienteRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
    repository.save(new Paciente(dados));
  }

  @GetMapping
  @Transactional
  public Page<DadosListagemPaciente> listar(Pageable paginacao) {
    return repository.findAll(paginacao).map(DadosListagemPaciente::new);
  }
}
