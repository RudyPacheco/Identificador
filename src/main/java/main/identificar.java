/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import enums.identificador;
import java.util.ArrayList;
import javax.swing.JTextArea;
import objetos.token;

/**
 *
 * @author AndaryuS
 */
public class identificar {

    String cadena;
    ArrayList<token> tokensSucios = new ArrayList();
    ArrayList<token> tokensVerificados = new ArrayList();
    JTextArea areaTexto;
    public identificar() {

    }

    public void IdentificarCadena(String cadena, JTextArea areaInfo) {
        this.cadena = cadena;
        this.areaTexto=areaInfo;
        cadena= cadena.replaceAll("\n", " ");
        SepararCadena(cadena);
        IdentificarCadenaSeparada();
        imprimirDatos();

    }

    public void SepararCadena(String cadena) {

        String aux = "";
        for (int i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) != ' ') {
                aux += cadena.charAt(i);
                // System.out.println(aux);
            }
            if (cadena.charAt(i) == ' ') {
                // System.out.println(aux);
                token tokenaux = new token();
                tokenaux.setCadena(aux);
                tokensSucios.add(tokenaux);
                aux = "";
            }
            if (i == (cadena.length() - 1)) {
                token tokenaux = new token();
                tokenaux.setCadena(aux);
                tokensSucios.add(tokenaux);
                aux = "";
            }

//            if (!Character.isSpaceChar(cadena.charAt(i))) {
//                aux +=cadena.charAt(i);
//                
//            }
//            if (Character.isSpaceChar(cadena.charAt(i))) {
//                System.out.println(aux);
//                token tokenaux= new token();
//                tokenaux.setCadena(aux);
//                tokens.add(tokenaux);
//                aux="";
//            }
        }
    }

    public void IdentificarCadenaSeparada() {
        boolean IniciaLetra = false;
        boolean punto = false;
        boolean iniciaNumero = false;

        for (int i = 0; i < tokensSucios.size(); i++) {
            token tokenTemp = tokensSucios.get(i);
            if (Character.isLetter(tokenTemp.getCadena().charAt(0))) {
                validarID(tokenTemp);
            }
            if (Character.isDigit(tokenTemp.getCadena().charAt(0))) {
                validarNumero(tokenTemp);
            }
            if (!Character.isLetterOrDigit(tokenTemp.getCadena().charAt(0))) {
                validarSimbolo(tokenTemp);
            }

        }

    }

    public void validarID(token tokenRecibido) {
        boolean error = false;
        for (int i = 0; i < tokenRecibido.getCadena().length(); i++) {
            if (!Character.isLetter(tokenRecibido.getCadena().charAt(i)) && !Character.isDigit(tokenRecibido.getCadena().charAt(i))) {
                error = true;
            }
        }
        if (error == false) {
            tokenRecibido.setIdentificador(identificador.IDENTIFICADOR);

        } else {
            tokenRecibido.setIdentificador(identificador.ERROR);

        }
        tokensVerificados.add(tokenRecibido);
    }

    public void validarNumero(token tokenRecibido) {
        boolean punto = false;
        boolean error = false;
        int contadorPuntos = 0;
        for (int i = 0; i < tokenRecibido.getCadena().length(); i++) {
            if (!Character.isDigit(tokenRecibido.getCadena().charAt(i))) {
                if (tokenRecibido.getCadena().charAt(i) == '.') {
                    contadorPuntos++;
                    if ((i + 1) < tokenRecibido.getCadena().length()) {
                        if (!Character.isDigit(tokenRecibido.getCadena().charAt(i + 1))) {
                            error = true;
                        }
                    } else {
                        error = true;
                    }
                } else {
                    error = true;
                }
            }

        }
        if (error == false && contadorPuntos == 1) {
            tokenRecibido.setIdentificador(identificador.DECIMAL);
        }
        if (error == false && contadorPuntos == 0) {
            tokenRecibido.setIdentificador(identificador.ENTERO);
        }
        if (error == true || contadorPuntos > 1) {
            tokenRecibido.setIdentificador(identificador.ERROR);
        }
        tokensVerificados.add(tokenRecibido);

    }

    public void validarSimbolo(token tokenRecibido) {
        boolean error = false;
        for (int i = 0; i < tokenRecibido.getCadena().length(); i++) {
            if (tokenRecibido.getCadena().charAt(i) != '[') {
                if (tokenRecibido.getCadena().charAt(i) != ']') {
                    if (tokenRecibido.getCadena().charAt(i) != '{') {
                        if (tokenRecibido.getCadena().charAt(i) != '}') {
                            if (tokenRecibido.getCadena().charAt(i) != ';') {
                                if (tokenRecibido.getCadena().charAt(i) != ',') {
                                    error=true;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if (error==false) {
            tokenRecibido.setIdentificador(identificador.SIMBOLO);
        }else{
            tokenRecibido.setIdentificador(identificador.ERROR);
        }

        tokensVerificados.add(tokenRecibido);
    }

    public void imprimirDatos() {
      //  System.out.println(tokensSucios.size());
        //System.out.println("-----TOKENS SUCIOS-----");
        for (int i = 0; i < tokensSucios.size(); i++) {
            token tokenaux = tokensSucios.get(i);
           // System.out.println(tokensSucios.get(i).getCadena());
        }
        //System.out.println("-----TOKENS LIMPIOS-----");
        for (int i = 0; i < tokensVerificados.size(); i++) {
            
           // System.out.println(tokensVerificados.get(i).getIdentificador().getNombre() + tokensVerificados.get(i).getCadena());
            areaTexto.append("   "+tokensVerificados.get(i).getIdentificador().getNombre() + tokensVerificados.get(i).getCadena()+"\n");
        }

    }

}
