# 🔹 Hybrid Automation Framework

This framework is designed to automate web applications using **Selenium, Java, and Cucumber**. It combines **BDD, keyword-driven, and data-driven approaches** to provide a flexible and maintainable automation solution.

---

## Key Points

### 1. Framework Type
- Hybrid framework combining **BDD (Cucumber), Keyword-driven, and Data-driven approaches**.

### 2. Feature Files (BDD Layer)
- Human-readable test scenarios written in **Gherkin syntax**.
- Example scenario:

```gherkin
Scenario Outline: Validate login
  Given user on login page
  Then user enter username "<username>"
  Then user enter password "<password>"
  And user click on login button
