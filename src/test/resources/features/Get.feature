Feature: obtener informacion de usuarios
  @Apis
  Scenario: obtenemos la informacion de los usuarios registrados
    Given quiero listar la informacion de usuarios
    Then verifico que se listen los usuarios