package tk.lvicenteaa.finca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.lvicenteaa.finca.entities.Finca;

@Repository
public interface FincaRepository extends JpaRepository<Finca, Long> {
}
