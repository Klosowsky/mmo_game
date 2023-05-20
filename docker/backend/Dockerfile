FROM gradle:7.6-jdk17
WORKDIR /app
COPY . .
RUN if [ -d "./backend/build1" ]; then RUN rm -r ./backend/build; fi
RUN gradle :backend:build -x test
RUN cp ./backend/build/libs/*.jar ./app.jar
CMD ["java", "-jar", "app.jar"]