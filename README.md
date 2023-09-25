### What is this project about ?

The present project is a text-only chat console application implemented using sockets in Java. The communication is bidirectional. One thread handles incoming messages while the rest of the code deals with sending messages.

### What are the requirements ?

1. Make sure you have *git* installed on your machine
2. Ensure that the Java Virtual Machine (JVM) is available on your machine
3. A Java IDE should be installed on your computer

### How to run the project ?

1. Clone the project with `*git clone https://github.com/SalomonMetre/Text-Only-Chat-Console-App*`
2. Open the project in your IDE
3. Navigate to *src/main/java/main_package*
4. Run *SimpleServer.java* which is the server program.
At this stage, the server will await the connection from the client
5. Run *SimpleClient.java* which is the client program.
Once the connection is established between the client and the server you will see the message "[Other is ready]" both on the client and the server sides and you can start chatting ! Just type your message where the prompt says "Me : "


