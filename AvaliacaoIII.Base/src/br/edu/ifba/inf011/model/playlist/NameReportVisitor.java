package br.edu.ifba.inf011.model.playlist;

public class NameReportVisitor implements PlaylistVisitor{
	private List<String> nomes = new ArrayList<>();
    private Map<String, Integer> contagemPorTipo = new HashMap<>();
    private String nomePlaylist;
    private Integer totalItens = 0;
    
    @Override
    public void visit(MP3 mp3) {
        nomes.add("🎵 " + mp3.getNome() + " - " + mp3.getArtista());
        contagemPorTipo.merge("MP3", 1, Integer::sum);
        totalItens++;
    }
    
    @Override
    public void visit(Video video) {
        nomes.add("🎬 " + video.getNome() + " (" + video.getResolucao() + ")");
        contagemPorTipo.merge("Video", 1, Integer::sum);
        totalItens++;
    }
    
    @Override
    public void visit(Pacote pacote) {
        nomes.add("📦 " + pacote.getNome() + " (" + pacote.getTotalProdutos() + " itens)");
        contagemPorTipo.merge("Pacote", 1, Integer::sum);
        totalItens++;
    }
    
    @Override
    public void visitPlaylistStart(Playlist playlist) {
        this.nomePlaylist = playlist.getNome();
        this.nomes.clear();
        this.contagemPorTipo.clear();
        this.totalItens = 0;
    }
    
    public String getRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("📋 RELATÓRIO DE ELEMENTOS DA PLAYLIST\n");
        sb.append("=".repeat(50)).append("\n");
        sb.append("Playlist: ").append(nomePlaylist).append("\n");
        sb.append("Total de itens: ").append(totalItens).append("\n\n");
        sb.append("Elementos:\n");
        
        for (int i = 0; i < nomes.size(); i++) {
            sb.append(String.format("  %d. %s%n", i + 1, nomes.get(i)));
        }
        
        sb.append("\nResumo por tipo:\n");
        for (Map.Entry<String, Integer> entry : contagemPorTipo.entrySet()) {
            sb.append("  • ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
