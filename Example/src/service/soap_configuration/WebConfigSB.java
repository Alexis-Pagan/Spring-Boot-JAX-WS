/**
 * @author Alexis I. Garcia Pagan
 * JAX-WS Service
 * SpringBoot Configuration
 * Development Day: 6/3/2018
 */

package service.soap_configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import service.soap_implementations.WebImpl;
import service.soap_interfaces.WebSEI;

@Configuration
@ComponentScan(basePackageClasses={WebSEI.class, WebImpl.class}) // type-safe scan for Service Endpoint Interface and Service Implementation
@ImportResource({"classpath:META-INF/cxf/cxf.xml"}) // on classpath on the Maven Dependencies downloaded from POM.xml
public class WebConfigSB {

	//Replaces web.xml file: Only on Spring Boot Projects for Web Services
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean cxfServlet() {
		System.out.print("CXFServlet set to: /soap/*");
		/*
		 * BIG NOTE HERE: if you don't provide a "/servlet-name/" for example:
		 * return new ServletRegistrationBean(new CXFServlet(), "/servlet-name/");
		 * the service CXFServlet will be automatically set for you with /services/*			
		 */
		return new ServletRegistrationBean(new CXFServlet());			
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus bus() {
		System.out.print("SpringBus passed");
		return new SpringBus();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl end = new EndpointImpl(bus(), new WebImpl());
		System.out.print("Endpoint visited as well");
		end.publish("/myservice"); // use this to generate WSDL file: http://localhost:8081/myservice?wsdl
		return end;
	}
}
