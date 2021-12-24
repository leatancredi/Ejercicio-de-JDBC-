package Test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TestMysqlJDBC {
    public static void main(String[] args) {
        
        //CADENA DE CONECCION A LA DB DE MYSQL, CON PARAMETROS DE CONECCION SEGURA.
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //LINEA NO REQUERIDA EN ULTIMAS ACTUALIZACIONES
            //SALVO EN APLICACIONES WEB
        try {
            //
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
          //CREAMOS EL OBJETO STATEMENTS PARA PODER EJECUTAR SENTENCIAS DE NUESTRA DB.  
          Statement instruccion = conexion.createStatement();
          //HACEMOS UNA INSTRUCCION.
          var sql ="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
          //EJECUTAMOS LA INSTRUCCION CON UN TIPO INTERFASE
          ResultSet resultado =  instruccion.executeQuery(sql);
          //INTERAMOS TODO CON UN CICLO WHILE PARA OBTENER RESULTADOS
          //EL METODO NEXT HACE QUE EL CICLO SE EJECUTE MIENTRAS HAYA RESULTADO POR INTERAR
          while(resultado.next()){
              System.out.print("Id Persona " + resultado.getInt("id_persona"));
              System.out.print(" Nombre " + resultado.getNString("nombre"));
              System.out.print(" Apellido " + resultado.getNString("apellido"));
              System.out.print(" Email " + resultado.getNString("email"));
              System.out.print(" Telefono " + resultado.getNString("telefono"));
              
              System.out.println("");
          }
          //CERRAMOS LOS OBJETOS ABIERTOS 
          resultado.close();
          instruccion.close();
          conexion.close();
          
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
}
