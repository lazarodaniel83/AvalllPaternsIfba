package br.ifba.edu.inf011.principles;

public class App {

    private static final Integer QUANTIDADE_EMPREGADOS = 2;

    private BaseEmpregadosMock baseEmpregados;

    public App() {
        this.baseEmpregados = new BaseEmpregadosMock(App.QUANTIDADE_EMPREGADOS);
    }

    public void run() {
        this.registaHoras("00001", 10);
        this.registaHoras("00002", 2);
        this.relatorioPagamento();
        this.relatorioHorasTrabalhadas();
    }

    public void registaHoras(String matricula, int horas) {
        Empregado empregado = this.baseEmpregados.getEmpregado(matricula);
        if (empregado != null) {
            int horasTrabalhadas = empregado.getHorastrabalhadas();
            horasTrabalhadas += horas;
            empregado.setHorastrabalhadas(horasTrabalhadas);
        }
    }

    public void relatorioPagamento() {

        RelatorioPagamento relatorioPagamento = new RelatorioPagamento();

        System.out.println("--- Lista de Empregados na Base Mock ---");

        for (int iCont = 0; iCont < baseEmpregados.getEmpregados().size(); iCont++) {
            relatorioPagamento.gerarRelatorio(baseEmpregados.getEmpregados().get(String.format("%05d", iCont + 1)));
        }
    }

    public void relatorioHorasTrabalhadas() {
        RelatorioHorasTrabalhadas relatorioHoras = new RelatorioHorasTrabalhadas();
        relatorioHoras.gerarRelatorio(baseEmpregados.getEmpregados().values());
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
