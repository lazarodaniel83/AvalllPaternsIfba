package br.ifba.edu.inf011.principles;

import java.util.Collection;

public class RelatorioHorasTrabalhadas {

    public void gerarRelatorio(Collection<Empregado> empregados) {
        System.out.println("======================================");
        System.out.println("    RELATÓRIO DE HORAS TRABALHADAS    ");
        System.out.println("======================================");
        
        int totalHoras = 0;
        
        for (Empregado empregado : empregados) {
            String nome = empregado.getNome();
            int horas = empregado.getHorastrabalhadas();
            System.out.println("Colaborador: " + nome + " | Horas: " + horas + "h");
            totalHoras += horas;
        }
        
        System.out.println("--------------------------------------");
        System.out.println("TOTAL GERAL DE HORAS: " + totalHoras + "h");
        System.out.println("======================================\n");
    }
}
