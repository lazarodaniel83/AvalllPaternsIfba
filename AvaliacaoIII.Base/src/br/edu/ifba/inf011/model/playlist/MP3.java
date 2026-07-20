package br.edu.ifba.inf011.model.playlist;

public class MP3 implements PlaylistItem {
	private String nome;
    private Integer duracao;
    private Integer bitrate;
    private String artista;
    private String album;

    public MP3(String nome, Integer duracao, Integer bitrate, String artista, String album) {
        this.nome = nome;
        this.duracao = duracao;
        this.bitrate = bitrate;
        this.artista = artista;
        this.album = album;
    }
    
    
  

    public String getNome() {
    	return this.nome;
    }
    
    @Override
    public Integer getDurationInSeconds() { return duracao; }

	
	@Override
	public void accept(PlaylistVisitor visitor) {
		 visitor.visit(this);
		
	}


	 @Override
	    public void render(Integer init, Integer duration) {
	        System.out.printf("[MP3] >> Reproduzindo %s do segundo %d ao %d%n", 
	                nome, init, init + duration);
	    }


	@Override
	public String getTipo() {
		 return "MP3";
	}
	
	public Integer getBitrate() { return bitrate; }
    public String getArtista() { return artista; }
    public String getAlbum() { return album; }
    
    public Long getTamanhoArquivo() {
        return (duracao.longValue() * bitrate) / 8;
    }
}
