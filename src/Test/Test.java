/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Model.Sistema;
import Model.Gastronomia;
import Model.Hospedaje
import Model.Servicio;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author facun
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sistema sist = new Sistema();
        
        //Test 1-1
        try {
            sist.agregarGastronomia("4892", 15.0, true, "Hamburguesa Criolla", 180.0, 4);
        } catch (Exception e){
            System.out.println("1-1:" + e.getMessage());
        }
        
        //Test1-2
        try {
            //sist.agregarGastronomia("489235", 15.0, true, "Hamburguesa Criolla", 180.0, 4);
            Gastronomia gast = new Gastronomia("489235", 15.0, true, "Hamburguesa Criolla", 180.0, 4);
            System.out.println("1-2: Gastronomia creada");
        } catch (Exception e){
            System.out.println("1-2:" + e.getMessage());
        }
        
        //Test 1-3
        try {
            sist.agregarHospedaje("2872", 10.0, true, "Cabania 3 personas", 1500.0);
        } catch (Exception e){
            System.out.println("1-3:" + e.getMessage());
        }
        
        //Test 1-4
        try {
            sist.agregarHospedaje("287282", 10.0, true, "Cabania 3 personas", 1500.0);
            System.out.println("1-4: Hospedaje creado");
        } catch (Exception e){
            System.out.println("1-4:" + e.getMessage());
        }
        
        //Test 2-1
        LocalDate dia = LocalDate.of(2020, 10, 28);
        Servicio serv = sist.traerServicio("489235");
        if(serv != null){
            System.out.println("2-1 Precio Final: " + serv.calcularPrecioFinal(dia));
        }
        
        //Test 2-2
        dia = LocalDate.of(2020, 10, 27);
        serv = sist.traerServicio("287282");
        if(serv != null){
            System.out.println("2-2 Precio Final: " + serv.calcularPrecioFinal(dia));
        }
        
        //Test 3
        try {
            sist.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sist.agregarHospedaje("489259", 15.0, true, "Habitacion Triple", 2200.0);
            sist.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sist.agregarHospedaje("758972", 15.0, false, "Habitacion Simple", 1000.0);
            System.out.println("Servicios agregados");
        } catch(Exception e) {
            System.out.println("3" + e.getMessage());
        }
        
        for(Servicio s: sist.getListServicio()) {
            System.out.println("Servicio" + s);
        }
        
        //Test 4-1
        List<Servicio> serviciosEnPromocion = sist.traerServicio(true);
        System.out.println("4-1: Servicios en promocion");
        for (Servicio servicio : serviciosEnPromocion){
            System.out.println(servicio);
        }
        
        //Test 4-2
        dia = LocalDate.of(2020,10,28);
        List<Servicio> serviciosDiaPromocion = sist.traerServicio(true, dia);
        System.out.println("4-2 Servicios en promocion");
        for (Servicio s: serviciosDiaPromocion){
            System.out.println(s);
        }
        
        
        
    }
    
}
