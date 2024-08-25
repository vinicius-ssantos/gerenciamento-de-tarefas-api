package com.viniciussantos.enums;

public enum Status {
    PENDENDTE("PENDENDTE"),
    EM_PROGRESSO("EM PROGRESSO"),
    COMPLETO("COMPLETO");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status.toLowerCase();
    }


}