package med.voll.api.records;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico (
  @NotNull Long id,
  String telefone,
  String nome,
  DadosEndereco endereco
) {
}
