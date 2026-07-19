package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Serie implements Product{

	protected String titulo;
    private List<Temporada> temporadas = new ArrayList<>();
    protected List<Episodio> episodios;
    protected Double precoBase;
    protected Double desconto; 
    protected String genero;
    protected String sinopse;
    
    public Serie(String titulo, Integer temporada) {
    	this.titulo = titulo;
    	this.episodios = new ArrayList<Episodio>();
    };
    public Serie addEpisodio(Episodio episodio) {
        if (episodio != null) { episodios.add(episodio); }
        return this;
    };
    
    public Serie(String titulo, Double precoBase) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da série é obrigatório");
        }
        if (precoBase == null || precoBase < 0) {
            throw new IllegalArgumentException("Preço base deve ser positivo");
        }
        this.titulo = titulo;
        
        this.precoBase = precoBase;
        this.desconto = 0.0;
        this.genero = "Desconhecido";
    }
    
    public Serie(String titulo, Double precoBase, Double desconto) {
        this.titulo = titulo ;
        this.precoBase = precoBase;
        this.desconto = desconto != null ? desconto : 0.0;
    }
    
    public Serie addEpisodios(Episodio... episodioArray) {
        if (episodioArray != null) { Collections.addAll(episodios, episodioArray); }
        return this;
    }
    
    public List<Episodio> getEpisodios() { return Collections.unmodifiableList(episodios); }
    public Integer getTotalEpisodios() { return episodios.size(); }
    
    public String getTitulo() {
    	return this.titulo;
    }
        
    public Double getPreco() {
        double soma = this.episodios.stream().mapToDouble(Episodio::getPreco).sum();
        return soma * 0.9;
    }
        
    public Integer getDuracao() {
        return  this.episodios.stream().mapToInt(Episodio::getDuracao).sum(); 
    }    
    
    public Integer getTemporada() {
    	return this.temporada;
    }
    

	public String toXML() {
		String xml = "\t<serie titulo=\"" + this.getTitulo() + "\" temporada=\"" + this.getTemporada() + "\">\n";
		for(Episodio episodio : this.episodios)
			xml += episodio.toXML();
		return xml + "\t</serie>\n";
		
	}
	
	 @Override
	 public String getDescricao() {
	        StringBuilder sb = new StringBuilder();
	        
	       
	        sb.append(String.format("📺 %s - %d episódios - R$ %.2f%n", 
	                this.titulo, episodios.size(), getPreco()));
	        sb.append("  Episódios:%n");
	        
	        int show = Math.min(episodios.size(), 5);
	        for (int i = 0; i < show; i++) {
	            Episodio ep = episodios.get(i);
	            // ⭐ FORMATAÇÃO CORRETA ⭐
	            sb.append("    • S").append(String.format("%02d", ep.getTemporada()))
	              .append("E").append(String.format("%02d", ep.getNumero()))
	              .append(" - ").append(ep.getTitulo())
	              .append(" (R$ ").append(String.format("%.2f", ep.getPreco()))
	              .append(")%n");
	        }
	        if (episodios.size() > 5) {
	            // ⭐ FORMATAÇÃO CORRETA ⭐
	            sb.append("    • ... e mais ").append(episodios.size() - 5).append(" episódios%n");
	        }
	        return sb.toString();
	    }
	
	@Override
	public Integer getDurationInSeconds() {
		return episodios.stream().mapToInt(Episodio::getDurationInSeconds).sum();
    }
	
	@Override
	public void render(Integer init, Integer duration) {
		 for (Episodio ep : episodios) { ep.render(init, duration); }
		
	}
	@Override
	public String getTipo() {
		return "SERIE";

}