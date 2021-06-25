# geoprocessingtest
A mockup project that emulate the geoprocessing API. To be used to test the interaction between backend frontend.  

Features:
- Emulates the entry point and services of a Geoprocessing API (processes / jobs)
- Processes and jobs can be listed
- Jobs can be started.

You can easily add more processes and the process schema is taken from a json file allowing you to create new mockups quickly and with low effort to test hos your JSON schema is rendered at the client side.

## How to install:
Clone this repo using git
```
git clone https://github.com/felipecarrillo100/geoprocessingtest.git
```
## How build
This project uses Maven + Maven Wrapper to manage dependencies and to compile/build/run the project.  
You can run directly from an IDE such as Intellij  our you can simply compile the project and run the resulting war file from the command line.

To build the entire project use:
```
mvnw package
```
Your compiled war file is created inside the target folder

## To run

Once you have built the project, you can run the war file from the command line
```
cd target
java -jar geoprocessingtest-0.0.1-SNAPSHOT.war
```

If your server is running properly you should now have a response at 
```
http://localhost:8081/oapi-p/
```
