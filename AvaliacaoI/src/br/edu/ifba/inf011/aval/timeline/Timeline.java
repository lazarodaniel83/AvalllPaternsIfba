package br.edu.ifba.inf011.aval.timeline;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.aval.Forkable;
import br.edu.ifba.inf011.aval.canva.Canva;
import br.edu.ifba.inf011.aval.encoder.Encoder;
import br.edu.ifba.inf011.aval.renderer.Renderer;
import br.edu.ifba.inf011.aval.track.AudioTrack;
import br.edu.ifba.inf011.aval.track.SubTitleTrack;
import br.edu.ifba.inf011.aval.track.VideoTrack;


public class Timeline implements Forkable{
	
    private Canva canvas; 
    private Renderer renderer; 
    private Encoder encoder;
    private List<VideoTrack> videoTracks = new ArrayList<VideoTrack>();
    private List<AudioTrack> audioTracks = new ArrayList<AudioTrack>();
    private List<SubTitleTrack> subtitleTracks = new ArrayList<SubTitleTrack>();

    protected Timeline() {}

    protected void setCanvas(Canva canvas) {
    	this.canvas = canvas; 
    }
    protected void setRenderer(Renderer renderer) {
    	this.renderer = renderer; 
    }
    protected void setEncoder(Encoder encoder) {
    	this.encoder = encoder; 
    }
    public void addVideoTrack(VideoTrack track) {
    	this.videoTracks.add(track); 
    }
    public void addAudioTrack(AudioTrack track) {
    	this.audioTracks.add(track); 
    }
    public void addSubTitleTrack(SubTitleTrack track) {
    	this.subtitleTracks.add(track); 
    }
    
    public List<SubTitleTrack> getSubtitleTracks() {
    	return subtitleTracks; 
    }
    
    public Timeline fork() {
    	Timeline fork = new Timeline();
    	fork.canvas = this.canvas;
        fork.renderer = fork.renderer;
        fork.encoder = fork.encoder;
        fork.videoTracks = new ArrayList<>(this.videoTracks);
        fork.audioTracks = new ArrayList<>(this.audioTracks);
        fork.subtitleTracks = new ArrayList<>();
        for (SubTitleTrack track : this.subtitleTracks)
            fork.subtitleTracks.add(track.fork());
        return fork;
    }    
    
}