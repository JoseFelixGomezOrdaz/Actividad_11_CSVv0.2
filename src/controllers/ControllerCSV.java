/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewCSV;
import models.ModelCSV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Jose Felix
 */
public class ControllerCSV {
    ModelCSV modelCSV; 
    ViewCSV viewCSV;
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCSV.jb_limpiar) {
                jb_limpiar_action_performed();
            }
            else if (e.getSource() == viewCSV.jb_guardar) { 
                jm_guardar_action_performed();
            }
            else if (e.getSource() == viewCSV.jb_primer) { 
                jb_primer_action_performed();
            }
            else if (e.getSource() == viewCSV.jb_siguiente) {
                jb_siguiente_action_performed();
            } 
            else if (e.getSource() == viewCSV.jb_anterior) {
                jb_anterior_action_performed();
            } 
            else if (e.getSource() == viewCSV.jb_ultimo) { 
                jb_ultimo_action_performed();
            }
        }
    };
    
    
    public ControllerCSV(ModelCSV modelCSV, ViewCSV viewCSV) {
        this.modelCSV = modelCSV;
        this.viewCSV = viewCSV;
        this.viewCSV.jb_limpiar.addActionListener(actionlistener);
        this.viewCSV.jb_guardar.addActionListener(actionlistener);
        this.viewCSV.jb_primer.addActionListener(actionlistener);
        this.viewCSV.jb_siguiente.addActionListener(actionlistener);
        this.viewCSV.jb_anterior.addActionListener(actionlistener);
        this.viewCSV.jb_ultimo.addActionListener(actionlistener);
        initComponents();
    }
    
    
    public void jm_guardar_action_performed() {
        modelCSV.setTexto(viewCSV.jtf_nombre.getText() + "," + viewCSV.jtf_email.getText()); 
        modelCSV.writeFile(modelCSV.getPath(), modelCSV.getTexto());
        modelCSV.readFile();
        modelCSV.primeroRegistro();
    }
    public void jb_limpiar_action_performed() {
        viewCSV.jtf_nombre.setText("");
        viewCSV.jtf_email.setText("");
    }
    public void jb_primer_action_performed() {
        modelCSV.primeroRegistro();
        viewCSV.jtf_nombre.setText(modelCSV.getNombre());
        viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
    public void jb_siguiente_action_performed() {
        modelCSV.siguienteRegistro();
        viewCSV.jtf_nombre.setText(modelCSV.getNombre());
        viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
    public void jb_anterior_action_performed() {
        modelCSV.anteriorRegistro();
        viewCSV.jtf_nombre.setText(modelCSV.getNombre());
        viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
    public void jb_ultimo_action_performed() {
        modelCSV.ultimoRegistro();
        viewCSV.jtf_nombre.setText(modelCSV.getNombre());
        viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
    public void initComponents() {
        viewCSV.setVisible(true);
        modelCSV.readFile();
        modelCSV.primeroRegistro();
        viewCSV.jtf_nombre.setText(modelCSV.getNombre());
        viewCSV.jtf_email.setText(modelCSV.getEmail());
    }
}
