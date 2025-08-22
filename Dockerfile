# Этап 1: Сборка приложения (Builder Stage)
FROM maven AS builder

WORKDIR /app

# Копируем pom.xml и скачиваем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Копируем исходный код приложения
COPY src ./src

# Собираем приложение
RUN mvn package -Dmaven.test.skip

# Этап 2: Создание финального образа (Runtime Stage)
FROM openjdk:17-jdk-slim

WORKDIR /app

# Копируем только собранный JAR-файл из этапа сборки
COPY --from=builder /app/target/*.jar app.jar

# Указываем порт, который приложение слушает
EXPOSE 8082

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]