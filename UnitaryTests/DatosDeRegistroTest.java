import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatosDeRegistroTest {

    @Test
    public void testToString() {
        DatosDeRegistro registro = new DatosDeRegistro("John", "Doe", "123 Main St", "City", "State", 12345,
                "john.doe@example.com", 123456789);

        String expected = "John, Doe, 123 Main St, City, State, 12345, john.doe@example.com, 123456789";
        String actual = registro.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGettersAndSetters() {
        DatosDeRegistro registro = new DatosDeRegistro();

        registro.setNombre("John");
        registro.setApellido("Doe");
        registro.setCalle("123 Main St");
        registro.setCiudad("City");
        registro.setEstado("State");
        registro.setCodigoPostal(12345);
        registro.setCorreoElect("john.doe@example.com");
        registro.setTelefono(123456789);

        Assertions.assertEquals("John", registro.getNombre());
        Assertions.assertEquals("Doe", registro.getApellido());
        Assertions.assertEquals("123 Main St", registro.getCalle());
        Assertions.assertEquals("City", registro.getCiudad());
        Assertions.assertEquals("State", registro.getEstado());
        Assertions.assertEquals(12345, registro.getCodigoPostal());
        Assertions.assertEquals("john.doe@example.com", registro.getCorreoElect());
        Assertions.assertEquals(123456789, registro.getTelefono());
    }
}
