/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mysql.jdbc.Connection;

/**
 *
 * @author Administrador
 */
public interface IConexion {
    final String SERVIDOR="localhost";
    final String BD="eps";
    final String USUARIO="root";
    final String CONTRASEÑA="";
    final String DRIVER="com.mysql.jdbc.Driver";//version 5
    final String DRIVER8="com.mysql.cj.jdbc.Driver";//version 8    
    final String PARAMETROS = "?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Connection conectar();
    public void desconectar();        
}
