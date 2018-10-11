Configuring Consul --
We need to first download, configure and run consul agent in localhost.

Download from Consul portal - https://www.consul.io/downloads.html. Choose particular package based on the operating System. Once downloaded the zip, we need to unzip it to desired place.
Start Consul Agent in local workstation – The Zip file that we have unzipped, has only one exe file called consul.exe. We will start a command prompt here and use below command to start the agent.
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.6.1
Make sure you enter the correct bind address, it would be different depending on the LAN settings. Do a ipconfig in command prompt to know your IpV4 address and use it here.
Test whether Consul Server is running – Consul runs on default port and once agent started successfully, browse http://localhost:8500/ui 
We should the see the Services in the Consul Agent console.

====================================================

For this application the port mentioned in the application.properties file is 9098. This can be changed anytime. The service end points can be verified by running the test class - /messages-service-meenal/src/test/java/com/assignment/tantalum/messagesservicemeenal/MessagesServiceMeenalApplicationTests.java
For the time being, I have written just 3 test cases(addMessage/ getAllMessages / getMessagesForANumber) but can add more for testing other functionalities too, as I have already implemented the solution for other end points as well. 
Alternatively we can also verify using Postman after running the java class- /messages-service-meenal/src/main/java/com/assignment/tantalum/messagesservicemeenal/MessagesServiceMeenalApplication.java.

===========================================================================