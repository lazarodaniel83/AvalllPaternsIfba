package br.ifba.edu.inf011.principles.model;

import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.dominio.CartaoHoras;
import br.ifba.edu.inf011.principles.dominio.Estado;
import br.ifba.edu.inf011.principles.dominio.Nome;

public class TrabalhadorBase implements Trabalhador {

    private String matricula;
    private Nome nome;
    private DadosCadastrais dadosCadastrais;
    private CartaoHoras cartaoHoras;

    public TrabalhadorBase(String matricula, Nome nome, String rua, String bairro, CEP cep, Estado estado) {
        this.matricula = matricula;
        this.nome = nome;
        this.dadosCadastrais = new DadosCadastrais(rua, bairro, cep, estado);
        this.cartaoHoras = new CartaoHoras();
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public String getNome() {
        return this.nome.nome();
    }

    public String getNomeAbreviado() {
        return this.nome.getNomeAbreviado();
    }

    @Override
    public void registrarHoras(int horas) {
        this.cartaoHoras.registrarHoras(horas);
    }

    @Override
    public int getHorasTrabalhadas() {
        return this.cartaoHoras.getHorasTrabalhadas();
    }

    public CartaoHoras getCartaoHoras() {
        return this.cartaoHoras;
    }

    public DadosCadastrais getDadosCadastrais() {
        return this.dadosCadastrais;
    }

    public Nome getNomeObject() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Matricula: " + this.matricula + "\n" +
                "Nome: " + this.nome.nome() + "\n" +
                "Mail: " + this.nome.getMail() + "\n" +
                this.dadosCadastrais.toString() + "\n";
    }
}
