package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

  private String logradouro;
  private String bairro;
  private String cep;
  private String cidade;
  private String uf;
  private String complemento;
  private String numero;

}
