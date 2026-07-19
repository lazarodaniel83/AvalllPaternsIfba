package br.edu.ifba.inf011.aval.timeline;

import br.edu.ifba.inf011.aval.canva.Canva;
import br.edu.ifba.inf011.aval.encoder.Encoder;
import br.edu.ifba.inf011.aval.renderer.Renderer;

public interface TimelineBuilder {
	public TimelineBuilder reset();
	public TimelineBuilder setCanva(Canva canva);
	public TimelineBuilder setEncoder(Encoder encoder);
	public TimelineBuilder setRenderer(Renderer renderer);
	public TimelineBuilder addVideo(String name);
	public TimelineBuilder addAudio(String name);
	public TimelineBuilder addSubtitle(String name, String idioma);
	public Timeline build();
}