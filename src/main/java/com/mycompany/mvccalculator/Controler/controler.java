package com.mycompany.mvccalculator.Controler;

import com.mycompany.mvccalculator.Model.model;
import com.mycompany.mvccalculator.Data.BitacoraManager;
import com.mycompany.mvccalculator.View.Pantalla;
import com.mycompany.mvccalculator.View.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class controler implements ActionListener {
    
    private model _model;
    private Pantalla _view;
    private Data _data;
    private BitacoraManager _bitacoraManager;

    private boolean result;
    
    public controler(model _model, Pantalla _view, Data _data) {
        this._model = _model;
        this._view = _view;
        this._data = _data;
        this.result = false;
        this._bitacoraManager = new BitacoraManager(_data, "src/main/java/com/mycompany/mvccalculator/data.txt");
        _init_();
    }
    
    private void _init_() {
        
        _view.bttn_primo.addActionListener(this);
        _view.bttn_bin.addActionListener(this);
        
        _view.bttn_0.addActionListener(this);
        _view.bttn_1.addActionListener(this);
        _view.bttn_2.addActionListener(this);
        _view.bttn_3.addActionListener(this);
        _view.bttn_4.addActionListener(this);
        _view.bttn_5.addActionListener(this);
        _view.bttn_6.addActionListener(this);
        _view.bttn_7.addActionListener(this);
        _view.bttn_8.addActionListener(this);
        _view.bttn_9.addActionListener(this);
        
        _view.bttn_addition.addActionListener(this);
        _view.bttn_substraction.addActionListener(this);
        _view.bttn_divide.addActionListener(this);
        _view.bttn_multiply.addActionListener(this);
        
        _view.bttn_float.addActionListener(this);
        _view.bttn_avg.addActionListener(this);
        _view.bttn_c.addActionListener(this);
        _view.bttn_mplus.addActionListener(this);
        _view.bttn_equals.addActionListener(this);
        _view.jButton1.addActionListener(this);

        
        _view.getjTextField1().addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            
            if(c == 'C'){
                _view.getjTextField1().setText("");
            }
            
            else if(c == '='){
                try{
                    String expression = _view.getjTextField1().getText();
                    _view.getjTextField1().setText(String.valueOf(_model.evaluateExpression(expression)));
                    _bitacoraManager.escribirEnBitacora(expression + " = " + _view.getjTextField1().getText());
                    _bitacoraManager.actualizarBitacora();
                }
                catch (Exception ex){
                    _view.getjTextField1().setText("");
                }
            }

            if (!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != '/' && c != '.') {
                e.consume();
            }
            
            
            
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    });

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (result && !e.getSource().equals(_view.bttn_c)) {
            return;
        }

        
        if (e.getSource().equals(_view.bttn_c)) {
            _view.getjTextField1().setText("");
            result = false;
            return;
        }
        
        if (e.getSource().equals(_view.bttn_0)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "0");
        } 
        
        else if (e.getSource().equals(_view.bttn_1)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "1");
        } 
        
        else if (e.getSource().equals(_view.bttn_2)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "2");
        } 
        
        else if (e.getSource().equals(_view.bttn_3)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "3");
        } 
        
        else if (e.getSource().equals(_view.bttn_4)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "4");
        } 
        
        else if (e.getSource().equals(_view.bttn_5)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "5");
        } 
        
        else if (e.getSource().equals(_view.bttn_6)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "6");
        } 
        
        else if (e.getSource().equals(_view.bttn_7)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "7");
        } 
        
        else if (e.getSource().equals(_view.bttn_8)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "8");
        } 
        
        else if (e.getSource().equals(_view.bttn_9)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + "9");
        } 
        
        else if (e.getSource().equals(_view.bttn_float)) {
            String textoActual = _view.getjTextField1().getText();
            if (!textoActual.contains(".")) {
                _view.getjTextField1().setText(textoActual + ".");
            }
        } 
        
        else if (e.getSource().equals(_view.bttn_addition)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + " + ");
        } 
        
        else if (e.getSource().equals(_view.bttn_substraction)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + " - ");
        } 
        
        else if (e.getSource().equals(_view.bttn_multiply)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + " * ");
        } 
        
        else if (e.getSource().equals(_view.bttn_divide)) {
            _view.getjTextField1().setText(_view.getjTextField1().getText() + " / ");
        } 
        
        else if (e.getSource().equals(_view.bttn_primo)) {
            try{
                double num = Double.parseDouble(_view.getjTextField1().getText());
                _model.setNumero1(num);
                _view.getjTextField1().setText(_model.primo() ? "TRUE" : "FALSE");
                _bitacoraManager.escribirEnBitacora( "¿Es primo? "+ num + " " +_view.getjTextField1().getText());
                _bitacoraManager.actualizarBitacora();
                result = true;}
            catch(Exception ex){
                _view.getjTextField1().setText("");
            }
        } 
        
        else if (e.getSource().equals(_view.bttn_bin)) {
            try{
                int num = (int) Double.parseDouble(_view.getjTextField1().getText());
                _model.setNumero1(Double.parseDouble(_view.getjTextField1().getText()));
                _view.getjTextField1().setText(_model.binario());
                _bitacoraManager.escribirEnBitacora(  num +" en binario es: "+ _view.getjTextField1().getText());
                _bitacoraManager.actualizarBitacora();
                result = true;}
            catch(Exception ex){
                _view.getjTextField1().setText("");
            }
        }

        else if (e.getSource().equals(_view.bttn_mplus)) {
            try {
                double numero = Double.parseDouble(_view.getjTextField1().getText());

                // Check if memory is already at 10 elements
                if (_model.getMemory().size() == 10) {
                    // Remove the last element
                    _model.getMemory().removeLast();
                }

                // Add the new number at the first position
                _model.getMemory().addFirst(numero);

                // Log the operation
                _bitacoraManager.escribirEnBitacora("M+ " + numero + " > " + _model.getMemory().toString());
                _bitacoraManager.actualizarBitacora();
            } catch (NumberFormatException ex) {
                // Handle invalid number input (you might want to add specific error handling)
            }
        }


        else if (e.getSource().equals(_view.bttn_avg)) {
            _view.getjTextField1().setText(_model.average());
            _bitacoraManager.escribirEnBitacora(  "AVG "+ _model.getMemory().toString() +" = "+ _view.getjTextField1().getText());
            _bitacoraManager.actualizarBitacora();
        } 
        
        else if (e.getSource().equals(_view.bttn_equals)) {
            String expression = _view.getjTextField1().getText();
            _view.getjTextField1().setText(String.valueOf(_model.evaluateExpression(expression)));
            _bitacoraManager.escribirEnBitacora(expression + " = " + _view.getjTextField1().getText());
            _bitacoraManager.actualizarBitacora();
        }

        else if (e.getSource().equals(_view.jButton1)) {
           _data.setVisible(true);
        }
        
        
    }
    
    public void showView() {
        _view.setVisible(true);
    }
    
}
