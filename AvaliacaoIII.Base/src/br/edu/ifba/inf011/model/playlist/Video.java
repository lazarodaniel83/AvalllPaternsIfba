package br.edu.ifba.inf011.model.playlist;

public class Video implements PlaylistItem {
	
	    private String nome;
	    private Integer duracao;
	    private String resolucao;
	    private Double bitrate;
	    private String formato;

	    public Video(String nome, Integer duracao, String resolucao, Double bitrate) {
	        this.nome = nome;
	        this.duracao = duracao;
	        this.resolucao = resolucao;
	        this.bitrate = bitrate;
	        this.formato = "MP4";
	    }
	    
	    
	    public Video(String nome, Integer duracao, String resolucao, Double bitrate, String formato) {
	        this.nome = nome;
	        this.duracao = duracao;
	        this.resolucao = resolucao;
	        this.bitrate = bitrate;
	        this.formato = formato;
	    }
     
    
    public String getNome() {
    	return this.nome;
    }
    
    @Override
    public String getTipo() { return "VIDEO"; }
    
    public String getResolucao() { return resolucao; }
    public Double getBitrate() { return bitrate; }
    public String getFormato() { return formato; }
    
    public Long getTamanhoArquivo() {
        return (long)((bitrate * duracao) / 8);
    }


	@Override
	public Integer getDurationInSeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(PlaylistVisitor visitor) {
		visitor.visit(this);	
	}

	@Override
	public void render(Integer init, Integer duration) {
		// TODO Auto-generated method stub
		
	}


}
