package br.ifba.edu.inf011.principles;

import br.ifba.edu.inf011.principles.db.BaseTrabalhadoresMock;
import br.ifba.edu.inf011.principles.exception.RHException;
import br.ifba.edu.inf011.principles.model.Trabalhador;
import br.ifba.edu.inf011.principles.relatorios.RelatorioHorasTrabalhadas;
import br.ifba.edu.inf011.principles.relatorios.RelatorioPagamento;
import br.ifba.edu.inf011.principles.servicos.salarios.Aumentavel;
import java.util.Iterator;

public class App {

    private static final Integer QUANTIDADE_TRABALHADORES_POR_TIPO = 2;

    private BaseTrabalhadoresMock baseTrabalhadores;

    public App() {
        this.baseTrabalhadores = new BaseTrabalhadoresMock(App.QUANTIDADE_TRABALHADORES_POR_TIPO);
    }

    public void run() throws RHException {
        this.registaHoras("00001", 10);
        this.registaHoras("00002", 2);
        this.registaHoras("E00001", 10);
        this.registaHoras("E00002", 4);
        this.registaHoras("T00001", 22);
        this.registaHoras("T00002", 5);
        this.relatorioPagamento();
        this.relatorioHorasTrabalhadas();
    }

    public void registaHoras(String matricula, Integer horas) throws RHException {
        Trabalhador trabalhador = this.baseTrabalhadores.getTrabalhador(matricula);
        if (trabalhador == null)
            throw new RHException("Trabalhador não encontrado");
        trabalhador.registrarHoras(horas);
    }

    public void relatorioPagamento() throws RHException {
        RelatorioPagamento relatorioPagamento = new RelatorioPagamento();
        Iterator<Aumentavel> aumentaveis = this.baseTrabalhadores.getAumentaveis();
        System.out.println("--- Lista de Aumentaveis na Base Mock ---");
        System.out.print(relatorioPagamento.gerarRelatorio(aumentaveis));
    }

    public void relatorioHorasTrabalhadas() throws RHException {
        RelatorioHorasTrabalhadas relatorioHoras = new RelatorioHorasTrabalhadas();
        Iterator<Trabalhador> trabalhadores = this.baseTrabalhadores.getTrabalhadores();
        System.out.println("--- Lista de Trabalhadores na Base Mock ---");
        System.out.print(relatorioHoras.gerarRelatorio(trabalhadores));
    }

    public static void main(String[] args) throws RHException {
        App app = new App();
        app.run();
    }
}
