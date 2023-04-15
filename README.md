**SFU Break**

<details><summary>How to Build, Run and Test Game</summary>
To build the project, navigate to the project directory where the pom.xml file is located: 
    `game/mygame'

Run the following command
    `mvn clean install`
   
This will build the project and generate the necessary artifacts such as jar, war, or ear files.

To run the project, you can use the following command:
    `mvn exec:java -Dexec.mainClass="com.example.Main"`

To test the project, you can use the following command:
    `mvn test`
</details>

<details><summary>How to Build and Execute artifacts of the game</summary>
To build the project, navigate to the project directory where the pom.xml file is located: 
    `game/mygame'

Run the following command:
    `mvn clean install`

To generate the JAR file including all dependencies, run the following command:
    `mvn clean compile assembly:single`
This command will create a JAR file named `mygame-1.0-SNAPSHOT-jar-with-dependencies.jar` in the `target` directory.

To run the project with JavaFX, run the following command:
    `mvn javafx:run`

To execute the generated JAR file, run the following command from the `target` directory:
    `java -jar mygame-1.0-SNAPSHOT-jar-with-dependencies.jar`
</details>

<details><summary>How to Generate and View Javadocs</summary>
To generate Javadocs, run the following command from the project directory:
    `mvn javadoc:javadoc`

This command will generate Javadocs in the `target/site/apidocs` directory.

To view the generated Javadocs, the `index.html` file is located at `target/site/apidocs` directory.




