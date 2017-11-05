# WeatherApplication

This is a maven project. The dependecies which I have used is Jakcson and specifically jackson-databind in order to parse the json
The project is consisted by 3 packages, the main package, the service package and the enumeration package.

<b>Main Package</b>

The main package includes the Main class of the project which calls an object in order to write the results into a txt file

<b> Service Package </b>

The service package includes the WeatherService class which is responsible for the connection and also the parsing of the json to 
extract the useful information. It is also includes an Interface Output which has a void method out. This interface is implemented
by the FileOutput class and in the out method it writes the results in a txt file. 

<b> Enumeration Package </b>

In this package there is the Enumeration class Metrics which contains the metrics we want to extract from the json.
