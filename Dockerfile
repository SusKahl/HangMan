FROM ubuntu

#Oracle Java7 install
RUN apt-get install software-properties-common -y
RUN apt-get update
RUN add-apt-repository -y ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN apt-get install -y oracle-java7-installer

#Jenkins install
RUN wget -q -O - http://pkg.jenkins-ci.org/debian/jenkins-ci.org.key | sudo apt-key add -
RUN sudo echo "deb http://pkg.jenkins-ci.org/debian binary/" >> /etc/apt/sources.list
RUN apt-get update
RUN apt-get install -y jenkins
RUN sudo service jenkins start
RUN tail -f /etc/passwd

EXPOSE 8080