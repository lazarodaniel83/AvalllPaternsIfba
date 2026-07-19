package br.edu.ifba.inf011.aval.track;

import br.edu.ifba.inf011.aval.Forkable;

public class SubTitleTrack implements Forkable {
    private String streamName;
    private String idioma;

    public SubTitleTrack(String streamName, String idioma) {
        this.streamName = streamName;
        this.idioma = idioma;
    }
    
    public SubTitleTrack(SubTitleTrack fork) {
        this.streamName = fork.streamName;
        this.idioma = fork.idioma;
    }    

    public String getStreamName() {
        return this.streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public SubTitleTrack fork() {
    	return new SubTitleTrack(this);
    }
}