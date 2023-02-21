/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aroco
 */
public class Validadores {

    public Validadores() {
    }
    
    
    /**
     * Método que valida una contraseña.
     * @param con contraseña a validar.
     * @return Verdadero o falso si se ha validado el contraseña.
     */
    public boolean validaContrasena(String con){
        String patron = "^(?i)(?=.*[a-z])(?=.*[0-9])[a-z0-9#.!@$*&_]{8,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(con);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    
    /**
     * Método que valida una contraseña.
     * @param con float a validar.
     * @return Verdadero o falso si se ha validado el float.
     */
    public boolean validaFloat(String con){
        String patron = "[+-]?([0-9]*[.])?[0-9]+";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(con);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    
    
     public boolean validaNombre(String s) {
        String patron = "^(?=.{2,30}$)[A-Za-z]+(\\s[A-Za-z]+)?$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }

    public boolean validaApellido(String s) {
        String patron = "^[a-zA-ZñÑ]{3,20}$";

        Pattern p = Pattern.compile(patron);

        Matcher matcher = p.matcher(s);

        return matcher.matches();
    }
}

