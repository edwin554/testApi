package org.ReqRest.Task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.ReqRest.Integrations.Api;

public class Obtener {
    public static Performable listarUsuarios() {
        return Task.where(Api.getParametros("/users","pages","2"));
    }
}
