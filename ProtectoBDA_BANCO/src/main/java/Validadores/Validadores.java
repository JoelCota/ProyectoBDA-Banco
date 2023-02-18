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
}
