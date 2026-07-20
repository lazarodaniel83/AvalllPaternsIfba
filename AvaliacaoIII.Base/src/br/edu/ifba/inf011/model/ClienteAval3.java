package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.avaliacao1.timeline.builder.CinemaTimelineBuilder;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.Timeline;
import br.edu.ifba.inf011.avaliacao1.timeline.builder.TimelineBuilder;
import br.edu.ifba.inf011.model.comercial.Filme;
import br.edu.ifba.inf011.model.comercial.Pacote;
import br.edu.ifba.inf011.model.playlist.MP3;
import br.edu.ifba.inf011.model.playlist.Playlist;

public class ClienteAval3 {

	public void run() {
		
		System.out.println("🎯 AVALIAÇÃO III - SOLUÇÃO COMPLETA");
        System.out.println("=".repeat(70));
        
        // ==========================================
        // QUESTÃO I - BLACK FRIDAY (COMPOSITE + BUILDER)
        // ==========================================
        System.out.println("\n📌 QUESTÃO I - BLACK FRIDAY");
        System.out.println("-".repeat(50));
        
        // 1. Criando filmes
        Filme matrix1 = new Filme.Builder("The Matrix", 29.90)
                .withDuration(8160)
                .withDiretor("Lana Wachowski")
                .build();
        
        Filme matrix2 = new Filme.Builder("Mat        .withAnoLancamento(1982)rix Reloaded", 29.90)
                .withDuration(8280)
                .withDiretor("Lana Wachowski")
                .build();
        
        Filme matrix3 = new Filme.Builder("Matrix Revolutions", 29.90)
                .withDuration(7740)
                .withDiretor("Lana Wachowski")
                .build();
        
        Filme bladeRunner = new Filme.Builder("Blade Runner", 24.90)
                .withDuration(7020)
                .withDiretor("Ridley Scott")
                .build();
        
        // 2. Criando pacote com Builder (FLUENTE)
        Pacote matrixTrilogy = new PackageBuilder()
                .nomeado("Trilogia Matrix")
                .comDesconto(15.0)
                .comTipo("TRILOGY")
                .adicionarFilme("The Matrix", 29.90, 8160, "Lana Wachowski", 1999)
                .adicionarFilme("Matrix Reloaded", 29.90, 8280, "Lana Wachowski", 2003)
                .adicionarFilme("Matrix Revolutions", 29.90, 7740, "Lana Wachowski", 2003)
                .adicionarFilme("Matrix: O Documentário", 14.90, 3600)
                .construir();
        
        System.out.println("✅ Pacote Matrix criado:");
        System.out.println(matrixTrilogy.getDescricao());
        
        // 3. Criando Super Pacote (ANINHAMENTO)
        Pacote starWarsSaga = new PackageBuilder()
                .nomeado("Star Wars Saga Original")
                .comDesconto(10.0)
                .comTipo("SAGA")
                .adicionarFilme("Star Wars IV", 29.90, 7260, "George Lucas", 1977)
                .adicionarFilme("Star Wars V", 29.90, 7440, "Irvin Kershner", 1980)
                .adicionarFilme("Star Wars VI", 29.90, 7860, "Richard Marquand", 1983)
                .construir();
        
        // ⭐ SUPER PACOTE - COMPOSITE ANINHADO ⭐
        Pacote superPacote = new PackageBuilder()
                .nomeado("Coleção Sci-Fi Master")
                .comDesconto(20.0)
                .comTipo("COLLECTION")
                .adicionarPacote(matrixTrilogy)      // ← PACOTE DENTRO DE PACOTE
                .adicionarPacote(starWarsSaga)       // ← PACOTE DENTRO DE PACOTE
                .adicionarFilme(bladeRunner)
                .adicionarEpisodio("Black Mirror S01E01", 0, 2700, 1, 1, "Black Mirror")
                .adicionarEpisodio("Black Mirror S01E02", 0, 2700, 2, 1, "Black Mirror")
                .construir();
        
        System.out.println("\n⭐ Super Pacote criado:");
        System.out.println(superPacote.getDescricao());
        
        // ==========================================
        // QUESTÃO II - PLAYLISTS (VISITOR)
        // ==========================================
        System.out.println("\n📌 QUESTÃO II - PLAYLISTS (VISITOR)");
        System.out.println("-".repeat(50));
        
        // 1. Criando itens da playlist
        MP3 song1 = new MP3("Imagine", 180, 320, "John Lennon", "Imagine");
        MP3 song2 = new MP3("Bohemian Rhapsody", 360, 320, "Queen", "A Night");
        Video video1 = new Video("Trailer Dune", 120, "1080p", 8.0);
        
        // 2. Criando playlist com pacote
        Playlist playlist = new Playlist("Minhas Favoritas", "João Silva");
        playlist.addItems(song1, song2, video1, superPacote);  // ← PACOTE NA PLAYLIST!
        
        System.out.println("✅ Playlist criada com " + playlist.getTotalItens() + " itens");
        System.out.println("  Duração total: " + playlist.getDurationInSeconds() + "s");
        
        // 3. OPERAÇÃO 1: BandwidthVisitor
        System.out.println("\n📊 OPERAÇÃO 1 - LARGURA DE BANDA:");
        BandwidthVisitor bwVisitor = new BandwidthVisitor();
        playlist.accept(bwVisitor);
        System.out.println(bwVisitor.getRelatorio());
        
        // 4. OPERAÇÃO 2: NameReportVisitor
        System.out.println("\n📋 OPERAÇÃO 2 - RELATÓRIO DE NOMES:");
        NameReportVisitor nameVisitor = new NameReportVisitor();
        playlist.accept(nameVisitor);
        System.out.println(nameVisitor.getRelatorio());
        
        // 5. OPERAÇÃO 3: XMLExportVisitor
        System.out.println("\n📄 OPERAÇÃO 3 - EXPORTAÇÃO XML:");
        XMLExportVisitor xmlVisitor = new XMLExportVisitor();
        playlist.accept(xmlVisitor);
        System.out.println(xmlVisitor.getXML());
        
        // 6. EXTENSIBILIDADE
        System.out.println("\n🔧 EXTENSIBILIDADE:");
        System.out.println("  ✅ Novas operações = novos Visitors");
        System.out.println("  ✅ Nenhuma classe existente é modificada");
        System.out.println("  ✅ Princípio Aberto/Fechado respeitado");
        

	public static void main(String[] args) {
		new ClienteAval3().run();
	}

	
}
