package com.juliana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliana.calculator.OperacaoUtil;
import com.juliana.operations.Operacao;

@RestController
@RequestMapping("/operations")
public class Controller {

    private static final String OPERADOR_ADICAO = "+";
    private static final String OPERADOR_DIVISAO = "/";
    private static final String OPERADOR_MULTIPLICACAO = "*";
    private static final String OPERADOR_SUBTRACAO = "-";

    @GetMapping("/adicao/{a}/{b}")
    public Double doAddition(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(OPERADOR_ADICAO, a, b);
    }

    @GetMapping("/divisao/{a}/{b}")
    public Double doDivision(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(OPERADOR_DIVISAO, a, b);
    }

    @GetMapping("/multiplicacao/{a}/{b}")
    public Double doMultiplication(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(OPERADOR_MULTIPLICACAO, a, b);
    }

    @GetMapping("/subtracao/{a}/{b}")
    public Double doSubtraction(@PathVariable("a") Double a, @PathVariable("b") Double b) {
        return getCalculationResultOf(OPERADOR_SUBTRACAO, a, b);
    }

    private Double getCalculationResultOf(String operador, Double a, Double b) {
        Operacao operacao = OperacaoUtil.getOperations().get(operador);
        return operacao.calculo(a, b);
    }
}
