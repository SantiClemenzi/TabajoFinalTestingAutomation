Feature: Flujo completo buscar empleado
  Como usuario de OrangeHRM Quiero poder buscar un
  empleado por su nombre.

#  Scenario 1 Login
  Scenario: Loguearse con exito
    Given  Estoy en el login de la pagina OrangeHRM
    When Ingreso el usuario Admin
    And Ingreso la password admin123
    And Hago click en login
    Then Deberia ingresar al dashboard de la app

#    Scenario 2 ir a PIM
Scenario: Buscar Empleado
  Given Realizo el login exitosamente
  When Me encuentro en el dashboard de la aplicacion
  And Hago click en Pim
  And Clickeo en filtro "nombre empleado"
  And Tipeo el nombre a buscar
  And Filtro por nombre
  Then la pagina me deberia mostrar los empleados por nombre filtrado

#  Scenario 3 Flujo Completo
  Scenario: Flujo Completo
    Given Realizo el login exitosamente
    When Me encuentro en el dashboard de la aplicacion
    And Hago click en Pim
    And Clickeo en filtro "nombre empleado"
    And Tipeo el nombre a buscar
    And Filtro por nombre
    And La pagina me  muestra los empleados por nombre filtrado
    And Clickeo en logout
    Then La pagina me deberia redirigir al login
