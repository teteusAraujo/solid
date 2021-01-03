package solid.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import solid.rh.ValidacaoException;

public class ReajusteService {
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal("0.4"))>0) {
			throw new ValidacaoException("Reajuste não pode ser superior a 40% do valor do salario");
		}
		BigDecimal salarioAjustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioAjustado);
	}
}
