package org.ReqRest.Integrations;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.ReqRest.Questions.CheckResponse;
import org.junit.runner.Request;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Api {
    public static Performable getParametros(String path, String nombreParametro, String valorParametro) {
        return Task.where(
                Get.resource(path).with(request -> request.queryParams(nombreParametro,valorParametro))
        );
    }
    public static Performable createEmployee() {
        return Task.where("Dummy Create Employee Rest Service", actor -> {
            actor.attemptsTo(Post.to("/users")
                    .with(request -> request.body(theActorInTheSpotlight().recall("createBody").toString())));
       //     actor.attemptsTo(Check.whether(CheckResponse.statusCodeResponse(201)).otherwise(createEmployee()));


        });
    }
    public static Performable ActualizarUsuario(DataTable data) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String idUser = String.valueOf(values.get(0).get("EmpleadoId"));
        return Task.where("Actualiza la data de los trabajadores", actor -> {
            actor.attemptsTo(Put.to("/users/{ids}").with(request -> request.pathParam("ids",idUser))
                    .with(request -> request.body(OnStage.theActorInTheSpotlight().recall("createBody").toString())));
        });
    }

    public static Performable EliminarUsuario(int empleado){
        return Task.where("elimina un empleado", actor -> {
            actor.attemptsTo(Delete.from("/users/{id}")
                    .with(Request -> Request.pathParam("id", empleado)));
            /*actor.attemptsTo(Check.whether(CheckResponse.statusCodeResponse(200))
                    .otherwise(EliminarUsuario(empleado)));
            actor.remember("deleteEmpleadoId",empleado);*/

                }

        );

    }
    public static Performable obtenerEmpleado(DataTable data) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String validarID = String.valueOf(values.get(0).get("Id"));
        String Name = String.valueOf(values.get(0).get("FirstName"));

        return Task.where("el servicio obtener empleado", actor -> {
            actor.attemptsTo(Get.resource("/users/{Id}").
                    with(request -> request.pathParam("Id",validarID)));

                actor.remember("IdUser",validarID);
                actor.remember("User",Name);
        });
    }
}
