import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Objetos necesarios
        Scanner inp = new Scanner(System.in); // instancia de scanner usada como lector
        boolean doCheck = false; // variable boleana para condición del do while
        List<DatosDeRegistro> listaDeRegistros = new ArrayList<>(); // Lista para tener los datos del archivoen memoria

        // Si el archivo no existe, se crea
        LibroDeDirecciones.crearArchivo();
        // variable para leer la opción del usuario
        int opcion = 0;
        /*
         * Método usado para cargar en memoria los datos guardados en el archivo creado
         * en ejecuciones pasadas
         */
        LibroDeDirecciones.cargarDatosDesdeArchivo("AgendaJava.csv", listaDeRegistros);

        do {
            menu.mostrarMenu();
            try {
                opcion = inp.nextInt();
            } catch (Exception e) {
                System.err.println(e.getCause());
            }
            inp.nextLine();
            switch (opcion) {

                case 1:
                    System.out.println("Ha seleccionado cargar datos de un archivo");
                    System.out.println("Ingrese el nombre con extensión de su archivo");
                    String nombreArchivoDeCarga;
                    nombreArchivoDeCarga = inp.nextLine();

                    LibroDeDirecciones.cargarDatosDesdeArchivo(nombreArchivoDeCarga, listaDeRegistros);
                    break;

                case 2:
                    System.out.println("Ha seleccionado agregar un contacto");
                    LibroDeDirecciones.registrar(listaDeRegistros);

                    break;

                case 3:
                    System.out.println("Ha seleccionado eliminar un contacto");
                    System.out.println("Escriba el nombre de la persona que desea eliminar");
                    String nombreEliminar = inp.nextLine();
                    LibroDeDirecciones.eliminarPersonaPorPropiedad(listaDeRegistros, nombreEliminar);
                    break;

                case 4:
                    System.out.println("Ha seleccionado la opción buscar un contacto");
                    System.out.println("Escriba el nombre de la persona que desea encontrar");
                    String nombreBusqueda = inp.nextLine();
                    LibroDeDirecciones.mostrarPropiedadesPorValor(listaDeRegistros, nombreBusqueda);
                    break;

                case 5:
                    System.out.println("Ha seleccionado mostrar registros");
                    LibroDeDirecciones.mostrarDatosAZ(listaDeRegistros);
                    break;

                case 6:
                    System.out.println("Ha seleccionado salir");
                    LibroDeDirecciones.guardarEnArchivo(listaDeRegistros);
                    doCheck = true;
                    inp.close();
                    System.exit(0);

                default:
                    System.out.println("Opción inválida");
                    break;

            }
        } while (!doCheck);
        inp.close();
    }
}