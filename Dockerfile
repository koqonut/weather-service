FROM openjdk:11
ENV APP_FILE weather-service-0.0.1-SNAPSHOT.jar  
ENV APP_HOME /usr/app  
EXPOSE 5001  
COPY build/libs/*.jar $APP_HOME/  
WORKDIR $APP_HOME  
ENTRYPOINT ["sh", "-c"]  
CMD ["exec java -jar $APP_FILE"]