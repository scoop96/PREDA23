import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class CambioDinamica {
    // Clase auxiliar para almacenar los datos de entrada
    public static class DatosEntrada {
        int numeroDeMonedas;
        int[] listaNumeros;
        int cambioadevolver;
    }
    public static String helpText = "Uso: java CambioDinamica [-t][-h] [fichero entrada] [fichero salida]";



    public static void main(String[] args) {
        if (args.length < 2 || args.length > 4) {
            System.out.println(helpText);
            return;
        }

        boolean opcionT = false;
        boolean opcionH = false;
        String ficheroEntrada = null;
        String ficheroSalida = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-t")) {
                opcionT = true;
            } else if (args[i].equals("-h")) {
                opcionH = true;
            } else if (ficheroEntrada == null) {
                ficheroEntrada = args[i];
            } else if (ficheroSalida == null) {
                ficheroSalida = args[i];
            }
        }

        if (opcionH) {
            System.out.println("Ayuda: Para ejecutar este programa use:");
            System.out.println(helpText);
        } else {
            if (ficheroEntrada != null && ficheroSalida != null) {
                // Llamamos a la función para procesar el fichero de entrada
                DatosEntrada datos = procesarFicheroEntrada(ficheroEntrada);

                
                // Llamamos a la función para crear el fichero de salida
                crearFicheroSalida(ficheroSalida);
                
                if (opcionT) {
                    // Realizar aquí cualquier procesamiento adicional según la opción -t
                }
                
                System.out.println("Proceso completado.");
            } else {
                System.out.println(helpText);
            }
        }
    }

    private static DatosEntrada procesarFicheroEntrada(String ficheroEntrada) {
        DatosEntrada datos = new DatosEntrada();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            // Leemos el tamaño de la lista
            datos.numeroDeMonedas = Integer.parseInt(br.readLine());

            // Leemos la lista de números
            String[] listaNumerosStr = br.readLine().split("\\s+");
            datos.listaNumeros = new int[datos.numeroDeMonedas];
            for (int i = 0; i < datos.numeroDeMonedas; i++) {
                datos.listaNumeros[i] = Integer.parseInt(listaNumerosStr[i]);
            }

            // Leemos el valor único
            datos.cambioadevolver = Integer.parseInt(br.readLine());

        } catch (IOException e) {
            System.err.println("Error al leer el fichero de entrada: " + e.getMessage());
        }

        return datos;
    }





    private static void crearFicheroSalida(String ficheroSalida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {
            bw.write("Contenido del fichero de salida.");
            // Puedes añadir aquí cualquier contenido adicional al fichero de salida.
        } catch (IOException e) {
            System.err.println("Error al crear el fichero de salida: " + e.getMessage());
        }
    }
}
