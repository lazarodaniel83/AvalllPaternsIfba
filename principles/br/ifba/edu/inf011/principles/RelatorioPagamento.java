package br.ifba.edu.inf011.principles;

public class RelatorioPagamento {

    public void gerarRelatorio(Empregado empregado) {
        System.out.println("======================================");
        System.out.println("        RELATÓRIO DE PAGAMENTO        ");
        System.out.println("======================================");
        System.out.println("Nome: " + empregado.getNome());
        System.out.println("Horas Trabalhadas: " + empregado.getHorastrabalhadas() + "h");
        System.out.println("Salário Bruto: R$ " + String.format("%.2f", empregado.getSalarioBruto()));
        System.out.println("Salário Líquido: R$ " + String.format("%.2f", empregado.getSalarioLiquido()));
        System.out.println("======================================\n");
    }
}
