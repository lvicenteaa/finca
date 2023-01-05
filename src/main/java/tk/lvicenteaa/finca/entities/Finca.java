package tk.lvicenteaa.finca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "finca")
public class Finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propietario;
    private String nombre;
    private Double area;
    private Double areaFinca;
    private String telefono;
    private String asociacion;
    private String vereda;

    public Finca() {
    }

    public Finca(Long id) {
        this.id = id;
    }

    public Finca(Long id, String propietario, String nombre, Double area, Double areaFinca, String telefono, String asociacion, String vereda) {
        this.id = id;
        this.propietario = propietario;
        this.nombre = nombre;
        this.area = area;
        this.areaFinca = areaFinca;
        this.telefono = telefono;
        this.asociacion = asociacion;
        this.vereda = vereda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getAreaFinca() {
        return areaFinca;
    }

    public void setAreaFinca(Double areaFinca) {
        this.areaFinca = areaFinca;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getVereda() {
        return vereda;
    }

    public void setVereda(String vereda) {
        this.vereda = vereda;
    }
}
