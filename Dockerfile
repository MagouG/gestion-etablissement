# Utiliser une image de base avec Java 17
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR dans le conteneur
COPY target/gestion-etablissement-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application tourne
EXPOSE 8888

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
