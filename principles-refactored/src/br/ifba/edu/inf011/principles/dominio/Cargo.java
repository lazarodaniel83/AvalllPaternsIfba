package br.ifba.edu.inf011.principles.dominio;

public enum Cargo {
    TRAINEE, JUNIOR, SENIOR, MENTOR;

    public Cargo proximo() {
        if (this.ordinal() < Cargo.values().length - 1)
            return Cargo.values()[this.ordinal() + 1];
        return this;
    }
}
