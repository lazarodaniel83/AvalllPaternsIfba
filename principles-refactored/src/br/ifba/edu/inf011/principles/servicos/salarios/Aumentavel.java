package br.ifba.edu.inf011.principles.servicos.salarios;

import java.math.BigDecimal;
import br.ifba.edu.inf011.principles.model.Trabalhador;

public interface Aumentavel extends Trabalhador {
    public void aumentar(BigDecimal percentual);

    public BigDecimal getSalarioBruto();

    public BigDecimal getSalarioLiquido();
}
