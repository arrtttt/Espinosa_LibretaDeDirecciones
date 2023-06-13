import java.io.*;
import java.util.*;

public class LibroDeDirecciones {
    static File registros; // Archivo con los registros de la agenda

    static Scanner lector = new Scanner(System.in); // instancia estática de scanner usada como lector

    /**
     * Se crea una instancia del objeto registros, de tipo File
     */
    public static void crearArchivo() {
        registros = new File("AgendaJava.csv");

        try {
            if (registros.createNewFile()) {
                System.out.println("Archivo creado correctamente");
            } else {
                System.out.println(
                        "Ya existe un archivo de registros llamado: " + registros.getName() +
                                ", se usará dicho archivo para almacenar los datos");
            }
        } catch (IOException exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Si se necesita, este metodo elimina el archivo local de los datos
     */
    public static void eliminarArchivo() {
        registros = new File("Archivo.txt");

        if (registros.delete()) {
            System.out.println("Archivo eliminado correctamente");
        } else {
            System.out.println("Error");
        }

    }

    /**
     * Método para guardar la lista dada en el archivo .csv como lineas de texto
     * 
     * @param listaDeRegistros
     */
    public static void guardarEnArchivo(List<DatosDeRegistro> listaDeRegistros) {
        try {
            FileWriter escritura = new FileWriter("AgendaJava.csv");
            for (DatosDeRegistro datosFor : listaDeRegistros) {
                String registroEnArchivo = datosFor.getNombre() + "," + datosFor.getApellido() + ","
                        + datosFor.getCalle() + "," +
                        datosFor.getCiudad() + "," + datosFor.getEstado() + "," + datosFor.getCodigoPostal() + ","
                        + datosFor.getCorreoElec() + "," +
                        datosFor.getTelefono();
                escritura.write(registroEnArchivo);
                escritura.write(System.lineSeparator());
            }
            escritura.close();

        } catch (IOException e) {
            System.err.println("Error al guardar los registros en el archivo, sin nuevos registros o datos inválidos ");
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método principal
     * guarda en memoria una instancia de la clase Datos de registro
     * 
     * @param listaDeRegistros
     */
    public static void registrar(List<DatosDeRegistro> listaDeRegistros) {
        String entradaDeTexto;
        int entradaNumerica;
        boolean comprobacion = false;

        DatosDeRegistro registroGenerico = new DatosDeRegistro();

        System.out.println("Ingresa el nombre");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setNombre(entradaDeTexto);

        System.out.println("Ingresa el apellido");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setApellido(entradaDeTexto);

        System.out.println("Ingresa la calle");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setCalle(entradaDeTexto);

        System.out.println("Ingresa la ciudad");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setCiudad(entradaDeTexto);

        System.out.println("Ingresa el estado");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setEstado(entradaDeTexto);

        System.out.println("Ingrese su correo electronico: ");
        entradaDeTexto = lector.nextLine();
        registroGenerico.setCorreoElec(entradaDeTexto);

        do { // Entrada de datos numerica, necesario comprobar
            try {
                System.out.println("Ingrese el código postal: ");
                entradaNumerica = lector.nextInt();
                registroGenerico.setCodigoPostal(entradaNumerica);
                comprobacion = true;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. ingrese solo numeros");
                lector.nextLine();
            }
        } while (!comprobacion);

        do { // Entrada de datos numerica, necesario comprobar
            try {
                System.out.println("Ingrese el número de teléfono ");
                entradaNumerica = lector.nextInt();
                registroGenerico.setTelefono(entradaNumerica);
                comprobacion = true;
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. ingrese solo numeros");
                lector.nextLine();
            }
        } while (!comprobacion);

        listaDeRegistros.add(registroGenerico);
        lector.nextLine();
        System.out.println("Registro guardado, los datos se guardarán en el archivo al salir del programa");

    }

    /**
     * Carga datos de un archivo dado por el usuario, al archivo default del
     * programa "Registros"
     * 
     * @param archivo
     * @param listaDeRegistros
     */
    public static void cargarDatosDesdeArchivo(String archivo, List<DatosDeRegistro> listaDeRegistros) {

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            Scanner scanner = new Scanner(archivo);
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String calle = datos[2];
                    String ciudad = datos[3];
                    String estado = datos[4];
                    int codigoPostal = Integer.parseInt(datos[5]);
                    String correoElec = datos[6];
                    int telefono = Integer.parseInt(datos[7]);
                    try {
                        DatosDeRegistro registrosCargados = new DatosDeRegistro(nombre, apellido, calle,
                                ciudad, estado, codigoPostal, correoElec, telefono);
                        listaDeRegistros.add(registrosCargados);

                    } catch (Exception e) {
                        System.out.println("El archivo contiene datos invalidos");
                    }
                    scanner.close();
                }
                System.out.println("Datos cargados correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }

    /**
     * Se crea un iterador con los datos de la lista
     * se recorre la lista y se busca que la propiedad nombre sea igual al nombre
     * dado como parametro
     * se elimina de la lista si coincide
     * 
     * @param listaDeRegistros
     * @param nombre
     */
    public static void eliminarPersonaPorPropiedad(List<DatosDeRegistro> listaDeRegistros, String nombre) {
        Iterator<DatosDeRegistro> iterator = listaDeRegistros.iterator();
        while (iterator.hasNext()) {
            DatosDeRegistro datos = iterator.next();
            if (datos.getNombre().equals(nombre)) {
                iterator.remove();
                System.out.println("Contacto eliminado. Verá los cambios en el archivo al salir del programa");
            } else {
                System.out.println("No existe el contacto");
            }
        }
    }

    public static void mostrarPropiedadesPorValor(List<DatosDeRegistro> datos, String nombre) {
        for (DatosDeRegistro datosFor : datos) {
            if (datosFor.getNombre().equals(nombre)) {
                System.out.println("-------------------------------------------");
                System.out.println(datosFor.getNombre());
                System.out.println(datosFor.getApellido());
                System.out.println(datosFor.getCalle());
                System.out.println(datosFor.getCiudad());
                System.out.println(datosFor.getEstado());
                System.out.println(datosFor.getCodigoPostal());
                System.out.println(datosFor.getCorreoElec());
                System.out.println(datosFor.getTelefono());
                System.out.println("-------------------------------------------");
            } else {
                System.out.println("Contacto no encontrado");
            }
            // Agrega más condiciones para otras propiedades si es necesario
        }
    }

    /**
     * Método para mostrar datos en orden alfabetico
     * Crea una lista donde se guardan las lineas del archivo, las ordena con
     * collections y
     * las imprime
     * 
     * @param listaDeRegistros
     */
    public static void mostrarDatosAZ(List<DatosDeRegistro> listaDeRegistros) {
        List<String> lineas = obtenerLineasCSV(registros.getName());
        Collections.sort(lineas);
        for (String linea : lineas) {
            System.out.println(linea);
        }
    }

    /**
     * Método usado para pasar las lineas del archivo a una lista
     * Se usa en el metodo cargarDatosDesdeArchivo
     * 
     * @param archivo
     * @return
     */
    public static List<String> obtenerLineasCSV(String archivo) {
        List<String> lineasCSV = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineasCSV.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return lineasCSV;
    }
}
