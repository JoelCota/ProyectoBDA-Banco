/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Joel Lopez
 */
public class ConfiguracionPaginado {
    private int   numeroPagina;
    private int elementosPagina;

    public ConfiguracionPaginado(int numeroPagina, int elementosPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPagina = elementosPagina;
    }

    public ConfiguracionPaginado() {
        this.numeroPagina=1;
        this.elementosPagina=5;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementosPagina() {
        return elementosPagina;
    }

    public void setElementosPagina(int elementosPagina) {
        this.elementosPagina = elementosPagina;
    }
    
    public int getOffSet(){
        return this.numeroPagina * this.elementosPagina;
    }
        
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    
    public void atrasPagina(){
        if (this.numeroPagina>0) {
            this.numeroPagina--;
        }
    }
}
