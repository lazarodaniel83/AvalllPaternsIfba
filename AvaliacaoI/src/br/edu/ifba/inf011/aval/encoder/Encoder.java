package br.edu.ifba.inf011.aval.encoder;

import br.edu.ifba.inf011.aval.renderer.Renderer;

public interface Encoder{
    void initialize(Renderer target);
    void setupContainer(String outputPath);
}