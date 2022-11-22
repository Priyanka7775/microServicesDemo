FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE="movieUserdb"
ENV MONGO_URL="mongodb://localhost:27017/movieUserdb"

ADD ./target/userMovieDemo-0.0.1-SNAPSHOT.jar /usr/lib/userMovieDemo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","userMovieDemo-0.0.1-SNAPSHOT.jar"]