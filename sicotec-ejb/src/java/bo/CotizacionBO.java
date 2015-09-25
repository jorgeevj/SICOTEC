/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entidades.Cotizacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Jorge
 * 15.09.2015
 */
@Stateless
@LocalBean
public class CotizacionBO {

    public List getAllCotizaciones() {
        Cotizacion c=new Cotizacion();
        c.setIdcotizacion(1);
        List<Cotizacion> lista=new ArrayList<>();
                lista.add(c);
        return lista;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
