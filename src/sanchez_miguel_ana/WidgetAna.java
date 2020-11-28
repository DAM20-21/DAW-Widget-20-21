package sanchez_miguel_ana;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class WidgetAna {
    public static Connection getConexion(String bd) {

        Properties propiedades = new Properties();
        FileInputStream fis;
        Connection conexion = null;
        String database = bd.toLowerCase();

        try {
            // LEEMOS EL FICHERO DE CONFIGURACIÓN
            fis = new FileInputStream("configuracion.properties");

            // CARGAMOS EL ARCHIVO CON LAS PROPIEDADES DE LA BASE DE DATOS
            propiedades.load(fis);

            // CARGAMOS EL DRIVER
            Class.forName(propiedades.getProperty("driver-" + database));
            conexion = DriverManager.getConnection(propiedades.getProperty("conexion-" + database),
                    propiedades.getProperty("usuario-" + database), "");

        } catch (IOException | ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        return conexion;
    }
}
