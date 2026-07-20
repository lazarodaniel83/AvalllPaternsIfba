package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;

public class Filme implements Product{
	private String titulo;
    private Double preco;
    private Timeline timeline;
    private String diretor;
    
	private Filme(Builder builder) {
    	this.titulo = builder.titulo;
        this.preco = builder.preco;
        this.timeline = builder.timeline;
        this.diretor = builder.diretor;
	}
	
    public Double getPreco() {
    	return this.preco; 
    }
    
    public String getDiretor() { return diretor; }
    
    public Integer getDuracao() { 
    	return this.timeline.getDurationInSeconds();
    }

	public String getTitulo() {
		return this.titulo;
	}
	
    public Timeline getTimeline() { return timeline; }

	public String toXML() {
		String xml = "<filme titulo=\"" + this.getTitulo() + "\"/>\n";
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
        private Timeline timeline ;
        private String diretor = "Desconhecido";

              
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
        
        public Builder withDiretor(String diretor) {
            if (diretor != null && !diretor.trim().isEmpty()) {
                this.diretor = diretor;
            }
            return this;
        }
        
        public Filme build() {
        	 if (this.timeline == null) {
                 this.timeline = new Timeline(0);
             }
            return new Filme(this);
        }
    }

	@Override
	public String getTipo() {
		 return "FILME";
	}

	@Override
	public String getDescricao() {
		return String.format(" %s - R$ %.2f | %d min", 
                titulo, preco, getDurationInSeconds() / 60);
	}

	

	 	
}