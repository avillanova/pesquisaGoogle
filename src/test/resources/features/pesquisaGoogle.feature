Feature: Pesquisa Google

  Background: Acessar HomePage
    Given que estou na HomePage do Google

  #Scenario: Pesquisa por idioma
  #  When pesquiso por "Teste"
  #  And eu seleciono o idioma "pt-br"
  #  Then eu espero ver o resultado em "pt-br"

  Scenario Outline: Selecionar intervalo pesonalizado
    When pesquiso por "Teste"
    And seleciono intervalo "<intervalo>"
    Then vejo o resultado com o intervalo "<intervalo>"
    Examples:
    |intervalo            |
    |Na última semana        |
    |1/01/2020 – 1/08/2020|