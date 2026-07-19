package br.ifba.edu.inf011.principles.servicos.promocao.regras;

import br.ifba.edu.inf011.principles.servicos.promocao.RegraPromocao;
import br.ifba.edu.inf011.principles.servicos.promocao.Promovivel;

public class RegraBasica implements RegraPromocao {

    @Override
    public Boolean validar(Promovivel promovivel) {
        return Boolean.TRUE;
    }

}
