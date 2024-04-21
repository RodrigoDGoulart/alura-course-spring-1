package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.entities.Medico;
import med.voll.api.records.DadosCadastroMedico;
import med.voll.api.repositories.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private MedicoRepository repository;
  
  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody DadosCadastroMedico dados) {
    repository.save(new Medico(dados));
  }
}
