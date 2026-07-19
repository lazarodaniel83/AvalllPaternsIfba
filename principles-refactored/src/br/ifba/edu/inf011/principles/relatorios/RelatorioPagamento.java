package br.ifba.edu.inf011.principles.relatorios;

import java.util.Iterator;
import br.ifba.edu.inf011.principles.servicos.salarios.Aumentavel;
import java.math.BigDecimal;

public class RelatorioPagamento {

    public String gerarRelatorio(Iterator<Aumentavel> aumentaveis) {
        BigDecimal valorFolhaBruto = BigDecimal.ZERO;
        BigDecimal valorFolhaLiquido = BigDecimal.ZERO;
        StringBuilder sb = new StringBuilder();
        sb.append("======================================\n");
        sb.append("        RELATÓRIO DE PAGAMENTO        \n");
        sb.append("======================================\n");
        while (aumentaveis.hasNext()) {
            Aumentavel aumentavel = aumentaveis.next();
            sb.append("Nome: ").append(aumentavel.getNome()).append("\n");
            sb.append("Horas Trabalhadas: ").append(aumentavel.getHorasTrabalhadas()).append("h\n");
            sb.append("Salário Bruto: R$ ").append(String.format("%.2f", aumentavel.getSalarioBruto())).append("\n");
            sb.append("Salário Líquido: R$ ").append(String.format("%.2f", aumentavel.getSalarioLiquido()))
                    .append("\n");
            sb.append("--------------------------------------\n");
            valorFolhaBruto = valorFolhaBruto.add(aumentavel.getSalarioBruto());
            valorFolhaLiquido = valorFolhaLiquido.add(aumentavel.getSalarioLiquido());
        }
        sb.append("--------------------------------------\n");
        sb.append("VALOR BRUTO DA FOLHA: R$ ").append(String.format("%.2f", valorFolhaBruto)).append("\n");
        sb.append("VALOR LÍQUIDO DA FOLHA: R$ ").append(String.format("%.2f", valorFolhaLiquido)).append("\n");
        sb.append("======================================\n\n");

        return sb.toString();
    }
}
