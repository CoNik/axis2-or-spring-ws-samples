/**
 * @author constantinn
 * 
 * Configuration class containing the Bean definitions for all webservice endpoints.
 * NOT all endpoints have been implemented as functionality. 
 * Each Bean is specific to each xsd schema containing the descriptor for each request/response
 * */
package org.java.ws.sample;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class AppConfig {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/*");
	}
	
	@Bean(name = "randomItem")
	public DefaultWsdl11Definition randomItemWsdlDefinition(XsdSchema randomItemSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ItemPort");
		wsdl11Definition.setLocationUri("/RandomItem");
		wsdl11Definition.setTargetNamespace("http://www.example.org/");
		wsdl11Definition.setSchema(randomItemSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "userSchema")
	public DefaultWsdl11Definition usertWsdlDefinition(XsdSchema userSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("UserPort");
		wsdl11Definition.setLocationUri("/UserSchema");
		wsdl11Definition.setTargetNamespace("http://www.example.org/");
		wsdl11Definition.setSchema(userSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema articlesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("schemas/"));
	}

}
