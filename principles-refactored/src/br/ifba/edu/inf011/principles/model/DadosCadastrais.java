package br.ifba.edu.inf011.principles.model;

import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.dominio.Estado;

public class DadosCadastrais {

    private String rua;
    private String bairro;
    private CEP cep;
    private Estado estado;

    public DadosCadastrais(String rua, String bairro, CEP cep, Estado estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dados Cadastrais\n" +
                "Rua: " + this.rua + "\n" +
                "Bairro: " + this.bairro + "\n" +
                "CEP: " + this.cep.formatado() + "\n" +
                "Estado: " + this.estado.getSigla();
    }

}
