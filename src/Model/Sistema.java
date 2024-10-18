/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author facun
 */
public class Sistema {

    
    private List<Servicio> listServicio = new ArrayList<>();

    public Sistema(){
        this.listServicio = new ArrayList<>();
    }

    public List<Servicio> getListServicio() {
        return listServicio;
    }
    
    

    public Servicio traerServicio(String codServicio) {
        for (Servicio serv : listServicio) {
            if (serv.getCodServicio().equals(codServicio)) {
                return serv;
            }
        }
        return null;
    }

    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio serv : listServicio) {
            if (serv.isEnPromocion() == enPromocion) {
                resultado.add(serv);
            }
        }
        return resultado;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio serv : listServicio) {
            if (serv.isEnPromocion() == enPromocion && serv.calcularPrecioFinal(dia) != 0) {
                resultado.add(serv);
            }
        }
        return resultado;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio ya existe");
        }
        Gastronomia gast = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
        return listServicio.add(gast);
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precio) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio ya existe");
        }
        Hospedaje hosp = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precio);
        return listServicio.add(hosp);
    }

}
