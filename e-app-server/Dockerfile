FROM tomcat:latest
EXPOSE 8080
COPY build/libs/e-app-server.war /usr/local/tomcat/webapps/ROOT.war
COPY agent/f-java-agent.jar /usr/local/tomcat
ENV JAVA_TOOL_OPTIONS "-javaagent:/usr/local/tomcat/f-java-agent.jar"