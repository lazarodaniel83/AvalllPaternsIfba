package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.comercial.Pacote;

public interface PlaylistVisitor {

	// MÉTODOS PARA CADA TIPO DE ELEMENTO 
    public void visit(MP3 mp3);
    public void visit(Video video);
    public void visit(Pacote pacote);
    
    //  MÉTODOS PARA A PLAYLIST 
    default void visitPlaylistStart(Playlist playlist) {}
    default void visitPlaylistEnd(Playlist playlist) {}
}
