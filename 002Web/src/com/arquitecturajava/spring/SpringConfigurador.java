package com.arquitecturajava.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Con esto le decimos que nos escanee todos los componentes que tenga arquitectura java y sus hijos
@ComponentScan("com.arquitecturajava.*")

public class SpringConfigurador {
	
}
