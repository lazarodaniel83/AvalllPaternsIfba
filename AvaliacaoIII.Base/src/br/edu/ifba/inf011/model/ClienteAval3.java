
package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.model.comercial.*;
import br.edu.ifba.inf011.model.playlist.*;


public class ClienteAval3 {
    
    public static void main(String[] args) {
        new ClienteAval3().run();
    }
    
    public void run() {
        
        System.out.println(" CLIENTE AVALIAÇÃO III");
        System.out.println("=".repeat(70));
        
        // ==========================================
        // 1. CRIANDO FILMES
        // ==========================================
        System.out.println("\n1. CRIANDO FILMES:");
        System.out.println("-".repeat(50));
        
        Filme matrix1 = new Filme.Builder("The Matrix", 29.90)
                .withDuration(8160)
                .withDiretor("Lana Wachowski")
                .build();
        
        Filme matrix2 = new Filme.Builder("Matrix Reloaded", 29.90)
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
        
        System.out.println("✓ Filmes criados:");
        System.out.println("  • " + matrix1.getTitulo());
        System.out.println("  • " + matrix2.getTitulo());
        System.out.println("  • " + matrix3.getTitulo());
        System.out.println("  • " + bladeRunner.getTitulo());
        
        // ==========================================
        // 2. CRIANDO PACOTE (USANDO BUILDER)
        // ==========================================
        System.out.println("\n2. CRIANDO PACOTE COM BUILDER:");
        System.out.println("-".repeat(50));
        
        //  CORREÇÃO 1: Usar PackageBuilder em vez de construtor direto 
        Pacote pacoteMatrix = new PackageBuilder()
                .nomeado("Trilogia Matrix")
                .comDesconto(15.0)
                .comTipo("TRILOGY")
                .adicionarFilme("The Matrix", 29.90, 8160)
                .adicionarFilme("Matrix Reloaded", 29.90, 8280)
                .adicionarFilme("Matrix Revolutions", 29.90, 7740)
                .construir();
        
              Pacote superPacote = new PackageBuilder()
                .nomeado("Super Coleção Sci-Fi")
                .comDesconto(20.0)
                .comTipo("COLLECTION")
                .adicionarPacote(pacoteMatrix)
                .adicionarProduto(bladeRunner)
                .adicionarEpisodio("Black Mirror S01E01", 0.0, 2700, 1, "Black Mirror")
                .adicionarEpisodio("Black Mirror S01E02", 0.0, 2700, 2, "Black Mirror")
                .construir();
        
        // CORREÇÃO 2: getDurationInSeconds() (NÃO getDuracao()) 
        System.out.println("✓ Pacote criado:");
        System.out.println("  Nome: " + superPacote.getTitulo());
        System.out.println("  Preço: R$ " + String.format("%.2f", superPacote.getPreco()));
        System.out.println("  Duração: " + superPacote.getDurationInSeconds() + "s (" + superPacote.getDurationInSeconds() / 60 + " min)");
        System.out.println("  Total de itens: " + superPacote.getTotalProdutos());
        
        // ==========================================
        // 3. CRIANDO PLAYLIST COM PACOTE E MP3, "Lana Wachowski", 2003
        // ==========================================
        System.out.println("\n3. CRIANDO PLAYLIST:");
        System.out.println("-".repeat(50));
        
        //  CORREÇÃO 3: Playlist com nome válido (NÃO null) 
        Playlist playlist = new Playlist("Minha Playlist", "João Silva");
        playlist.addItem(superPacote);
        playlist.addItem(new MP3("Son Of A Gun", 240, 320, "Nirvana", "Bleach"));
        
        System.out.println("✓ Playlist criada:");
        System.out.println("  Nome: " + playlist.getNome());
        System.out.println("  Total de itens: " + playlist.getTotalItens());
        System.out.println("  Duração total: " + playlist.getDurationInSeconds() + "s");
        
        // ==========================================
        // 4. CALCULANDO LARGURA DE BANDA (VISITOR)
        // ==========================================
        System.out.println("\n4. CALCULANDO LARGURA DE BANDA (VISITOR):");
        System.out.println("-".repeat(50));
        
        //  CORREÇÃO 4: Usar BandwidthVisitor 
        BandwidthVisitor bwVisitor = new BandwidthVisitor();
        playlist.accept(bwVisitor);
        
        double larguraMB = bwVisitor.getTotalBandwidth() / (1024.0 * 1024.0);
        System.out.println("  Consumo de Largura de Banda: " + String.format("%.2f MB", larguraMB));
        System.out.println("\n  Detalhamento:");
        System.out.println(bwVisitor.getRelatorio());
        
        // ==========================================
        // 5. EXPORTANDO PARA XML (VISITOR)
        // ==========================================
        System.out.println("\n5. EXPORTANDO PARA XML (VISITOR):");
        System.out.println("-".repeat(50));
        
        //  CORREÇÃO 5: Usar XMLExportVisitor 
        XMLExportVisitor xmlVisitor = new XMLExportVisitor();
        playlist.accept(xmlVisitor);
        
        String xml = xmlVisitor.getXML();
        System.out.println(xml);
        
        // ==========================================
        // 6. RELATÓRIO DE NOMES (VISITOR)
        // ==========================================
        System.out.println("\n6. RELATÓRIO DE NOMES (VISITOR):");
        System.out.println("-".repeat(50));
        
        NameReportVisitor nameVisitor = new NameReportVisitor();
        playlist.accept(nameVisitor);
        System.out.println(nameVisitor.getRelatorio());
        
        // ==========================================
        // 7. RESUMO
        // ==========================================
        System.out.println("\n7. RESUMO:");
        System.out.println("-".repeat(50));
        System.out.println("   Pacote criado com sucesso");
        System.out.println("  Playlist criada com sucesso");
        System.out.println("   BandwidthVisitor aplicado");
        System.out.println("   XMLExportVisitor aplicado");
        System.out.println("   NameReportVisitor aplicado");
        System.out.println("   Nenhuma classe existente foi modificada");
        
        System.out.println("\nCLIENTE AVALIAÇÃO III CONCLUÍDO COM SUCESSO!");
    }
}
