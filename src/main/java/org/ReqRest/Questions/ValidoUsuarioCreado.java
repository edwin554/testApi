package org.ReqRest.Questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.ReqRest.Models.CrearEmpleadoModels;
import org.ReqRest.Task.CrearEmpleadoRandom;

import static org.hamcrest.Matchers.equalTo;


public class ValidoUsuarioCreado {
    public static ResponseConsequence ValidoUsuarioCreado() {
        CrearEmpleadoModels UsuarioCreado = OnStage.theActorInTheSpotlight().recall("createObject");
        System.out.println("UsuarioCreado.getName() = " + UsuarioCreado.getName());
        System.out.println("UsuarioCreado = " + UsuarioCreado.getCompany());
        SerenityRest.lastResponse().body().prettyPrint();
        return ResponseConsequence.seeThatResponse(response -> response
                .body("name", equalTo(UsuarioCreado.getName()))
                .body("company", equalTo(UsuarioCreado.getCompany()))

        );


    }
}