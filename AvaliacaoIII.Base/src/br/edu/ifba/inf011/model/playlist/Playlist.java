package br.edu.ifba.inf011.model.playlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Playlist{
	
	private String nome;
    private List<PlaylistItem> itens = new ArrayList<>();
    private String criador;
    private Date dataCriacao;
    
    public Playlist(String nome) {
        this.nome = nome;
        this.criador = "Desconhecido";
        this.dataCriacao = new Date();
    }
    
    public Playlist(String nome, String criador) {
        this.nome = nome;
        this.criador = criador;
        this.dataCriacao = new Date();
    }
    
    public Playlist addItem(PlaylistItem item) {
        if (item != null) { itens.add(item); }
        return this;
    }
    
    public Playlist addItems(PlaylistItem... itemArray) {
        if (itemArray != null) { Collections.addAll(itens, itemArray); }
        return this;
    }
    
    public Playlist removeItem(PlaylistItem item) {
        itens.remove(item);
        return this;
    }
    
    public List<PlaylistItem> getItens() {
        return Collections.unmodifiableList(itens);
    }
    
    public Integer getTotalItens() {
        return itens.size();
    }
    
    public String getNome() { return nome; }
    public String getCriador() { return criador; }
    public Date getDataCriacao() { return dataCriacao; }
    
    public Integer getDurationInSeconds() {
        return itens.stream().mapToInt(PlaylistItem::getDurationInSeconds).sum();
    }
    
    // ACEITA O VISITOR E PROPAGA PARA TODOS OS ITENS 
    
    public void accept(PlaylistVisitor visitor) {
        visitor.visitPlaylistStart(this);
        for (PlaylistItem item : itens) {
            item.accept(visitor);
        }
        visitor.visitPlaylistEnd(this);
    }
	
}
