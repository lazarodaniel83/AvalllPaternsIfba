package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temporada {

	private Integer numero;
    private List<Episodio> episodios = new ArrayList<>();
    
    public Temporada(Integer numero) {
        if (numero == null || numero <= 0) {
            throw new IllegalArgumentException("Número da temporada deve ser positivo");
        }
        this.numero = numero;
    }
    
    public Temporada addEpisodio(Episodio episodio) {
        if (episodio != null) {
            episodios.add(episodio);
        }
        return this;
    }
    
    public Temporada addEpisodios(Episodio... episodioArray) {
        if (episodioArray != null) {
            Collections.addAll(episodios, episodioArray);
        }
        return this;
    }
    
    public List<Episodio> getEpisodios() {
        return Collections.unmodifiableList(episodios);
    }
    
    public Integer getNumero() {
        return numero;
    }
    
    public Integer getTotalEpisodios() {
        return episodios.size();
    }
    
    public Double getPrecoTotal() {
        return episodios.stream()
                .mapToDouble(Episodio::getPreco)
                .sum();
    }
    
    public Integer getDurationInSeconds() {
        return episodios.stream()
                .mapToInt(Episodio::getDurationInSeconds)
                .sum();
    }
}
