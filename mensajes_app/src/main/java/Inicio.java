import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.util.Scanner;


public class Inicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do{
            System.out.println("------------------------------\n" +
                    "Aplicación de mensajes\n" +
                    "1. Crear mensaje\n" +
                    "2. Listar mensajes\n" +
                    "3. Editar mensaje\n" +
                    "4. Eliminar mensaje\n" +
                    "5. Salir");

            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while (opcion != 5);


    }
}
