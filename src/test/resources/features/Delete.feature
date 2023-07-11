Feature: eliminar empleado
  @Apis
  Scenario: eliminar empleado exitosamente
    Given Eliminar registro de empleado 1
    Then validar codigo de status 204