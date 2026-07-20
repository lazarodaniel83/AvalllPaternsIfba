package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf011.model.playlist.PlaylistItem;
import br.edu.ifba.inf011.model.playlist.PlaylistVisitor;

public class Pacote implements PlaylistItem,Product{ 

		protected String titulo;
	    private List<Product> produtos = new ArrayList<>();
	    private Double desconto;
	    private String tipoPacote;

	    
	    public Pacote(String titulo) {
	    	this.titulo = titulo;
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
	    };
	    public Pacote(String titulo, Double desconto) {
	        if (titulo == null || titulo.trim().isEmpty()) {
	            throw new IllegalArgumentException("Nome do pacote é obrigatório");
	        }
	        if (desconto == null || desconto < 0 || desconto > 100) {
	            throw new IllegalArgumentException("Desconto deve ser entre 0 e 100");
	        }
	        this.titulo = titulo;
	        this.desconto = desconto;
	        this.tipoPacote = "BUNDLE";
	    }
	    
	    public Pacote(String nome, Double desconto, String tipoPacote) {
	        this(nome, desconto);
	        if (tipoPacote != null && !tipoPacote.trim().isEmpty()) {
	            this.tipoPacote = tipoPacote;
	        }
	    }
	       
	    public Pacote addProduto(Product produto) {
	        if (produto != null) {
	            this.produtos.add(produto);
	        }
	        return this;

	    }
	  
	    
	    public Pacote addProdutos(Product... produtoArray) {
	        if (produtoArray != null) {
	            Collections.addAll(this.produtos, produtoArray);
	        }
	        return this;
	    }
	    
	    public Pacote addFilme(Filme filme) {
	        if (filme != null) {
	            this.produtos.add(filme);
	        }
	        return this;
	    }
	    
	    public Pacote addEpisodio(Episodio episodio) {
	        if (episodio != null) {
	            this.produtos.add(episodio);
	        }
	        return this;
	    }
	    
	    public Pacote addSerie(Serie serie) {
	        if (serie != null) {
	            this.produtos.add(serie);
	        }
	        return this;
	    }
	    
	    public Pacote addPacote(Pacote pacote) {
	        if (pacote != null) {
	            this.produtos.add(pacote);
	        }
	        return this;
	    }
	    
	    public Pacote removeProduto(Product produto) {
	        this.produtos.remove(produto);
	        return this;
	    }
	    
	    public List<Product> getProdutos() {
	        return Collections.unmodifiableList(this.produtos);
	    }
	    
	    public Integer getTotalProdutos() {
	        return this.produtos.size();
	    }
	    
	    public String getTitulo() {
	    	return this.titulo;
	    }
	        
	    @Override
	    public Double getPreco() {
	    	if (this.produtos.isEmpty()) {
	            return 0.0;
	        }
	        
	        Double total = this.produtos.stream()
	                .mapToDouble(Product::getPreco)
	                .sum();
	        
	        Double descontoEfetivo = this.desconto != null ? this.desconto : 0.0;
	        if (this.produtos.size() >= 10) descontoEfetivo += 5;
	        if (this.produtos.size() >= 20) descontoEfetivo += 10;
	        
	        return total * (1 - Math.min(descontoEfetivo, 100) / 100);
	    }    
	        

		public Double getBandwidth(Double bandPerSecond) {
			return this.getDuracao() * bandPerSecond;
		}

 
		@Override
		public Integer getDurationInSeconds() {
			return this.produtos.stream().mapToInt(Product::getDurationInSeconds).sum();
		}



		@Override
		public void render(Integer init, Integer duration) {
			 for (Product p : this.produtos) {
		            p.render(init, duration);
		        }
			
		}

		@Override
		public String getTipo() {
			return "PACOTE";
		}

		@Override
		public String getDescricao() {
			 StringBuilder sb = new StringBuilder();
		        sb.append(String.format(" %s [%s] - %d itens - %.0f%% OFF%n", 
		                this.titulo, 
		                this.tipoPacote, 
		                this.produtos.size(), 
		                this.desconto != null ? this.desconto : 0));
		        sb.append("  Contém:%n");
		        
		        int show = Math.min(this.produtos.size(), 5);
		        for (int i = 0; i < show; i++) {
		            Product p = this.produtos.get(i);
		            sb.append("    • ").append(p.getTitulo())
		              .append(" (R$ ").append(String.format("%.2f", p.getPreco()))
		              .append(") - ").append(p.getTipo())
		              .append("%n");
		        }
		        if (this.produtos.size() > 5) {
		            sb.append("    • ... e mais ").append(this.produtos.size() - 5).append(" itens%n");
		        }
		        sb.append(String.format("  Total: R$ %.2f | %d min", 
		                getPreco(), 
		                getDurationInSeconds() / 60));
		        return sb.toString();
		}
		@Override
		public Integer getDuracao() {
			return this.produtos.stream()
	                .mapToInt(Product::getDurationInSeconds)
	                .sum();
		}
	
		
		@Override
		public void accept(PlaylistVisitor visitor) {
			 visitor.visit(this);
		        for (Product produto : this.produtos) {
		            if (produto instanceof PlaylistItem) {
		                ((PlaylistItem) produto).accept(visitor);
		            }
		        }
			
		}
		@Override
		public String getNome() {
			// TODO Auto-generated method stub
			return null;
		}    

	}