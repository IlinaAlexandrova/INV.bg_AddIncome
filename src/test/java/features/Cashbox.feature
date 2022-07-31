@test

Feature: Add income/expense with valid mandatory fields on https://inv.bg/

  Background:
    Given User should be login
    When I go to Cashbox page
    Then Cashbox page is opened

  Scenario Outline: Add new income
    When I click on NewIncome button
    Then New income page is opened with checked radio button Income
    And I fill "<incomesValue>" and "<incomesReason>"
    And I click on InsertIncome button
    Then "Информацията е добавена успешно." massage is displayed
    And I delete the items

    Examples:
      | incomesValue | incomesReason                   |  |
      | 20000        | Печалба от продажба на артикули |  |
      | -300         | Печалба от наеми                |  |
      | 1500lv       | Продажба на ДМА                 |  |
      | 6000         | Продажба на мебели              |  |