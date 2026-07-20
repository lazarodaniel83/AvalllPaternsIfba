package br.edu.ifba.inf011.model.playlist;

import br.edu.ifba.inf011.model.comercial.Pacote;

public class XMLExportVisitor implements PlaylistVisitor{

	private StringBuilder xml = new StringBuilder();
    private String nomePlaylist;
    private Integer contador = 0;
    
    private String escapeXML(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&apos;");
    }
    
    @Override
    public void visit(MP3 mp3) {
        contador++;
        xml.append("  <item type=\"mp3\" id=\"").append(contador).append("\">\n")
           .append("    <nome>").append(escapeXML(mp3.getNome())).append("</nome>\n")
           .append("    <duracao>").append(mp3.getDurationInSeconds()).append("</duracao>\n")
           .append("    <bitrate>").append(mp3.getBitrate()).append("</bitrate>\n")
           .append("    <artista>").append(escapeXML(mp3.getArtista())).append("</artista>\n")
           .append("    <album>").append(escapeXML(mp3.getAlbum())).append("</album>\n")
           .append("  </item>\n");
    }
    
    @Override
    public void visit(Video video) {
        contador++;
        xml.append("  <item type=\"video\" id=\"").append(contador).append("\">\n")
           .append("    <nome>").append(escapeXML(video.getNome())).append("</nome>\n")
           .append("    <duracao>").append(video.getDurationInSeconds()).append("</duracao>\n")
           .append("    <resolucao>").append(video.getResolucao()).append("</resolucao>\n")
           .append("    <bitrate>").append(video.getBitrate()).append("</bitrate>\n")
           .append("    <formato>").append(video.getFormato()).append("</formato>\n")
           .append("  </item>\n");
    }
    
    @Override
    public void visit(Pacote pacote) {
        contador++;
        xml.append("  <item type=\"pacote\" id=\"").append(contador).append("\">\n")
           .append("    <nome>").append(escapeXML(pacote.getNome())).append("</nome>\n")
           .append("    <duracao>").append(pacote.getDurationInSeconds()).append("</duracao>\n")
           .append("    <preco>").append(pacote.getPreco()).append("</preco>\n")
           .append("    <total_itens>").append(pacote.getTotalProdutos()).append("</total_itens>\n")
           .append("  </item>\n");
    }
    
    @Override
    public void visitPlaylistStart(Playlist playlist) {
        this.nomePlaylist = playlist.getNome();
        this.contador = 0;
        xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<playlist nome=\"").append(escapeXML(nomePlaylist))
           .append("\" criador=\"").append(escapeXML(playlist.getCriador())).append("\">\n");
    }
    
    @Override
    public void visitPlaylistEnd(Playlist playlist) {
        xml.append("</playlist>");
    }
    
    public String getXML() {
        return xml.toString();
    }
	
}
