package br.ifba.edu.inf011.principles.servicos.salarios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.inf011.principles.exception.RHException;

public class CalculadoraSalario {

    public List<RegraAumentoSalarial> regras;

    public CalculadoraSalario() {
        this.regras = new ArrayList<RegraAumentoSalarial>();
    }

    public void addRegra(RegraAumentoSalarial regra) {
        this.regras.add(regra);
    }

    public void aumentar(Aumentavel aumentavel, BigDecimal pctAumentoProposto) throws RHException {
        BigDecimal pctAumento = pctAumentoProposto;
        for (RegraAumentoSalarial regra : regras) {
            if (!regra.podeAumentar(aumentavel))
                throw new RHException("Não é possível aumentar o salário do empregado");
            pctAumento = pctAumento.min(regra.pctAumento(aumentavel, pctAumento));
        }
        aumentavel.aumentar(pctAumento);
    }

}
