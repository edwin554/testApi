Feature: actualizar datos de empleados
  @Apis
  Scenario Outline: Actualizar datos empleados
    Given crear usuario con data random
    Given actualizar data de empleados
    |EmpleadoId  |
    |<empleadoId>|
    Then se verifica codigos de respuesta 200
    Examples:
    |empleadoId|
    |1         |
    |2         |
    |3         |