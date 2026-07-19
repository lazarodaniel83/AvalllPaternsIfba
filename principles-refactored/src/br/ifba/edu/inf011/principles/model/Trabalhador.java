package br.ifba.edu.inf011.principles.model;

public interface Trabalhador {
    public String getNome();

    public String getMatricula();

    public void registrarHoras(int horas);

    public int getHorasTrabalhadas();
}
