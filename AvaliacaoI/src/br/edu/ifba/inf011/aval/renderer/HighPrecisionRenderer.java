package br.edu.ifba.inf011.aval.renderer;

import br.edu.ifba.inf011.aval.canva.Canva;

public class HighPrecisionRenderer implements Renderer{
	
    private Canva targetCanvas;

    @Override
    public void initialize(Canva target) {
        this.targetCanvas = target;
        System.out.println("[HighPrecisionRenderer] Inicializando motor gráfico..." );
        System.out.println("[HighPrecisionRenderer] Alocando buffer para a resolução a " + targetCanvas.getResolution());
    }

    @Override
    public void render() {
        System.out.println("[HighPrecisionRenderer] Processando efeitos visuais complexos com renderer de Alta Precisão..." );
    }	

}
