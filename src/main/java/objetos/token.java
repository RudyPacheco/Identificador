/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import enums.identificador;

/**
 *
 * @author AndaryuS
 */
public class token {

    private String cadena;
    private identificador identificador;

    public token(){
        
    }
    
    public token(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    
    public identificador getIdentificador() {
        return identificador;
    }

    public void setIdentificador(identificador identificador) {
        this.identificador = identificador;
    }

}
