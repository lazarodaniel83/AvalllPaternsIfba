package br.ifba.edu.inf011.principles.dominio;

public enum Estado {
    BA("BA", "BAHIA"),
    SP("SP", "SAO PAULO"),
    RJ("RJ", "RIO DE JANEIRO"),
    MG("MG", "MINAS GERAIS"),
    ES("ES", "ESPIRITO SANTO"),
    PR("PR", "PARANA"),
    SC("SC", "SANTA CATARINA"),
    RS("RS", "RIO GRANDE DO SUL"),
    AM("AM", "AMAZONAS"),
    PA("PA", "PARA"),
    AC("AC", "ACRE"),
    RO("RO", "RONDONIA"),
    RR("RR", "RORAIMA"),
    AP("AP", "AMAPA"),
    TO("TO", "TOCANTINS"),
    MA("MA", "MARANHAO"),
    PI("PI", "PIAUI"),
    CE("CE", "CEARA"),
    RN("RN", "RIO GRANDE DO NORTE"),
    PB("PB", "PARAIBA"),
    PE("PE", "PERNAMBUCO"),
    AL("AL", "ALAGOAS"),
    SE("SE", "SERGIPE"),
    MT("MT", "MATO GROSSO"),
    MS("MS", "MATO GROSSO DO SUL"),
    GO("GO", "GOIAS"),
    DF("DF", "DISTRITO FEDERAL");

    private String sigla;
    private String nome;

    private Estado(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

}
