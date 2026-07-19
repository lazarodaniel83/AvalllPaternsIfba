package br.edu.ifba.ads.inf011.criacional.fm;

public class Client {
	
	public void run() {
		Application app = new GenericCreator<MyDocument>(MyDocument::new);
		app.anOperation();
	}
	
	
	public static void main(String[] args) {
		new Client().run();
	}

}
