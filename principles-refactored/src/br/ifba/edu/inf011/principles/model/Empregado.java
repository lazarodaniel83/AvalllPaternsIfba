package br.ifba.edu.inf011.principles.model;

import java.math.BigDecimal;

import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.dominio.Cargo;
import br.ifba.edu.inf011.principles.dominio.Estado;
import br.ifba.edu.inf011.principles.dominio.Nome;
import br.ifba.edu.inf011.principles.dominio.Salario;
import br.ifba.edu.inf011.principles.servicos.promocao.Promovivel;
import br.ifba.edu.inf011.principles.servicos.salarios.Aumentavel;

public class Empregado implements Promovivel, Aumentavel, Trabalhador {

    private TrabalhadorBase base;
    private Salario salario;
    private Cargo cargo;

    public Empregado(String matricula, Nome nome, String rua, String bairro, CEP cep, Estado estado,
            BigDecimal horaSalarial, Cargo cargo) {
        this.base = new TrabalhadorBase(matricula, nome, rua, bairro, cep, estado);
        this.salario = new Salario(horaSalarial);
        this.cargo = cargo;
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

    public BigDecimal getSalarioBruto() {
        return this.salario.getSalarioBruto(this.base.getCartaoHoras());
    }

    public int getHorasTrabalhadas() {
        return this.base.getHorasTrabalhadas();
    }

    public BigDecimal getSalarioLiquido() {
        return this.salario.getSalarioLiquido(this.base.getCartaoHoras());
    }

    @Override
    public void promover() {
        this.cargo = this.cargo.proximo();
    }

    @Override
    public void aumentar(BigDecimal percentual) {
        this.salario.aumentar(percentual);
    }

    @Override
    public String toString() {
        return this.base.toString() +
                "Salario: " + this.salario.getSalarioBruto(this.base.getCartaoHoras()) + "\n" +
                "Cargo: " + this.cargo + "\n";
    }

    @Override
    public void registrarHoras(int horas) {
        this.base.registrarHoras(horas);
    }

    public static void main(String[] args) {
        Empregado empregado = new Empregado("123456",
                new Nome("Joao Silva"),
                "Rua 1",
                "Bairro 1",
                new CEP("12345678"),
                Estado.BA,
                BigDecimal.valueOf(10000),
                Cargo.JUNIOR);
        System.out.println(empregado);
        System.out.println("Salario Liquido: " + empregado.getSalarioLiquido());
        System.out.println("Salario Bruto: " + empregado.getSalarioBruto());
    }

}
