package med.voll.api.records;

import med.voll.api.entities.Paciente;

public record DadosListagemPaciente (
  String nome,
  String email,
  String cpf
) {

  public DadosListagemPaciente(Paciente paciente) {
    this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
  }
  
}
