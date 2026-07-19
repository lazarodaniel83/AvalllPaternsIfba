package br.ifba.edu.inf011.principles;

public class Empregado {

    private String matricula;
    private String nome;
    private String rua;
    private String bairro;
    private String cep;
    private String estado;
    private double horaSalarial;
    private int horastrabalhadas;
    private Cargo cargo;

    public Empregado(String matricula, String nome, String rua, String bairro, String cep, String estado,
            double horaSalarial, Cargo cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.horaSalarial = horaSalarial;
        this.horastrabalhadas = 0;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getHoraSalarial() {
        return horaSalarial;
    }

    public void setHoraSalarial(double horaSalarial) {
        this.horaSalarial = horaSalarial;
    }

    public int getHorastrabalhadas() {
        return horastrabalhadas;
    }

    public void setHorastrabalhadas(int horastrabalhadas) {
        this.horastrabalhadas = horastrabalhadas;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalarioBruto() {
        return horaSalarial * horastrabalhadas;
    }

    // Retorna o Salário Líquido com base nas regras de tributação
    public double getSalarioLiquido() {
        double imposto = 0;
        double bruto = this.getSalarioBruto();
        // Regra: Isento até 500 (não faz nada)
        // Regra: 2,5% do que exceder 500 até 1000
        if (bruto > 500) {
            double baseFaixa2 = Math.min(bruto, 1000) - 500;
            imposto += baseFaixa2 * 0.025;
        }
        // Regra: 5% do que exceder 1000
        if (bruto > 1000) {
            double baseFaixa3 = bruto - 1000;
            imposto += baseFaixa3 * 0.05;
        }
        return bruto - imposto;
    }

    @Override
    public String toString() {
        return "Empregado [matricula=" + matricula + ", nome=" + nome + ", rua=" + rua + ", bairro=" + bairro + ", cep="
                + cep + ", estado=" + estado + ", horaSalarial=" + horaSalarial + ", horastrabalhadas="
                + horastrabalhadas + ", cargo=" + cargo + "]";
    }

    public static void main(String[] args) {
        Empregado empregado = new Empregado("123456", "Joao Silva", "Rua 1", "Bairro 1", "12345678", "BA", 0,
                Cargo.JUNIOR);
        System.out.println(empregado);
        System.out.println("Salario: " + empregado.getSalarioLiquido());
    }

}
