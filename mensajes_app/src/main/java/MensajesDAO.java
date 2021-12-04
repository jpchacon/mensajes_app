import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    private static Conexion conexionDB = null;

    public static void initial(){
        conexionDB = new Conexion();
    }

    public static void crearMensajeDB(Mensajes mensajes){
        initial();
        try(Connection connection = conexionDB.getConnection()) {

            PreparedStatement ps = null;

            try{
               String query = "INSERT INTO mensajes (mensaje, autor_mensaje) " +
                       "VALUES (?, ?)";

               ps = connection.prepareStatement(query);
               ps.setString(1, mensajes.getMensaje());
               ps.setString(2, mensajes.getAutorMensaje());
               ps.executeUpdate();

               System.out.println("El mensaje fue creado correctamente");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static void leerMensajesDB(){
        initial();
        try(Connection connection = conexionDB.getConnection()) {

            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT * FROM  mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("\n");
            }

        }catch (SQLException e){
            System.out.println("No se pudo recuperar los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int idMensaje){
        initial();

        try(Connection connection = conexionDB.getConnection()) {

            PreparedStatement ps = null;
            try {

                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";

                ps = connection.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje fue borrado");

            }catch (SQLException ex){
                System.out.println("No fue posible borrar el mensaje");
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensajes){
        initial();

        try(Connection connection = conexionDB.getConnection()) {

            PreparedStatement ps = null;
            try {

                String query = "UPDATE `mensajes` " +
                        "SET mensaje = ?" +
                        " WHERE id_mensaje = ?";

                ps = connection.prepareStatement(query);
                ps.setString(1, mensajes.getMensaje());
                ps.setInt(2, mensajes.getIdMensaje());
                ps.executeUpdate();
                System.out.println("El mensaje fue actualizado");

            }catch (SQLException ex){
                System.out.println("No fue posible actualizar el mensaje");
                System.out.println(ex);
            }

        }catch (SQLException e){
            System.out.println(e);
        }


    }
}
