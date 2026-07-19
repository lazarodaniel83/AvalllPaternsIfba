package br.ifba.edu.inf011.principles.model;

import java.math.BigDecimal;

import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.dominio.Estado;
import br.ifba.edu.inf011.principles.dominio.Nome;
import br.ifba.edu.inf011.principles.dominio.Salario;
import br.ifba.edu.inf011.principles.servicos.salarios.Aumentavel;

public class Estagiario implements Aumentavel, Trabalhador {

    private TrabalhadorBase base;
    private Salario salario;

    public Estagiario(String matricula, Nome nome, String rua, String bairro, CEP cep, Estado estado,
            BigDecimal horaSalarial) {
        this.base = new TrabalhadorBase(matricula, nome, rua, bairro, cep, estado);
        this.salario = new Salario(horaSalarial);
    }

    @Override
    public String getMatricula() {
        return this.base.getMatricula();
    }

    @Override
    public String getNome() {
        return this.base.getNome();
    }

    public String getNomeAbreviado() {
        return this.base.getNomeAbreviado();
    }

    @Override
    public BigDecimal getSalarioBruto() {
        return this.salario.getSalarioBruto(this.base.getCartaoHoras());
    }

    @Override
    public int getHorasTrabalhadas() {
        return this.base.getHorasTrabalhadas();
    }

    @Override
    public BigDecimal getSalarioLiquido() {
        return this.salario.getSalarioLiquido(this.base.getCartaoHoras());
    }

    @Override
    public void aumentar(BigDecimal percentual) {
        this.salario.aumentar(percentual);
    }

    @Override
    public String toString() {
        return this.base.toString() +
               "Salario: " + this.salario.getSalarioBruto(this.base.getCartaoHoras()) + "\n";
    }

    @Override
    public void registrarHoras(int horas) {
        this.base.registrarHoras(horas);
    }
}
