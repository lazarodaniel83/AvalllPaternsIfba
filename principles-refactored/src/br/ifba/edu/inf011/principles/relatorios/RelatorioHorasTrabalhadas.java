package br.ifba.edu.inf011.principles.relatorios;

import java.util.Iterator;

import br.ifba.edu.inf011.principles.model.Trabalhador;

public class RelatorioHorasTrabalhadas {

    public String gerarRelatorio(Iterator<Trabalhador> trabalhadores) {
        StringBuilder sb = new StringBuilder();
        int totalHoras = 0;
        sb.append("======================================\n");
        sb.append("    RELATÓRIO DE HORAS TRABALHADAS    \n");
        sb.append("======================================\n");
        while (trabalhadores.hasNext()) {
            Trabalhador trabalhador = trabalhadores.next();
            String matricula = trabalhador.getMatricula();
            String nome = trabalhador.getNome();
            int horas = trabalhador.getHorasTrabalhadas();
            sb.append("Trabalhador: ").append(matricula).append(" - ").append(nome).append(" | Horas: ").append(horas)
                    .append("h\n");
            totalHoras += horas;
        }
        sb.append("--------------------------------------\n");
        sb.append("TOTAL GERAL DE HORAS: ").append(totalHoras).append("h\n");
        sb.append("======================================\n\n");

        return sb.toString();
    }
}
