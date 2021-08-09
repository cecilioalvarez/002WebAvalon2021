package repositorio.jdbc.helper;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import arquitecturasring.mappers.CapituloMapper;
import negocio.Capitulo;

import repositorio.CapituloRepository;

@Repository
public class CapituloRepositoryJDBC implements CapituloRepository {

	private JdbcTemplate plantilla;

	final static String CONSULTA_BUSCAR_TODOS = "select * from Capitulos";
	final static String CONSULTA_BORRAR = "delete from Capitulos  where titulo =?";
	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas, libros_isbn) values (?,?,?)";

	public CapituloRepositoryJDBC(JdbcTemplate plantilla) {
		super();
		this.plantilla = plantilla;
	}

	@Override
	public List<Capitulo> buscarTodos() {

		return plantilla.query(CONSULTA_BUSCAR_TODOS, new CapituloMapper());
	}

	@Override
	public void borrarCapitulo(Capitulo capitulo) {

		plantilla.update(CONSULTA_BORRAR, capitulo.getTitulo());

	}

	@Override
	public void insertarCapitulo(Capitulo capitulo) {

		plantilla.update(CONSULTA_INSERTAR, capitulo.getTitulo(), capitulo.getPaginas(), capitulo.getLibro().getIsbn());

	}

}
