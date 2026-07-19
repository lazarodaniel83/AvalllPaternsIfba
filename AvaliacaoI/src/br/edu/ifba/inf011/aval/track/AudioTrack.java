package br.edu.ifba.inf011.aval.track;

public class AudioTrack{
    private String streamName;

    public AudioTrack(String streamName) {
        this.streamName = streamName;
    }

    public String getStreamName() {
        return this.streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

}
