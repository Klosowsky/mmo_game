FROM gradle:7.6-jdk17
WORKDIR /app
COPY . .
RUN rm -r ./backend/build;
RUN gradle :backend:build -x test
RUN cp ./backend/build/libs/*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]