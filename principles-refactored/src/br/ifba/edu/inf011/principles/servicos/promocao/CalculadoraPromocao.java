package br.ifba.edu.inf011.principles.servicos.promocao;

import java.util.ArrayList;
import java.util.List;
import br.ifba.edu.inf011.principles.exception.RHException;

public class CalculadoraPromocao {

    public List<RegraPromocao> regras;

    public CalculadoraPromocao() {
        this.regras = new ArrayList<RegraPromocao>();
    }

    public void addRegra(RegraPromocao regra) {
        this.regras.add(regra);
    }

    public void promover(Promovivel promovivel) throws RHException {
        if (!podePromover(promovivel))
            throw new RHException("Não é possível promover o empregado");
        promovivel.promover();
    }

    public Boolean podePromover(Promovivel promovivel) {
        for (RegraPromocao regra : regras)
            if (!regra.validar(promovivel))
                return Boolean.FALSE;
        return Boolean.TRUE;
    }

}
