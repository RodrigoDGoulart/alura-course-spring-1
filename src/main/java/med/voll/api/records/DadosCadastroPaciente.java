package med.voll.api.records;

public record DadosCadastroPaciente (
  String nome,
  String email,
  String telefone,
  String cpf,
  DadosEndereco endereco
) {}
