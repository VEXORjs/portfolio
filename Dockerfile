<<<<<<< HEAD
# 1. Używamy obrazu Javy (JDK 21, bo taką pewnie masz wersję)
FROM eclipse-temurin:26-jdk-alpine

# 2. Tworzymy folder roboczy w kontenerze
WORKDIR /app

# 3. Kopiujemy wygenerowany plik JAR do kontenera
# Pamiętaj, aby nazwa pliku .jar zgadzała się z tym, co wygeneruje Maven
COPY target/*.jar app.jar

# 4. Polecenie, które uruchomi aplikację po starcie kontenera
=======
# 1. Używamy obrazu Javy (JDK 21, bo taką pewnie masz wersję)
FROM eclipse-temurin:26-jdk-alpine

# 2. Tworzymy folder roboczy w kontenerze
WORKDIR /app

# 3. Kopiujemy wygenerowany plik JAR do kontenera
# Pamiętaj, aby nazwa pliku .jar zgadzała się z tym, co wygeneruje Maven
COPY target/*.jar app.jar

# 4. Polecenie, które uruchomi aplikację po starcie kontenera
>>>>>>> f93e12e34571749b36a17941ccc10167da6848a2
ENTRYPOINT ["java", "-jar", "app.jar"]