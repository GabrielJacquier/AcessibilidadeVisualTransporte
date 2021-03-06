package com.gabriel.traceacessibilidade.model;

/**
 * Created by gabriel on 06/11/16.
 */

public enum MessageEnum {
    PRESENTATION("Olá. Bem-vindo ao aplicativo Acessibilidade! Nós podemos te informar os horários dos ônibus. Tudo o que você precisa fazer é só perguntar, e eu vou te ajudar!"),
    ASK_NAME_TRANSPORT_PUBLIC("{nomeUsuario}, de qual Ônibus você gostaria de saber o horário?!"),
    RESPONSE_HOUR_PUBLIC_TRANSPORT("O horário previsto para o ônibus {onibus} é de {horarioPontoFinal} no ponto final! E {horarioTerminal} no terminal!"),
    ASK_NAME_USER("Como é seu nome!?"),
    RESPONSE_TIP_TO_USER("Olá {nomeUsuario}! Para saber o horário de um ônibus, diga a palavra. Horário!"),
    THANK_YOU("{nomeUsuario}! Obrigada por usar o Acessibilidade, até logo!!"),
    SORRY_NOT_UNDERSTAND("Desculpe! Não entendi! Você pode repetir, por favor!");

    private String message;
    private PublicTransport publicTransport;
    private String userName = "";

    MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        if(publicTransport != null) {
            message = message.replace("{onibus}", publicTransport.getName());
            message = message.replace("{horarioTerminal}", publicTransport.getHourBusTerminalText());
            message = message.replace("{horarioPontoFinal}", publicTransport.getHourEndPointText());
        }
        message = message.replace("{nomeUsuario}", userName);
        return message;
    }

    public void setPublicTransport(PublicTransport publicTransport) {
        this.publicTransport = publicTransport;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
