# Разбор разных тем в Junit5

## Extensions
В JUnit 5 `Extensions` - это механизм, который позволяет пользователю расширять или настраивать поведение тестового выполнения. Он был введен для замены более старой модели `TestRule` из JUnit 4.

Extensions в JUnit 5 предоставляют более гибкий и модульный способ изменять поведение тестов, чем это было в JUnit 4. Они представляют собой классы, реализующие интерфейс `Extension`, и могут выполнять различные задачи, такие как настройка и очистка ресурсов, изменение среды выполнения тестов и даже внедрение дополнительных аспектов поведения.

Примеры встроенных Extensions в JUnit 5:

1. `@ExtendWith`: Эта аннотация используется для применения конкретных Extensions к тестовым методам или классам.

2. `TestInfoExtension`: Предоставляет информацию о текущем выполняемом тесте, такую как его имя и дополнительные метаданные.

3. `BeforeEachCallback` и `AfterEachCallback`: Extensions, позволяющие выполнять дополнительные действия перед каждым тестом и после каждого теста соответственно.

4. `BeforeAllCallback` и `AfterAllCallback`: Аналогично предыдущим, но выполняются перед всей группой тестов и после выполнения всех тестов в группе.

Пример использования Extension:

```java
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyExtension.class)
class MyTest {
    // Тестовые методы
}

class MyExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Логика, выполняемая перед каждым тестом
    }
}
```

Extensions могут быть также комбинированы и использованы вместе для создания сложных сценариев настройки и выполнения тестов. Это делает JUnit 5 более гибким и удобным для создания современных тестовых структур.

1. **TestInfo Extension**: Этот Extension предоставляет информацию о текущем тесте.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestInfo;

@ExtendWith(TestInfoExtension.class)
class TestInfoExample {

    @Test
    void testWithTestInfo(TestInfo testInfo) {
        System.out.println("Running test: " + testInfo.getDisplayName());
    }
}

class TestInfoExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Test failed: " + throwable.getMessage());
    }
}
```

2. **Custom Extension**: Вы можете создать собственные Extensions для выполнения специфических задач, например, для логирования или настройки тестовой среды.

```java
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Before test: " + context.getTestMethod().orElse(null));
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("After test: " + context.getTestMethod().orElse(null));
    }
}
```

3. **Conditional Test Execution**: С помощью Extension можно создать условия для выполнения тестов, исходя из определенных условий.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ConditionalTestExample {

    @Test
    @ExtendWith(CustomCondition.class)
    void conditionalTest() {
        System.out.println("This test will only run under certain conditions.");
    }
}

class CustomCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        // Add your condition evaluation logic here
        boolean conditionMet = true; // Example condition
        return conditionMet ?
            ConditionEvaluationResult.enabled("Condition met.") :
            ConditionEvaluationResult.disabled("Condition not met.");
    }
}
```

Это всего лишь некоторые примеры использования Extensions в JUnit 5. С их помощью вы можете настроить, расширить и оптимизировать процесс тестирования в соответствии с вашими потребностями.

## Test Lifecycle (жизненный цикл)
В JUnit 5 жизненный цикл (test lifecycle) означает последовательность этапов и событий, которые происходят вокруг выполнения тестовых методов и классов. Это включает в себя все этапы, начиная от инициализации и настройки, запуска тестов, обработки исключений, и заканчивая очисткой и завершением.

В JUnit 5 жизненный цикл включает следующие ключевые этапы:

1. **Инициализация (Initialization)**: В этом этапе создаются экземпляры тестовых классов и готовятся ресурсы, необходимые для выполнения тестов.

2. **Запуск теста (Test Execution)**: Этап, на котором тестовые методы фактически выполняются. В этом этапе выполняются предварительные действия, вызывается код тестового метода, обрабатываются исключения и собираются результаты.

3. **Обработка исключений (Exception Handling)**: Если во время выполнения теста возникают исключения, JUnit 5 предоставляет механизмы для их перехвата и обработки, включая собственные расширения (Extensions) для обработки исключений.

4. **Очистка (Cleanup)**: После завершения тестового метода происходит этап очистки. Здесь могут освобождаться ресурсы, завершаться подготовительные действия и выполняться действия, которые должны быть выполнены даже при неудаче теста.

5. **Завершение (Termination)**: В конце выполнения всех тестовых методов выполняются завершающие действия, такие как закрытие соединений с базой данных или другие действия, которые должны произойти после завершения всех тестов.

Все эти этапы предоставляют возможности для пользовательских настроек и расширений с помощью механизма Extensions, который обсуждался в предыдущем ответе.

Понимание жизненного цикла в JUnit 5 помогает разработчикам контролировать и управлять процессами, связанными с выполнением тестов, и обеспечивать надлежащее управление ресурсами и состоянием системы во время тестирования.

