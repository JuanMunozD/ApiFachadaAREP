/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.persistence.entity;

/**
 *
 * @author Juan Sebastian
 */
public class ResponseCalculator {
    
    private Double respuesta;
    
    public ResponseCalculator() {
    }

    public ResponseCalculator(Double respuesta) {
        this.respuesta = respuesta;
    }
    
    public Double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Double respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "ResponseCalculator{" + "respuesta=" + respuesta + '}';
    }
    
}
