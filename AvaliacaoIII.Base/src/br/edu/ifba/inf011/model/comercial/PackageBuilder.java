package br.edu.ifba.inf011.model.comercial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackageBuilder {
	private String titulo;
    private Double desconto = 0.0;
    private String tipoPacote = "BUNDLE";
    private List<Product> produtos = new ArrayList<>();

    public PackageBuilder nomeado(String titulo) {
        this.titulo = titulo;
        return this;
    }
    
    
    
    
    public PackageBuilder comDesconto(Double desconto) {
        this.desconto = desconto != null ? Math.max(0.0, Math.min(100.0, desconto)) : 0.0;
        return this;
    }
    
    public PackageBuilder comTipo(String tipo) {
        if (tipo != null && !tipo.trim().isEmpty()) { this.tipoPacote = tipo; }
        return this;
    }
    
    public PackageBuilder adicionarFilme(String titulo, Double preco) {
        produtos.add(new Filme.Builder(titulo, preco).build());
        return this;
    }
    
   
    
    public PackageBuilder adicionarFilme(String titulo, Double preco, Integer duracao) {
         produtos.add(new Filme.Builder(titulo, preco)
                .withDuration(duracao)
                .build());
        return this;
    }
    
    public PackageBuilder adicionarEpisodio(String titulo, Double preco, Integer numero, Integer temporada, String serie) {
        produtos.add(new Episodio.Builder(titulo, preco)
                .withNumero(numero)
                .withSerieTitulo(serie)
                .build());
        return this;
    }
    
    public PackageBuilder adicionarSerie(String nome, Double precoBase, Integer totalEpisodios) {
        Serie serie = new Serie(nome, precoBase);
        for (int i = 1; i <= totalEpisodios; i++) {
            Episodio ep = new Episodio.Builder("Episódio " + i, precoBase)
                    .withNumero(i)
                    .withSerieTitulo(nome)
                    .build();
            serie.addEpisodio(ep);
        }
        produtos.add(serie);
        return this;
    }
    
    public PackageBuilder adicionarSerie(Serie serie) {
        if (serie != null) { produtos.add(serie); }
        return this;
    }
    
    public PackageBuilder adicionarPacote(Pacote pacote) {
        if (pacote != null) { produtos.add(pacote); }
        return this;
    }
    
    public PackageBuilder adicionarProduto(Product produto) {
        if (produto != null) { produtos.add(produto); }
        return this;
    }
    
    public PackageBuilder adicionarTodos(Product... produtoArray) {
        if (produtoArray != null) { Collections.addAll(produtos, produtoArray); }
        return this;
    }
    
    public Pacote construir() {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalStateException("Nome do pacote é obrigatório");
        }
        Pacote pacote = new Pacote(titulo, desconto, tipoPacote);
        for (Product produto : produtos) {
            pacote.addProduto(produto);
        }
        return pacote;
    }
}
