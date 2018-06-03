/**
 * @author Alexis I. Garcia Pagan
 * JAX-WS Service
 * SpringBoot Configuration
 * Development Day: 6/3/2018
 */

/*
 * In this SEI were not use any POJOs class
 */
package service.soap_interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebSEI {

	@WebMethod
	public String sayHello();
}
