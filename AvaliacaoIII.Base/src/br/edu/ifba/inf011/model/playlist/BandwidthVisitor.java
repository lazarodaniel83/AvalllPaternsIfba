package br.edu.ifba.inf011.model.playlist;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.comercial.Product;

public class BandwidthVisitor implements PlaylistVisitor{

	 private Long totalBandwidth = 0L;
	    private Map<String, Long> bandwidthPorTipo = new HashMap<>();
	    private String nomePlaylist;
	    private Integer totalItens = 0;
	    
	    @Override
	    public void visit(MP3 mp3) {
	        Long tamanho = mp3.getTamanhoArquivo();
	        totalBandwidth += tamanho;
	        bandwidthPorTipo.merge("MP3", tamanho, Long::sum);
	        totalItens++;
	    }
	    
	    @Override
	    public void visit(Video video) {
	        Long tamanho = video.getTamanhoArquivo();
	        totalBandwidth += tamanho;
	        bandwidthPorTipo.merge("Video", tamanho, Long::sum);
	        totalItens++;
	    }
	    
	    @Override
	    public void visit(Pacote pacote) {
	        Long tamanhoPacote = 0L;
	        for (Product produto : pacote.getProdutos()) {
	            tamanhoPacote += (produto.getDurationInSeconds() * 10_000_000L) / 8;
	        }
	        totalBandwidth += tamanhoPacote;
	        bandwidthPorTipo.merge("Pacote", tamanhoPacote, Long::sum);
	        totalItens++;
	    }
	    
	    @Override
	    public void visitPlaylistStart(Playlist playlist) {
	        this.nomePlaylist = playlist.getNome();
	        this.totalBandwidth = 0L;
	        this.bandwidthPorTipo.clear();
	        this.totalItens = 0;
	    }
	    
	    public String getRelatorio() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("📊 RELATÓRIO DE LARGURA DE BANDA\n");
	        sb.append("=".repeat(50)).append("\n");
	        sb.append("Playlist: ").append(nomePlaylist).append("\n");
	        sb.append("Total de itens: ").append(totalItens).append("\n\n");
	        sb.append("Detalhamento por tipo:\n");
	        
	        for (Map.Entry<String, Long> entry : bandwidthPorTipo.entrySet()) {
	            Double mb = entry.getValue() / (1024.0 * 1024.0);
	            sb.append("  • ").append(entry.getKey())
	              .append(": ").append(String.format("%.2f MB", mb)).append("\n");
	        }
	        
	        Double totalMB = totalBandwidth / (1024.0 * 1024.0);
	        sb.append("\nTotal: ").append(String.format("%.2f MB", totalMB));
	        return sb.toString();
	    }
	    
	    public Long getTotalBandwidth() { return totalBandwidth; }

		
	
}
