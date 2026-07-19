package br.edu.ifba.inf011.thirdPart;

import java.util.Random;

//--- CLASSE PROPRIETÁRIA DE BAIXO NÍVEL (Adaptee) ---
public class HDDBinaryReader {

	protected byte[] rawBuffer; 
    protected Integer cachedDuration = -1;
    protected String path;
	
    /* 
     * Inicializa um HDDBinaryReader com o nome do arquivo em disco e armazena em path. 
     * Chama o método loadHeaderMetadata para carregar os metadados do arquivo (inclusive tamanho)
     * Os bytes do arquivo não são carregados. 
     */
	public HDDBinaryReader(String path){
		this.path = path;
		this.cachedDuration =  this.loadHeaderMetadata(path);
		this.rawBuffer = null;
	}
	
    /* 
     * Carrega os metadados do arquivo e armazena o tamanho em cachedDuration
     */	
    protected Integer loadHeaderMetadata(String path) {
        System.out.println("[HDDBinaryReader] Lendo estritamente o cabeçalho do arquivo: " + path);
        this.cachedDuration = new Random().nextInt(60, 1800); 
        return this.cachedDuration;
    }
    
    /* 
     * Carrega os bytes com os dados do arquivo e armazena em rawBuffer
     */	
    protected void loadPhysicalSectors() {
        System.out.println("[HDDBinaryReader] CRÍTICO: Alocando buffer " + this.cachedDuration * 1024 * 960 + "Kb e decodificando frames de: " + path);
        this.rawBuffer = new byte[1];
    }    
    
    /* 
     * Retorna o metadado de duração do arquivo  
     */	
    public Integer getDuration() {
    	return this.cachedDuration;
    }    
    
    /* 
     * O método verifica se os dados já foram carregados para a memória. Caso não tenha sido
     * chama loadPhysicalSectors() para fazer a carga. Em seguida, a cada chamada,
     * faz uma cópia dos dados em rawBuffer e devolve para quem solicitou.  
     *   
     */	    
    public byte[] getRawData() {
    	if(this.rawBuffer == null)
    		this.loadPhysicalSectors();
        System.out.println("[HDDBinaryReader] CRÍTICO: Alocando cópia do buffer para devolver para aplicações do usuário " + this.cachedDuration * 1024 * 960 + "Kb e decodificando frames de: " + path);
    	return new byte[1]; 
    }
    
}
