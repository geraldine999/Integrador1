package com.company;

public enum TipoDeUso {
    PARTICULAR(1),
    PROFESIONAL(2),
    PARTICULAR_DE_USO_PROFESIONAL(3);

    private int numeroId;

    TipoDeUso(int numeroId) {
        this.numeroId = numeroId;
    }

    public int getNumeroId() {
        return numeroId;
    }
}
