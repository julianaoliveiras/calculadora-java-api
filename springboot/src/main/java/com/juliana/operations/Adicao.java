package com.juliana.operations;

import com.juliana.calculator.Simbolo;

@Simbolo("+")
public class Adicao implements Operacao{

    @Override
    public double calculo(double valor1, double valor2) {
        return valor1 + valor2;
    }
    
}