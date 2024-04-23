package med.voll.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.entities.Medico;

// JpaRepository<TipoEntidade, TipoId>
public interface MedicoRepository extends JpaRepository<Medico, Long> {
  Page<Medico> findAllByAtivo(short ativo, Pageable paginacao);
}
