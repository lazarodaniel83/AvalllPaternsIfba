package br.edu.ifba.inf011.model.comercial;

import br.edu.ifba.inf011.avaliacao2.decorator.RenderableContent;

public interface Product extends RenderableContent   {

	String getTitulo();
	Double getPreco();
	Integer getDuracao();
	String getTipo();
	String getDescricao(); 
	
 }
