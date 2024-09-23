# Étape 1 : Build de l'application
FROM maven:3.9.9-amazoncorretto-21 AS build
WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le code source et compiler l'application
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Création de l'image pour l'exécution
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copier uniquement le fichier .jar du build précédent
COPY --from=build /app/target/retry-402-back-0.0.1-SNAPSHOT.jar ./app.jar

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
