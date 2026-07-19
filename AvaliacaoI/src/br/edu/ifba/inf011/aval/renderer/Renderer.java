package br.edu.ifba.inf011.aval.renderer;

import br.edu.ifba.inf011.aval.canva.Canva;

public interface Renderer {
    public void initialize(Canva target);
    public void render();
}