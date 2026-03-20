# Parabank Automation Framework

Enterprise-grade Selenium Java + Cucumber + TestNG + API + Hybrid automation framework.


---

## 🚀 Framework Highlights

- UI Automation (Selenium + POM)
- API Automation (Java HTTP Client)
- Hybrid Testing (UI + API validation)
- Parallel Execution (ThreadLocal + TestNG)
- Retry Mechanism for flaky tests
- Extent Reports with screenshots
- Tag-based execution
- GitHub Actions CI integration

---

## 🧪 Local Execution Commands

### 🔹 Smoke Suite
mvn clean test -Denv=qa -Dbrowser=chrome -Dparallel.mode=methods -Dthread.count=5 -Ddata.provider.thread.count=2 -Dretry.enabled=true -Dretry.count=2 -Dtest=com.parabank.automation.runners.SmokeTestRunner

---

### 🔹 Regression Suite
mvn clean test -Denv=qa -Dbrowser=chrome -Dparallel.mode=methods -Dthread.count=5 -Ddata.provider.thread.count=2 -Dretry.enabled=true -Dretry.count=2 -Dtest=com.parabank.automation.runners.RegressionTestRunner

---

### 🔹 UI Suite
mvn clean test -Denv=qa -Dbrowser=chrome -Dparallel.mode=methods -Dthread.count=5 -Ddata.provider.thread.count=2 -Dretry.enabled=true -Dretry.count=2 -Dtest=com.parabank.automation.runners.TestRunner

---

### 🔹 API Suite
mvn clean test -Denv=qa -Dbrowser=chrome -Dparallel.mode=methods -Dthread.count=5 -Ddata.provider.thread.count=2 -Dretry.enabled=true -Dretry.count=2 -Dtest=com.parabank.automation.runners.ApiTestRunner

---

### 🔹 Hybrid Suite
mvn clean test -Denv=qa -Dbrowser=chrome -Dparallel.mode=methods -Dthread.count=5 -Ddata.provider.thread.count=2 -Dretry.enabled=true -Dretry.count=2 -Dtest=com.parabank.automation.runners.HybridTestRunner

---

## 🏷️ Tag-Based Execution

### Run Smoke tests
mvn clean test -Dtest=com.parabank.automation.runners.RegressionTestRunner -Dcucumber.filter.tags="@smoke"

### Run Regression tests
mvn clean test -Dtest=com.parabank.automation.runners.RegressionTestRunner -Dcucumber.filter.tags="@regression"

### Run UI Smoke
mvn clean test -Dtest=com.parabank.automation.runners.TestRunner -Dcucumber.filter.tags="@ui and @smoke"

### Run API Smoke
mvn clean test -Dtest=com.parabank.automation.runners.ApiTestRunner -Dcucumber.filter.tags="@api and @smoke"

### Run Hybrid Smoke
mvn clean test -Dtest=com.parabank.automation.runners.HybridTestRunner -Dcucumber.filter.tags="@hybrid and @smoke"

---

## ⚙️ GitHub Actions CI

### Workflow Location
.github/workflows/ci.yml

### Triggers
- Push
- Pull Request
- Manual (workflow_dispatch)
- Nightly schedule

### Manual Inputs
- suite → smoke / regression / ui / api / hybrid
- env → qa / stage / dev
- browser → chrome / firefox / edge
- retry_count → 0–3

---

## 📊 Reports & Artifacts

Generated locally at:

target/surefire-reports/
test-output/reports/
test-output/logs/
test-output/screenshots/

Also available as downloadable artifacts in GitHub Actions.

---

## 🧠 Recommended Execution Order

1. Smoke
2. UI
3. API
4. Hybrid
5. Regression

---

## ⚠️ Notes

- Hybrid tests are stateful → should run serially
- Use tags for selective execution
- Use regression runner for full validation
- Retry mechanism handles flaky UI issues