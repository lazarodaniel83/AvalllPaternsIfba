package br.ifba.edu.inf011.principles.dominio;

public class CartaoHoras {

    private Integer horasTrabalhadas;

    public CartaoHoras() {
        this.horasTrabalhadas = 0;
    }

    public void registrarHoras(int horas) {
        this.horasTrabalhadas += horas;
    }

    public int getHorasTrabalhadas() {
        return this.horasTrabalhadas;
    }

    public void reset() {
        this.horasTrabalhadas = 0;
    }
}
