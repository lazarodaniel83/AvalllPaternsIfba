package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;

public class Episodio implements Product{
	
	private String titulo;
    private Double preco;
    private Timeline timeline;
    private Integer numero;

	public Episodio(String titulo, Double preco, Integer numero, Timeline timeline) {
    	this.titulo = titulo;
        this.preco = preco;
        this.timeline = timeline;
        this.numero = numero;
	}
	 private Episodio(Builder builder) {
	        this.titulo = builder.titulo;
	        this.preco = builder.preco;
	        this.timeline = builder.timeline;
	        this.numero = builder.numero;

	    }
	
    public Double getPreco() {
    	return this.preco; 
    }
    
    public Integer getDuracao() { 
    	return this.timeline.getDurationInSeconds();
    }

	public String getTitulo() {
		return this.titulo;
	}

	public Integer getNumero() {
		return this.numero;
	}

	 public Timeline getTimeline() { return timeline; }
	
	public String toXML() {
		String xml = "<episodio titulo=\"" + this.getTitulo() + "\" numero=\"" + this.getNumero() + "\"/>\n";
		return xml;
	}

	@Override
	public Integer getDurationInSeconds() {
		return timeline != null ? timeline.getDurationInSeconds() : 0;
	}

	@Override
	public void render(Integer init, Integer duration) {
		 if (timeline != null) {
	            timeline.render(init, duration);
	        }
		
	} 	
	
	 public static class Builder {
	        private String titulo;
	        private Double preco;
	        private Timeline timeline;
	        private Integer numero = 1;
	        
	        public Builder(String titulo, Double preco) {
	        	if (titulo == null || titulo.trim().isEmpty()) {
	                throw new IllegalArgumentException("Título é obrigatório");
	            }
	            if (preco == null || preco < 0) {
	                throw new IllegalArgumentException("Preço deve ser positivo");
	            }
	            this.titulo = titulo;
	            this.preco = preco;
	            this.timeline = new Timeline(0);
	        }
	        
	        public Builder withTimeline(Timeline timeline) {
	            this.timeline = timeline;
	            return this;
	        }
	        
	        public Builder withDuration(Integer duration) {
	            if (duration != null && duration > 0) {
	                this.timeline = new Timeline(duration);
	            }
	            return this;
	        }
	        
	        public Builder withNumero(Integer numero) {
	            this.numero = numero;
	            return this;
	        }
	        

	        
	        public Episodio build() {
	            if (this.timeline == null) {
	                this.timeline = new Timeline(0);
	            }
	            return new Episodio(this);
	        }
	    }

	 @Override
	 public String getTipo() {
		  return "EPISODIO";
	 }
	 @Override
	 public String getDescricao() {
		 return String.format(" S%02dE%02d - %s - R$ %.2f | %d min", 
                 numero, titulo, preco, getDurationInSeconds() / 60);
	 }
}