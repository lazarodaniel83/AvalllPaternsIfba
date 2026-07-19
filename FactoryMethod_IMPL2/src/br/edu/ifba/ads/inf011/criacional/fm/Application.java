package br.edu.ifba.ads.inf011.criacional.fm;

public abstract class Application {
 
 public abstract Document createDocument();
 
 public void anOperation() {
	 Document document = this.createDocument();
	 document.open();
 }
 
 
}
