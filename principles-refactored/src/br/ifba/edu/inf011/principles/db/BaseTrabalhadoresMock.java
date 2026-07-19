package br.ifba.edu.inf011.principles.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import br.ifba.edu.inf011.principles.dominio.Cargo;
import br.ifba.edu.inf011.principles.dominio.Estado;
import br.ifba.edu.inf011.principles.dominio.Nome;
import br.ifba.edu.inf011.principles.model.Empregado;
import br.ifba.edu.inf011.principles.model.Estagiario;
import br.ifba.edu.inf011.principles.model.Terceirizado;
import br.ifba.edu.inf011.principles.model.Trabalhador;
import br.ifba.edu.inf011.principles.dominio.CEP;
import br.ifba.edu.inf011.principles.servicos.promocao.Promovivel;
import br.ifba.edu.inf011.principles.servicos.salarios.Aumentavel;

import java.math.BigDecimal;

public class BaseTrabalhadoresMock {

    private Map<String, Trabalhador> trabalhadores;

    private String[] primeiroNome = {
            "Joao", "Maria", "Pedro", "Ana", "Lucas",
            "Julia", "Marcos", "Beatriz", "Rafael", "Fernanda" };
    private String[] sobrenome = {
            "Silva", "Santos", "Almeida", "Costa", "Ferreira",
            "Souza", "Lima", "Gomes", "Castro", "Rocha" };
    private String[] bairros = { "Centro", "Pituba", "Caminho das Arvores", "Rio Vermelho", "Graca" };
    private Cargo[] cargos = Cargo.values();
    private Estado[] estados = Estado.values();

    public BaseTrabalhadoresMock(int quantidade) {
        this.trabalhadores = new HashMap<String, Trabalhador>();
        this.initEmpregados(quantidade);
        this.initEstagiarios(quantidade);
        this.initTerceirizados(quantidade);
    }

    private void initEmpregados(int quantidade) {
        Random random = new Random();

        for (int iCont = 0; iCont < quantidade; iCont++) {
            String matricula = String.format("%05d", iCont + 1);
            String nome = primeiroNome[Math.abs(random.nextInt()) % primeiroNome.length] + " " +
                    sobrenome[Math.abs(random.nextInt()) % sobrenome.length];
            String rua = "Rua " + (random.nextInt(100) + 1);
            String bairro = bairros[Math.abs(random.nextInt()) % bairros.length];
            String cep = String.format("%08d", random.nextInt(100000000));
            Estado estado = estados[Math.abs(random.nextInt()) % estados.length];
            double horaSalarial = (iCont + 1) * 1000;
            Cargo cargo = cargos[random.nextInt(cargos.length)];
            Empregado empregado = new Empregado(matricula, new Nome(nome), rua, bairro,
                    new CEP(cep), estado,
                    BigDecimal.valueOf(horaSalarial), cargo);
            this.trabalhadores.put(matricula, empregado);
        }
    }

    private void initEstagiarios(int quantidade) {
        Random random = new Random();

        for (int iCont = 0; iCont < quantidade; iCont++) {
            String matricula = String.format("E%05d", iCont + 1);
            String nome = primeiroNome[Math.abs(random.nextInt()) % primeiroNome.length] + " " +
                    sobrenome[Math.abs(random.nextInt()) % sobrenome.length];
            String rua = "Rua " + (random.nextInt(100) + 1);
            String bairro = bairros[Math.abs(random.nextInt()) % bairros.length];
            String cep = String.format("%08d", random.nextInt(100000000));
            Estado estado = estados[Math.abs(random.nextInt()) % estados.length];
            double horaSalarial = (iCont + 1) * 1000;
            Estagiario estagiario = new Estagiario(matricula, new Nome(nome), rua, bairro,
                    new CEP(cep), estado, BigDecimal.valueOf(horaSalarial));
            this.trabalhadores.put(matricula, estagiario);
        }
    }

    private void initTerceirizados(int quantidade) {
        Random random = new Random();

        for (int iCont = 0; iCont < quantidade; iCont++) {
            String matricula = String.format("T%05d", iCont + 1);
            String nome = primeiroNome[Math.abs(random.nextInt()) % primeiroNome.length] + " " +
                    sobrenome[Math.abs(random.nextInt()) % sobrenome.length];
            String rua = "Rua " + (random.nextInt(100) + 1);
            String bairro = bairros[Math.abs(random.nextInt()) % bairros.length];
            String cep = String.format("%08d", random.nextInt(100000000));
            Estado estado = estados[Math.abs(random.nextInt()) % estados.length];
            Cargo cargo = cargos[random.nextInt(cargos.length)];
            Terceirizado terceirizado = new Terceirizado(matricula, new Nome(nome), rua, bairro,
                    new CEP(cep), estado, cargo);
            this.trabalhadores.put(matricula, terceirizado);
        }
    }

    public Trabalhador getTrabalhador(String matricula) {
        return this.trabalhadores.get(matricula);
    }

    public Iterator<Trabalhador> getTrabalhadores() {
        return this.trabalhadores.values().stream().iterator();
    }

    public Iterator<Promovivel> getPromoviveis() {
        return this.trabalhadores.values().stream()
                .filter(Promovivel.class::isInstance)
                .map(Promovivel.class::cast)
                .iterator();
    }

    public Iterator<Aumentavel> getAumentaveis() {
        return this.trabalhadores.values().stream()
                .filter(Aumentavel.class::isInstance)
                .map(Aumentavel.class::cast)
                .iterator();
    }

}
