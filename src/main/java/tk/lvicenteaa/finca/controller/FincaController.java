package tk.lvicenteaa.finca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.lvicenteaa.finca.entities.Finca;
import tk.lvicenteaa.finca.services.FincaService;

import java.util.List;

@RestController
@RequestMapping("/api/v2/finca")
public class FincaController {

    @Autowired
    private FincaService fincaService;

    @GetMapping
    public ResponseEntity<List<Finca>> listarTodas(){
        return this.fincaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finca> buscar(@PathVariable Long id){
        return this.fincaService.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Finca> crear(@RequestBody Finca finca){
        return this.fincaService.crear(finca);
    }

    @PutMapping
    public ResponseEntity<Finca> actualizar(@RequestBody Finca finca){
        return this.fincaService.actualizar(finca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Finca> borrar(@PathVariable Long id){
        return this.fincaService.borrar(id);
    }

    @DeleteMapping
    public ResponseEntity<Finca> borrarTodas(){
        return this.fincaService.borrarTodas();
    }

    @GetMapping("/propietario/{propietario}")
    public ResponseEntity<List<Finca>> listarTodasporPropietario(@PathVariable String propietario){
        return this.fincaService.listarPorPropietario(propietario);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Finca>> listarTodasporNombre(@PathVariable String nombre){
        return this.fincaService.listarPorNombre(nombre);
    }

    @GetMapping("/vereda/{vereda}")
    public ResponseEntity<List<Finca>> listarTodasporVereda(@PathVariable String vereda){
        return this.fincaService.listarPorVereda(vereda);
    }

    @GetMapping("/asociacion/{asociacion}")
    public ResponseEntity<List<Finca>> listarTodasporAsociacion(@PathVariable String asociacion){
        return this.fincaService.listarPorAsociacion(asociacion);
    }
}
