package br.edu.ifba.inf011.aval;

import br.edu.ifba.inf011.aval.timeline.CinemaTimelineBuilder;
import br.edu.ifba.inf011.aval.timeline.Timeline;
import br.edu.ifba.inf011.aval.timeline.TimelineBuilder;
import br.edu.ifba.inf011.aval.track.SubTitleTrack;
import br.edu.ifba.inf011.aval.track.VideoTrack;

public class Client {
	
	public void runQuestaoI() {
		TimelineBuilder builder = new CinemaTimelineBuilder();

        Timeline cinemaTimeline = builder.reset()
                                         .addVideo("MainShot_4K.mov")
                                         .addAudio("Soundtrack_Master.wav")
                                         .addSubtitle("legendas_pt.stt", "Português")
                                         .build();
        System.out.println("Questão I: Cinema Timeline construída com sucesso via Builder.");
        
        
	}
	
	public void runQuestaoII() {
		TimelineBuilder builder = new CinemaTimelineBuilder();

        Timeline varianteA = builder.reset()
                                         .addVideo("MainShot_4K.mov")
                                         .addAudio("Soundtrack_Master.wav")
                                         .addSubtitle("legendas_pt.stt", "Português")
                                         .build();
        
        varianteA.addVideoTrack(new VideoTrack("Video_Principal.mov"));
        varianteA.addSubTitleTrack(new SubTitleTrack("legendas_pt.stt", "Português"));

        System.out.println("=== ESTADO ORIGINAL (Variante A) ===");
        System.out.println("Legenda A: " + varianteA.getSubtitleTracks().get(0).getStreamName());

        Timeline varianteB = varianteA.fork();

        SubTitleTrack legendaB = varianteB.getSubtitleTracks().get(0);
        legendaB.setStreamName("sous-titres.stt");
        legendaB.setIdioma("Francês");

        System.out.println("\n=== APÓS O FORK E ALTERAÇÃO (Garantia de Independência) ===");
        System.out.println("Legenda na Variante A (Inalterada): " + varianteA.getSubtitleTracks().get(0).getStreamName());
        System.out.println("Legenda na Variante B (Modificada): " + varianteB.getSubtitleTracks().get(0).getStreamName());
    }
	
	
	public void run() {
		System.out.println("\n=== Questão I ===");
		this.runQuestaoI();
		System.out.println("\n=== Questão II ===");
		this.runQuestaoII();
	}
	public static void main(String[] args) {
		new Client().run();
	}

}
