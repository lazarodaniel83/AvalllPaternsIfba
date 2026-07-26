# Avaliacao\_3\_2026.1

Aluno: Lazaro Daniel Santos Souza

**Questão I - Black Friday (Composite + Builder)**

**1. Composite **

	O padrão Composite foi escolhido para permitir que objetos individuais (Filme, Episodio) e composições de objetos (Pacote, Serie) sejam tratados de forma uniforme. Isso é essencial para o sistema de pacotes promocionais, onde um pacote pode conter outros pacotes (aninhamento), e o carrinho de compras deve calcular preço e duração de forma transparente, sem distinguir entre um filme avulso e um pacote complexo.

**Participantes:**

Component - Product: Interface comum para todos os produtos, declarando métodos como getPreco(), getDurationInSeconds()

- Leaf – Filme: Representa um filme individual (folha da árvore). Não contém outros produtos

- Leaf – Episodio: Representa um episódio individual (folha da árvore)

- Composite – Serie: Representa uma série que contém múltiplos episódios

- Composite – Pacote:  Classe central. Representa um pacote que pode conter outros produtos (filmes, episódios, séries ou outros pacotes). Implementa a lógica recursiva de cálculo de preço e duração


**Questão II - Playlists (Visitor)**

**Pattern Visitor **

O padrão Visitor foi escolhido para permitir a adição de novas operações analíticas sobre playlists sem modificar as classes existentes (MP3, Video, Pacote). Cada nova operação (largura de banda, relatório de nomes, exportação XML) é implementada como um novo Visitor, respeitando o princípio Aberto/Fechado (OCP) e evitando efeitos colaterais.

**Participantes:**

- Element- PlaylistItem: Interface que declara o método accept(PlaylistVisitor) para todos os itens da playlist

- ConcreteElement – MP3: Implementa accept() delegando ao Visitor. Representa um arquivo MP3 na playlist

- ConcreteElement – Video: Implementa accept() delegando ao Visitor. Representa um vídeo na playlist

- ConcreteElement – Pacote: Implementa accept() delegando ao Visitor e propagando para seus produtos. Permite que pacotes sejam itens de playlist

- ObjectStructure – Playlist: Coleção de elementos (PlaylistItem). Aceita o Visitor e o propaga para todos os seus elementos

- Visitor	PlaylistVisitor	Interface que declara os métodos visit() para cada tipo de elemento (MP3, Video, Pacote)

- ConcreteVisitor – BandwidthVisitor: Calcula a largura de banda total gasta pela playlist. Acumula valores por tipo de elemento

- ConcreteVisitor – NameReportVisitor:  Gera um relatório com os nomes de todos os elementos da playlist, organizados por tipo

- ConcreteVisitor – XMLExportVisitor  Exporta a playlist para o formato XML, incluindo todos os elementos e seus atributos
