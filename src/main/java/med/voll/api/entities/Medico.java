package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.records.DadosAtualizacaoMedico;
import med.voll.api.records.DadosCadastroMedico;
import med.voll.api.records.Especialidade;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String telefone;
  private String crm;

  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;

  @Embedded
  private Endereco endereco;

  private Short ativo;

  public Medico(DadosCadastroMedico dados) {
    this.ativo = 1;
    this.nome = dados.nome();
    this.email = dados.email();
    this.telefone = dados.telefone();
    this.crm = dados.crm();
    this.especialidade = dados.especialidade();
    this.endereco = new Endereco(dados.endereco());
  }

  public void atualizarInfos (DadosAtualizacaoMedico dados) {
    
    if(dados.nome() != null) {
      this.nome = dados.nome();
    }

    if(dados.telefone() != null) {
      this.telefone = dados.telefone();
    }

    if (dados.endereco() != null) {
      this.endereco.atualizarInfos(dados.endereco());
    }
  }

  public void excluir () {
    this.ativo = 0;
  }

}
