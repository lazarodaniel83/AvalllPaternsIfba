package br.edu.ifba.inf011.aval.encoder;

import br.edu.ifba.inf011.aval.renderer.Renderer;

public class ProResEncoder implements Encoder {

	private Renderer target;
    private final EncoderProfile profile = EncoderProfile.CINEMA_PRORES;
    private String outputPath;

    @Override
    public void initialize(Renderer target) {
    	this.target = target;
        System.out.println("[ProResEncoder] Conectado ao motor de renderização.");
        System.out.println("[ProResEncoder] Codec de Vídeo ativo: " + profile.getVideoCodec());
        System.out.println("[ProResEncoder] Codec de Áudio ativo: " + profile.getAudioCodec());
    }

    @Override
    public void setupContainer(String outputPath) {
        this.outputPath = outputPath;
        System.out.println("[Encoder] Criando container físico no formato: " + profile.getContainerFormat());
        System.out.println("[Encoder] Destino do arquivo: " + this.outputPath);
    }

}