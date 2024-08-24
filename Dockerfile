# Usando a imagem do JDK 17
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o jar gerado para dentro do container
COPY target/pixxaria-0.0.1-SNAPSHOT.jar /app/app.jar

# Expondo a porta em que a aplicação vai rodar (se necessário)
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/app.jar"]
