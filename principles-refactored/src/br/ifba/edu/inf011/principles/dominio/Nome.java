package br.ifba.edu.inf011.principles.dominio;

public record Nome(String nome) {

    public static final String DOMINIO = "domain.com";
    private static final String[] PREPOSICOES = { "de", "da", "do", "das", "dos", "e" };

    public String getNomeAbreviado() {
        if (this.nome == null || this.nome.trim().isEmpty())
            return this.nome;

        String[] partes = this.nome.trim().split("\\s+");
        if (partes.length <= 1)
            return this.nome;
        StringBuilder abreviado = new StringBuilder();
        abreviado.append(partes[0]);

        for (int i = 1; i < partes.length - 1; i++) {
            String parte = partes[i];
            String pLower = parte.toLowerCase();
            if (!java.util.Arrays.asList(PREPOSICOES).contains(pLower))
                abreviado.append(" ").append(parte.substring(0, 1).toUpperCase()).append(".");
        }
        abreviado.append(" ").append(partes[partes.length - 1]);
        return abreviado.toString();
    }

    public String getMail(String dominio) {
        if (this.nome == null || this.nome.trim().isEmpty())
            return "";

        String[] partes = this.nome.trim().split("\\s+");
        if (partes.length <= 1)
            return partes[0].toLowerCase() + "@" + dominio;

        String primeiroNome = partes[0].toLowerCase();
        String ultimoNome = partes[partes.length - 1].toLowerCase();

        return primeiroNome + "." + ultimoNome + "@" + dominio;
    }

    public String getMail() {
        return this.getMail(Nome.DOMINIO);
    }

    @Override
    public String toString() {
        return this.nome();
    }
}
