import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class LibroDeDireccionesTest {
    private List<DatosDeRegistro> listaDeRegistros;

    @Before
    public void setUp() {
        listaDeRegistros = new ArrayList<>();
    }

    @Test
    public void testRegistrar() {
        String input = "John\nDoe\n123 Main St\nCity\nState\njohn@example.com\n12345\n5551234567\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        LibroDeDirecciones.registrar(listaDeRegistros);

        assertEquals(1, listaDeRegistros.size());
        DatosDeRegistro registro = listaDeRegistros.get(0);
        assertEquals("John", registro.getNombre());
        assertEquals("Doe", registro.getApellido());
        assertEquals("123 Main St", registro.getCalle());
        assertEquals("City", registro.getCiudad());
        assertEquals("State", registro.getEstado());
        assertEquals("john@example.com", registro.getCorreoElect());
        assertEquals(12345, registro.getCodigoPostal());
        assertEquals(5551234567L, registro.getTelefono());
    }

    @Test
    public void testCargarDatosDesdeArchivo() {
        List<DatosDeRegistro> registrosEsperados = new ArrayList<>();
        registrosEsperados.add(new DatosDeRegistro("John", "Doe", "123 Main St", "City", "State", 12345, "john@example.com", 5551234567L));

        String archivo = "datos.csv";
        LibroDeDirecciones.cargarDatosDesdeArchivo(archivo, listaDeRegistros);

        assertEquals(registrosEsperados.size(), listaDeRegistros.size());
        for (int i = 0; i < registrosEsperados.size(); i++) {
            DatosDeRegistro registroEsperado = registrosEsperados.get(i);
            DatosDeRegistro registroActual = listaDeRegistros.get(i);
            assertEquals(registroEsperado.getNombre(), registroActual.getNombre());
            assertEquals(registroEsperado.getApellido(), registroActual.getApellido());
            assertEquals(registroEsperado.getCalle(), registroActual.getCalle());
            assertEquals(registroEsperado.getCiudad(), registroActual.getCiudad());
            assertEquals(registroEsperado.getEstado(), registroActual.getEstado());
            assertEquals(registroEsperado.getCodigoPostal(), registroActual.getCodigoPostal());
            assertEquals(registroEsperado.getCorreoElect(), registroActual.getCorreoElect());
            assertEquals(registroEsperado.getTelefono(), registroActual.getTelefono());
        }
    }
}
