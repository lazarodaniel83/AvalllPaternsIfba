package br.ifba.edu.inf011.principles.model;

import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.dominio.Cargo;
import br.ifba.edu.inf011.principles.dominio.Estado;
import br.ifba.edu.inf011.principles.dominio.Nome;
import br.ifba.edu.inf011.principles.servicos.promocao.Promovivel;

public class Terceirizado implements Trabalhador, Promovivel {

    private TrabalhadorBase base;
    private Cargo cargo;

    public Terceirizado(String matricula, Nome nome, String rua, String bairro, CEP cep, Estado estado, Cargo cargo) {
        this.base = new TrabalhadorBase(matricula, nome, rua, bairro, cep, estado);
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

    @Override
    public void registrarHoras(int horas) {
        this.base.registrarHoras(horas);
    }

    @Override
    public int getHorasTrabalhadas() {
        return this.base.getHorasTrabalhadas();
    }

    @Override
    public String toString() {
        return this.base.toString() +
               "Horas Trabalhadas: " + this.base.getHorasTrabalhadas() + "h\n";
    }

    @Override
    public void promover() {
        this.cargo = this.cargo.proximo();
    }
}
