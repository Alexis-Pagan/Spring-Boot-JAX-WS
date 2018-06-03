/**
 * @author Alexis I. Garcia Pagan
 * JAX-WS Service
 * SpringBoot Configuration
 * Development Day: 6/3/2018
 */

package service.soap_implementations;

import javax.jws.WebService;

import service.soap_interfaces.WebSEI;

@WebService(endpointInterface="service.soap_interfaces.WebSEI")
public class WebImpl implements WebSEI{

	@Override
	public String sayHello() {
		return "Hello";
	}

}
