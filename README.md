# Kafka Message Listener

Класс `KafkaMessageListener` представляет собой потребителя Kafka, реализованный с использованием Spring Kafka. Он прослушивает определенную тему Kafka и обрабатывает поступающие сообщения. В этом README предоставляется обзор класса и инструкции по его настройке.

## Возможности

- Прослушивание темы Kafka "intIn.inner.any.convert".
- Использование Spring Kafka для консумации сообщений.
- Демонстрация использования транзакций для обеспечения надежности обработки сообщений.
- Журналирование входящих сообщений и обработка исключений.

## Предварительные требования

Перед использованием класса `KafkaMessageListener` убедитесь, что у вас есть следующее:

- Запущенный Zookeeper.
  ./bin/zookeeper-server-start.sh config/zookeeper.properties
- Запущен сервер для Kafka
  ./bin/kafka-server-start.sh config/server.properties

## Настройка

### Конфигурация Kafka Consumer

Класс `KafkaMessageListener` настроен в качестве потребителя Kafka с использованием аннотации `@KafkaListener`. Вот ключевые настройки:

- `topics`: Указывает тему Kafka, из которой нужно консумировать сообщения.
- `groupId`: Определяет идентификатор группы потребителей.
- `transactionManager`: Менеджер транзакций, используемый для управления транзакциями.
- `rollbackFor`: Указывает типы исключений, вызывающие откат транзакции.
- `propagation`: Указывает поведение распространения транзакции. В данном случае используется `Propagation.REQUIRES_NEW` для запуска новой транзакции для каждого сообщения.

### Обработка сообщений

Метод `listen2` обрабатывает поступающие сообщения Kafka. В этом методе выполняются следующие действия:

1. Регистрируется ключ и значение полученного сообщения.
2. Если значение сообщения равно "Hello", имитируется ошибка путем генерации исключения `RuntimeException`, что приводит к откату транзакции.
3. Если значение сообщения отличается от "Hello", выполняется журналирование успешной обработки сообщения.

## Использование

Чтобы использовать класс `KafkaMessageListener` в вашем проекте, выполните следующие шаги:

1. Убедитесь, что у вас настроен брокер Kafka и в вашем проекте настроен Spring Boot или Spring Kafka.

2. Разместите класс `KafkaMessageListener` в исходном коде вашего проекта.

3. Настройте Kafka-продюсера для отправки сообщений в тему "intIn.inner.any.convert".

4. Запустите ваше Spring-приложение, и `KafkaMessageListener` автоматически начнет прослушивать указанную тему Kafka.

5. Просматривайте журналы, чтобы увидеть, как обрабатываются сообщения, и как управляются транзакции.

## Как положить сообщение в Кафку? Два варианта

Чтобы добавить message в кафку через внешнее ПО следуйте этим шагам:
1. Установите Offset Explorer
2. Выберите properties -> kafka cluster version:last -> Zookeeper host:localhost -> port:2181
3. topicName -> Topics -> Partitions -> "+" -> add new Messsage (String:String) -> Add

Пример хорошего запроса:

<img width="1557" alt="Снимок экрана 2023-10-29 в 15 39 17" src="https://github.com/Pekar7/kafka-message/assets/90376574/63f06e78-ce01-4d00-a28d-c3ee7125536c">


Итог:

<img width="2224" alt="Снимок экрана 2023-10-29 в 15 39 49" src="https://github.com/Pekar7/kafka-message/assets/90376574/6229d896-1963-4257-9a65-ac049f6c4b2d">


##




Пример плохого запроса (откат транзакции): 

<img width="1559" alt="Снимок экрана 2023-10-29 в 15 40 03" src="https://github.com/Pekar7/kafka-message/assets/90376574/cf790974-b5ae-4f39-82f2-f754861fdec5">

Итог:

<img width="2560" alt="Снимок экрана 2023-10-29 в 15 40 45" src="https://github.com/Pekar7/kafka-message/assets/90376574/59b77769-7b0c-4337-978a-7a9dff39790a">


##
##
## NEW UI FROM IDEA
<img width="2560" alt="Снимок экрана 2023-11-04 в 15 44 45" src="https://github.com/Pekar7/kafka-message/assets/90376574/7e95ab06-58a9-453c-af58-bd831daac702">
<img width="2560" alt="Снимок экрана 2023-11-04 в 15 45 22" src="https://github.com/Pekar7/kafka-message/assets/90376574/c3deb694-02df-4456-859b-65e12ae34736">
<img width="2560" alt="Снимок экрана 2023-11-04 в 15 38 44" src="https://github.com/Pekar7/kafka-message/assets/90376574/f4b6ee0b-22a5-4586-bd2e-628f59967ceb">
