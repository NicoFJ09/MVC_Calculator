/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mvccalculator;

import com.mycompany.mvccalculator.Model.model;
import com.mycompany.mvccalculator.View.Pantalla;
import com.mycompany.mvccalculator.View.Data;
import com.mycompany.mvccalculator.Controler.controler;

public class MVCcalculator {

    public static void main(String[] args) {
        Pantalla _view = new Pantalla();
        model _model = new model ();
        Data _data = new Data();
        controler control = new controler(_model, _view, _data);
        control.showView();
    }
}
