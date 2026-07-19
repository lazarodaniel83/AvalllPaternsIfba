package br.edu.ifba.ads.inf011.criacional.fm;

public class MyApplication extends Application{
	
    @Override
    protected Class<? extends Document> getClasseDocumento() {
        return MyDocument.class; 
    }

}
