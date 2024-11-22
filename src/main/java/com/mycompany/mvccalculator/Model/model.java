/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mvccalculator.Model;

import java.util.ArrayList;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class model {
    private double numero1;
    private double numero2;
    private boolean second;
    private double resultado;
    private String num_str1;
    private String num_str2;
    private String res_str;
    private ArrayList<Double> memory = new ArrayList<Double>();
    
    
    public double multiplicar(){
        this.resultado = this.numero1 * this.numero2;
        return this.resultado;
    }
    
    public double sumar(){
        this.resultado = this.numero1 + this.numero2;
        return this.resultado;
    }
    
    public double restar(){
        this.resultado = this.numero1 - this.numero2;
        return this.resultado;
    }
    
    public double dividir(){
    if(numero2 != 0){
        this.resultado = this.numero1/this.numero2;
        return this.resultado;
    }
    return this.resultado; //To do: error msg
    }
    
    public String binario(){
        int res = (int)this.numero1;
        this.res_str = Integer.toBinaryString(res);
        return this.res_str;
    }
    
    public static boolean esPrimo(int n) {
       
        if (n <= 1) {
            return false; 
        }
        if (n <= 3) {
            return true; 
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false; 
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public String average(){
        int size = 1;
        double sum = 0.0;

        if (memory.size()>=10){
            size = 10;

        } else {
            size = memory.size();
        }

        for(int i = 0; i<size; i++){
            sum += memory.get(i);
        }
        return (String.valueOf(sum/size));
    }
    
    public double evaluateExpression(String expression) {
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
    
    public boolean primo(){
        int res = (int)this.numero1;
        return esPrimo(res);
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getRes_str() {
        return res_str;
    }

    public void setRes_str(String res_str) {
        this.res_str = res_str;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public String getNum_str1() {
        return num_str1;
    }

    public void setNum_str1(String num_str1) {
        this.num_str1 = num_str1;
    }

    public String getNum_str2() {
        return num_str2;
    }

    public void setNum_str2(String num_str2) {
        this.num_str2 = num_str2;
    }

    public ArrayList<Double> getMemory() {
        return memory;
    }

    public void setMemory(ArrayList<Double> memory) {
        this.memory = memory;
    }
    
    
}
