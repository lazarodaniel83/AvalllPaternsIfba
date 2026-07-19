package br.edu.ifba.ads.inf011.criacional.fm;

import java.util.function.Supplier;

public class GenericCreator <T extends Document> extends Application {
	
    private Supplier<T> construtor;

    public GenericCreator(Supplier<T> construtor) {
        this.construtor = construtor;
    }

    @Override
    public Document createDocument() {
        return construtor.get(); 
    }
}