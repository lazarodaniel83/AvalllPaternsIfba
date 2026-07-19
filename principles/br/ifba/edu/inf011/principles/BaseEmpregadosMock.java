package br.ifba.edu.inf011.principles;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseEmpregadosMock {

    private Map<String, Empregado> empregados;

    public BaseEmpregadosMock(int quantidade) {
        this.empregados = new HashMap<String, Empregado>();
        init(quantidade);
    }

    private void init(int quantidade) {
        Random random = new Random();
        String[] nomes = {
                "Joao Silva", "Maria Santos", "Pedro Almeida", "Ana Costa", "Lucas Ferreira",
                "Julia Souza", "Marcos Lima", "Beatriz Gomes", "Rafael Castro", "Fernanda Rocha"
        };
        String[] estados = { "BA", "SP", "RJ", "MG", "PE" };
        String[] bairros = { "Centro", "Pituba", "Caminho das Arvores", "Rio Vermelho", "Graca" };
        Cargo[] cargos = Cargo.values();

        for (int iCont = 0; iCont < quantidade; iCont++) {
            String matricula = String.format("%05d", iCont + 1);
            String nome = nomes[iCont % nomes.length];
            String rua = "Rua " + (random.nextInt(100) + 1);
            String bairro = bairros[random.nextInt(bairros.length)];
            String cep = String.format("%08d", random.nextInt(100000000));
            String estado = estados[random.nextInt(estados.length)];
            double horaSalarial = (iCont + 1) * 1000;
            Cargo cargo = cargos[random.nextInt(cargos.length)];
            Empregado empregado = new Empregado(matricula, nome, rua, bairro, cep, estado, horaSalarial, cargo);
            empregados.put(matricula, empregado);
        }
    }

    public Map<String, Empregado> getEmpregados() {
        return empregados;
    }

    public Empregado getEmpregado(String matricula) {
        return empregados.get(matricula);
    }
}
