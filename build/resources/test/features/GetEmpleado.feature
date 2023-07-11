Feature: datos de empleado
  @Apis
  Scenario Outline: obtener datos de un empleado
    Given deseo obtener datos de un empleado con id
    |Id  |FirstName  |
    |<id>|<firstname>|
    Then valido el codigo de status 200
    And Verifico ID
    And Verifico nombre
    Examples:
    |id|firstname|
    |1 |George   |
    |2 |Janet    |