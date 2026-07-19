package br.edu.ifba.ads.inf011.criacional.fm;

public abstract class Application {
 
 protected abstract Class<? extends Document> getClasseDocumento();

 public Document createDocument() {
     try {
         Class<? extends Document> classe = getClasseDocumento();
         return classe.getDeclaredConstructor().newInstance();
     } catch (Exception e) {
         throw new RuntimeException("Erro ao instanciar o documento dinamicamente", e);
     }
 }
 
 public void anOperation() {
	 Document document = this.createDocument();
	 document.open();
 }
 
 
}