Жизненный цикл в JUnit 5 включает несколько этапов, и вот примеры того, что может происходить на каждом из них:

1. **Инициализация (Initialization)**:
    - Создание экземпляра тестового класса.
    - Инициализация общих ресурсов, необходимых для выполнения тестов.

2. **Запуск теста (Test Execution)**:
    - Вызов методов тестового класса, аннотированных аннотациями `@Test`.
    - Выполнение действий, определенных в методах тестов, например, проверка ожидаемых результатов.

3. **Обработка исключений (Exception Handling)**:
    - Если в методе теста возникает исключение, оно перехватывается.
    - Возможность использовать расширения, такие как `TestExecutionExceptionHandler`, для обработки исключений и выполнения определенных действий.

4. **Очистка (Cleanup)**:
    - Освобождение ресурсов, например, закрытие открытых файлов, соединений с базой данных и т.д.
    - Выполнение действий после завершения тестового метода.

5. **Завершение (Termination)**:
    - Закрытие общих ресурсов, которые были инициализированы на этапе инициализации.
    - Завершение выполнения тестового класса.

Пример кода, демонстрирующего разные этапы жизненного цикла:

```java
import org.junit.jupiter.api.*;

public class LifecycleExample {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test");
    }

    @Test
    void test1() {
        System.out.println("Executing test 1");
    }

    @Test
    void test2() {
        System.out.println("Executing test 2");
        throw new RuntimeException("Test failed");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }
}
```

В этом примере вы можете увидеть, как каждый этап жизненного цикла связан с соответствующими аннотациями (`@BeforeAll`, `@BeforeEach`, `@Test`, `@AfterEach`, `@AfterAll`). Когда вы запустите этот тестовый класс, вы увидите, как выполняются различные этапы для каждого теста.

## Initialization (инициализация)
В контексте JUnit 5, инициализация (initialization) относится к этапу подготовки тестового окружения перед началом выполнения тестов. Этот этап позволяет настроить ресурсы, данные и состояние, необходимые для корректного выполнения тестов.

Инициализация в JUnit 5 может происходить на двух уровнях:

1. **Инициализация тестового класса (Class Initialization)**:
    - Этот этап выполняется перед выполнением всех тестовых методов внутри тестового класса.
    - Обычно используется для инициализации общих ресурсов или данных, которые будут использоваться во всех тестовых методах этого класса.
    - Инициализация класса происходит с использованием аннотации `@BeforeAll`.

2. **Инициализация перед каждым тестом (Method Initialization)**:
    - Этот этап выполняется перед каждым отдельным тестовым методом.
    - Обычно используется для подготовки данных или ресурсов, которые конкретно необходимы для данного тестового метода.
    - Инициализация перед методом теста происходит с использованием аннотации `@BeforeEach`.

Пример инициализации на обоих уровнях:

```java
import org.junit.jupiter.api.*;

public class InitializationExample {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initializing resources before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Initializing resources before each test");
    }

    @Test
    void test1() {
        System.out.println("Executing test 1");
    }

    @Test
    void test2() {
        System.out.println("Executing test 2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Cleaning up after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Cleaning up after all tests");
    }
}
```

В этом примере метод `beforeAll()` инициализирует общие ресурсы перед началом всех тестов, а метод `beforeEach()` выполняет инициализацию перед каждым тестовым методом. Вы можете заметить, что методы `afterEach()` и `afterAll()` используются для очистки и завершения соответствующих этапов.

## Context (контекст)
В JUnit 5, контекст (context) относится к информации и окружению, которые охватывают выполнение тестов. Контекст включает в себя информацию о текущем тесте, его окружении, состоянии и другие детали, которые могут быть полезными при разработке и выполнении тестов.

Контекст предоставляется с использованием объектов типа `ExtensionContext`. Этот объект доступен внутри методов, аннотированных аннотациями, такими как `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll` и другими, позволяя вам получить информацию о текущем выполнении теста и взаимодействовать с ним.

Пример использования контекста:

```java
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ContextExample {

    @BeforeEach
    void beforeEach(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("Preparing to run test: " + testName);
    }

    @Test
    void test1() {
        System.out.println("Executing test 1");
    }

    @Test
    void test2() {
        System.out.println("Executing test 2");
    }

    @AfterEach
    void afterEach(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("Cleaning up after test: " + testName);
    }
}
```

В этом примере методы `beforeEach()` и `afterEach()` принимают аргумент типа `ExtensionContext`, который предоставляет информацию о текущем контексте выполнения теста. С помощью этого объекта вы можете получать доступ к информации о тесте, классе, методе, аннотациям и многому другому.

Использование контекста может быть полезным, например, для логирования, динамического настройки или выполнения дополнительных действий в зависимости от характеристик текущего тестового выполнения.
