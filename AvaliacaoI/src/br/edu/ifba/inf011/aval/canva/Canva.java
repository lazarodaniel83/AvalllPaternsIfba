package br.edu.ifba.inf011.aval.canva;

public interface Canva {
    public int getwidth(); 
    public int getHeight(); 
    public String getResolution(); 
    public String getColorspace(); 
    public boolean isHDRSupported();
}
