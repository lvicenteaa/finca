package tk.lvicenteaa.finca.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.lvicenteaa.finca.entities.Finca;
import tk.lvicenteaa.finca.repository.FincaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FincaService {

    @Autowired
    private FincaRepository fincaRepository;

    private final Logger log = LoggerFactory.getLogger(FincaService.class);

    public ResponseEntity<List<Finca>> listar(){
        log.info("REST Request listando todas las fincas");
        List<Finca> fincas = this.fincaRepository.findAll();
        if(fincas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fincas);
    }

    public ResponseEntity<Finca> buscar(Long id){
        Optional<Finca> fincaOpt = this.fincaRepository.findById(id);
        if(fincaOpt.isPresent()){
            log.info("REST Request buscando una fincas");
            return ResponseEntity.ok(fincaOpt.get());
        }
        else{
            log.warn("REST Request Finca no encontrada");
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Finca> crear(Finca finca){
        if(finca.getId() != null){
            log.warn("Trying to create a finca with id");
            return ResponseEntity.badRequest().build();
        }
        Finca result = this.fincaRepository.save(finca);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Finca> actualizar(Finca finca){
        if(finca.getId() == null){
            log.warn("Trying to update a non existent finca");
            return ResponseEntity.badRequest().build();
        }
        if(!this.fincaRepository.existsById(finca.getId())){
            log.warn("Trying to update a non existent finca");
            return ResponseEntity.notFound().build();
        }

        Finca result = this.fincaRepository.save(finca);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<Finca> borrar(Long id){
        if(!this.fincaRepository.existsById(id)){
            log.warn("Trying to delete a non existent finca");
            return ResponseEntity.notFound().build();
        }
        this.fincaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Finca> borrarTodas(){
        log.info("REST Request for delete all fincas");
        this.fincaRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Finca>> listarPorPropietario(String propietario){
        log.info("REST Request listando todas las fincas por propietario");
        List<Finca> fincas = this.fincaRepository.findByPropietario(propietario);
        if(fincas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fincas);
    }

    public ResponseEntity<List<Finca>> listarPorVereda(String vereda){
        log.info("REST Request listando todas las fincas por vereda");
        List<Finca> fincas = this.fincaRepository.findByVereda(vereda);
        if(fincas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fincas);
    }

    public ResponseEntity<List<Finca>> listarPorAsociacion(String asociacion){
        log.info("REST Request listando todas las fincas por asociacion");
        List<Finca> fincas = this.fincaRepository.findByAsociacion(asociacion);
        if(fincas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fincas);
    }

    public ResponseEntity<List<Finca>> listarPorNombre(String nombre){
        log.info("REST Request listando todas las fincas por nombre");
        List<Finca> fincas = this.fincaRepository.findByNombre(nombre);
        if(fincas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fincas);
    }

}
