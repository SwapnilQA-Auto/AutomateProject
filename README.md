🔹 Hybrid Automation Framework – Key Points
	1.	Framework Type:
	•	Hybrid framework combining BDD (Cucumber), Keyword-driven, and Data-driven approaches.
	2.	Feature Files (BDD Layer):
	•	High-level, human-readable test scenarios in Gherkin syntax.
	•	Example: login scenarios with placeholders for username and password.
	3.	Reusable Actions (Keyword Layer):
	•	Centralized methods for interacting with web elements (click, sendText, waitForVisibility, etc.).
	•	Improves code reuse and maintenance.
	4.	Test Data Management (Data-driven Layer):
	•	Inputs like username, password, and URLs are stored externally (properties file or Excel).
	•	Allows running tests on multiple users or environments without code changes.
	5.	Hooks & Setup:
	•	Launches browser, reads environment, and handles pre/post-test activities.
	•	Automatically takes screenshots on failure.
	6.Logging:
	•	All test steps are logged in a single file.
	•	Sensitive data like passwords are masked for security.
	•	Run start banner added for clarity between multiple executions.
	7.	Wait Strategies:
	•	Supports Implicit, Explicit, Fluent waits, and page/script timeouts for stable execution.
	8.	Usage Tip:
	•	Update QA.properties to configure environment, username, and password before running tests.
	•	Feature files use placeholders; step definitions fetch actual data from properties or external sources.
