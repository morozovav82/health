FROM frolvlad/alpine-java:jdk8.202.08-slim
COPY target/health-1.0.jar /
CMD ["java", "-jar", "health-1.0.jar"]
