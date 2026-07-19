package br.ifba.edu.inf011.principles.dominio;

import java.math.BigDecimal;

public class Salario {

    private BigDecimal horaSalarial;
    private Integer horasTrabalhadas;

    public Salario(BigDecimal horaSalarial) {
        this.horaSalarial = horaSalarial;
        this.horasTrabalhadas = 0;
    }

    public void reset() {
        this.horasTrabalhadas = 0;
    }

    public BigDecimal getHoraSalarial() {
        return this.horaSalarial;
    }

    public Integer getHorasTrabalhadas() {
        return this.horasTrabalhadas;
    }

    public BigDecimal getSalarioBruto(CartaoHoras cartaoHoras) {
        return horaSalarial.multiply(BigDecimal.valueOf(cartaoHoras.getHorasTrabalhadas()));
    }

    public void aumentar(BigDecimal percentual) {
        this.horaSalarial = this.horaSalarial.multiply(BigDecimal.ONE.add(percentual));
    }

    // Retorna o Salário Líquido com base nas regras de tributação
    public BigDecimal getSalarioLiquido(CartaoHoras cartaoHoras) {
        BigDecimal imposto = BigDecimal.ZERO;
        BigDecimal bruto = this.getSalarioBruto(cartaoHoras);
        // Regra: 2,5% do que exceder 500 até 1000
        if (bruto.compareTo(BigDecimal.valueOf(500)) > 0) {
            BigDecimal baseFaixa2 = bruto.subtract(BigDecimal.valueOf(500));
            imposto = imposto.add(baseFaixa2.multiply(BigDecimal.valueOf(0.025)));
        }
        // Regra: 5% do que exceder 1000
        if (bruto.compareTo(BigDecimal.valueOf(1000)) > 0) {
            BigDecimal baseFaixa3 = bruto.subtract(BigDecimal.valueOf(1000));
            imposto = imposto.add(baseFaixa3.multiply(BigDecimal.valueOf(0.05)));
        }
        return bruto.subtract(imposto);
    }

}
