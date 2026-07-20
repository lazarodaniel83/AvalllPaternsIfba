package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.avaliacao2.decorator.RenderableContent;

public interface PlaylistItem extends RenderableContent{
	 String getNome();
	    void accept(PlaylistVisitor visitor);
	    String getTipo();
}

