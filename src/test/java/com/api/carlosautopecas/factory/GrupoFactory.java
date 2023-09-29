package com.api.carlosautopecas.factory;

import com.api.carlosautopecas.entity.GrupoEntity;
import com.api.carlosautopecas.output.GrupoOutput;

public class GrupoFactory {

    public static GrupoOutput getGrupoOutput(){

        GrupoOutput grupoOutput = new GrupoOutput();
        grupoOutput.setNomeGrupo("Freios");

        return grupoOutput;

    }

    public static GrupoEntity getGrupoEntity(){

        GrupoEntity grupoEntity = GrupoEntity.builder()
                .idGrupo(1)
                .nomeGrupo(("Freios"))
                .build();

        return grupoEntity;

    }
}
