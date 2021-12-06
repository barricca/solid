package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajustado = aumento.divide(salarioAtual, RoundingMode.HALF_UP);

        if (percentualReajustado.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário");
        }
    }

}
