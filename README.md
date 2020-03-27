# axis2-or-spring-ws-samples
Sample projects for a simple ws done with spring and axis2


ws-sample-consumer 	:: sample spring boog based app that takes a wsdl source schema and generates the client classes based on that schema

	ws-sample-spring 	:: SpringBoot based SOAP WS, that exposes a simple object, does some basic operations via a service class, contains two xsd schemas that were used to generate the entity objects.
  
	ws.aixs2.test  :: AXIS2 and Spring based project that contains a simple entity that is being pushed via a service class. 
  
  
 Sample wsdl schema generated for a RandomItem entity is in /src/main/webapp/wsdl 
 The system connects to a local mysql database to show CRUD operations.
