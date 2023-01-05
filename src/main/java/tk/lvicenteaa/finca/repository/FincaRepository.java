package tk.lvicenteaa.finca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.lvicenteaa.finca.entities.Finca;

import java.util.List;

@Repository
public interface FincaRepository extends JpaRepository<Finca, Long> {

    public List<Finca> findByPropietario(String propietario);

    public List<Finca> findByVereda(String vereda);

    public List<Finca> findByAsociacion(String asociacion);

    public List<Finca> findByNombre(String nombre);

}
