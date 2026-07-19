package br.ifba.edu.inf011.principles.servicos.salarios;

import java.math.BigDecimal;

public interface RegraAumentoSalarial {
    public Boolean podeAumentar(Aumentavel aumentavel);

    public BigDecimal pctAumento(Aumentavel aumentavel, BigDecimal percentualProposto);
}
