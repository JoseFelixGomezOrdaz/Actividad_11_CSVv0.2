/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewCSV;
import models.ModelCSV;
import controllers.ControllerCSV;
/**
 *
 * @author Jose Felix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelCSV modelCSV = new ModelCSV();
        ViewCSV viewCSV = new ViewCSV();
        ControllerCSV controllerCSV = new ControllerCSV(modelCSV , viewCSV );
    }
    
}
