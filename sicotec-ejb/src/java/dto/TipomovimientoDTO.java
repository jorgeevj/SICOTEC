/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author rikardo308
 */
public class TipomovimientoDTO {
    private Integer idtipoMovimiento;
    private String nombre;

    /**
     * @return the idtipoMovimiento
     */
    public Integer getIdtipoMovimiento() {
        return idtipoMovimiento;
    }

    /**
     * @param idtipoMovimiento the idtipoMovimiento to set
     */
    public void setIdtipoMovimiento(Integer idtipoMovimiento) {
        this.idtipoMovimiento = idtipoMovimiento;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
