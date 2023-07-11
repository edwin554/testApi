package org.ReqRest.Task;

import com.devskiller.jfairy.producer.person.Person;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.ReqRest.Models.CrearEmpleadoModels;
import org.ReqRest.Utils.GeneradorData;

public class CrearEmpleadoRandom {
    private CrearEmpleadoRandom() {
    }

    public static Performable dataEmpleado() {
        return Task.where("crear empleado", actor -> {
            Person person = GeneradorData.getPerson();
            CrearEmpleadoModels crearEmpleadosModels = CrearEmpleadoModels.builder()
                    .name(person.getFirstName())
                    .company(person.getLastName()).build();
           // System.out.println("crearEmpleadosModels = " + crearEmpleadosModels);

             Gson gson = new Gson();
             actor.remember("createBody", gson.toJson(crearEmpleadosModels));
             actor.remember("createObject", crearEmpleadosModels);
        });
    }
}
