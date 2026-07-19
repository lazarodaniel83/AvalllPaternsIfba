package br.ifba.edu.inf011.principles.dominio;

public class CEP {

    private String valor;

    public CEP(String valor) {
        this.setValor(valor);
    }

    public String getValor() {
        return valor;
    }

    private void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isValid() {
        return this.valor.matches("\\d{8}");
    }

    public String formatado() {
        return this.valor.substring(0, 5) + "-" + this.valor.substring(5);
    }

}
