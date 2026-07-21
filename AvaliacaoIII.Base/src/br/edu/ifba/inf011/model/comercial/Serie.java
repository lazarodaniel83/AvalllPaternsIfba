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

    public Integer getTotalEpisodios() {
        return temporadas.stream()
                .mapToInt(Temporada::getTotalEpisodios)
                .sum();
    }
    
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
    
    @Override
    public Integer getDurationInSeconds() {
        return temporadas.stream()
                .mapToInt(Temporada::getDurationInSeconds)
                .sum();
    }
    
    public Serie addTemporada(Temporada temporada) {
        if (temporada != null) {
            temporadas.add(temporada);
        }
        return this;
    }
    
    public Serie addTemporada(Integer numero, Episodio... episodios) {
        Temporada temporada = new Temporada(numero);
        for (Episodio ep : episodios) {
            temporada.addEpisodio(ep);
        }
        temporadas.add(temporada);
        return this;
    }
    
    public List<Temporada> getTemporadas() {
        return Collections.unmodifiableList(temporadas);
    }
    
    public Integer getTotalTemporadas() {
        return temporadas.size();
    }
    
 	
	 @Override
	    public String getDescricao() {
	        StringBuilder sb = new StringBuilder();
	        
	        sb.append(String.format("📺 %s - %d temporadas - %d episódios - R$ %.2f%n", 
	                this.titulo, 
	                temporadas.size(), 
	                getTotalEpisodios(), 
	                getPreco()));
	        
	        for (Temporada temp : temporadas) {
	            sb.append(String.format("  Temporada %d (%d episódios):%n", 
	                    temp.getNumero(), 
	                    temp.getTotalEpisodios()));
	            
	            int show = Math.min(temp.getEpisodios().size(), 5);
	            for (int i = 0; i < show; i++) {
	                Episodio ep = temp.getEpisodios().get(i);
	               
	                sb.append("    • E").append(String.format("%02d", ep.getNumero()))
	                  .append(" - ").append(ep.getTitulo())
	                  .append(" (R$ ").append(String.format("%.2f", ep.getPreco()))
	                  .append(")%n");
	            }
	            if (temp.getEpisodios().size() > 5) {
	                sb.append("    • ... e mais ")
	                  .append(temp.getEpisodios().size() - 5)
	                  .append(" episódios%n");
	            }
	        }
	        
	        return sb.toString();
	    }
	

	
	 @Override
	    public void render(Integer init, Integer duration) {
	        for (Temporada temp : temporadas) {
	            for (Episodio ep : temp.getEpisodios()) {
	                ep.render(init, duration);
	            }
	        }
	    }
	@Override
	public String getTipo() {
		return "SERIE";
	}

	
	
}
          
	
	
	