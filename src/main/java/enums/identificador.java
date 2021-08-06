/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author AndaryuS
 */
public enum identificador {
    IDENTIFICADOR("ID : "),
    ENTERO("ENTERO : "),
    DECIMAL("DECIMAL : "),
    SIMBOLO("SIMBOLO : "),
    ERROR("ERROR : ");
        
    private String nombre;
    
    private identificador(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    

}
