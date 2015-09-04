/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Cotipoitem;
import entidades.Empresa;
import entidades.Pedido;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class CotizacionDTO {
    private Integer idcotizacion;
   
    private String estado;
   
    private Date fechaEnvio;
   
    private Integer duracion;
   
    private List<Cotipoitem> cotipoitemList;
    
    private List<Pedido> pedidoList;
    
    private Empresa idempresa;

    public CotizacionDTO() {
    }
    
    

    public CotizacionDTO(Integer idcotizacion, String estado, Date fechaEnvio, Integer duracion, List<Cotipoitem> cotipoitemList, List<Pedido> pedidoList, Empresa idempresa) {
        this.idcotizacion = idcotizacion;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.duracion = duracion;
        this.cotipoitemList = cotipoitemList;
        this.pedidoList = pedidoList;
        this.idempresa = idempresa;
    }

    public Integer getIdcotizacion() {
        return idcotizacion;
    }

    public void setIdcotizacion(Integer idcotizacion) {
        this.idcotizacion = idcotizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<Cotipoitem> getCotipoitemList() {
        return cotipoitemList;
    }

    public void setCotipoitemList(List<Cotipoitem> cotipoitemList) {
        this.cotipoitemList = cotipoitemList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }
    
}
