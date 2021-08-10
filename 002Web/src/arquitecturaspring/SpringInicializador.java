package arquitecturaspring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//Integrar spring mvc en una app web

public class SpringInicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// ServelContext: referencia a la app web
		AnnotationConfigWebApplicationContext contexto=new AnnotationConfigWebApplicationContext();
		contexto.register(SpringConfigurador.class);
		contexto.setServletContext(servletContext);
		
		//Aqui damos de alto nuestro servlet, llamado despachador
		ServletRegistration.Dynamic servlet=
				servletContext.addServlet("despachador", new DispatcherServlet(contexto));

		//sera 1 o 0: orden de ejecucion de servlets
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	


	}

}
