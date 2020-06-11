/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdmysql;

import VO.GerenteVO;
import bd.Conexion;
import com.mysql.jdbc.Connection;
import modelo.gerenteModel;

/**
 *
 * @author Administrador
 */
public class AppTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = new Conexion().conectar();

//        GerenteVO geVO = new GerenteVO();
//        
//        System.out.println("CONSULTA APRENDIZ");
//        geVO.setEmail("john");
//        gerenteModel gerente = new gerenteModel(geVO);
//        geVO = gerente.consultarGenrente();
//        System.out.println("Nombre_ usuario: " + geVO.getEmail()+ " contraseña: "
//                + geVO.getContraseña()+ " registro_clientes: " + geVO.getRegistro_clientes());
////        
//        
        
        
 //-------------------------Ingresar---------------------------------------------------       
//        
//        System.out.println("INGRESAR USUARIO");
//        usVO.setCedula(5555L);
//        usVO.setNombre("Leidy Hernandez");
//        usVO.setContraseña("17852");
//        usVO.setCorreo("lh@lh.co");
//        usVO.setRol("admin");
//        usVO.setTelefono(54646L);
//        
//        aprendiz.setUsuarioVO(usVO);
//                
//        aprendiz.insertarUsuario();
        

//-------------------------Actualizar---------------------------------------------------

//        System.out.println("ACTUALIZAR USUARIO");
//        usVO.setCedula(4444L);
//        usVO.setNombre("Leidy Hernandez");
//        usVO.setContraseña("456");
//        usVO.setCorreo("ldhg.gmail.com");
//        usVO.setRol("admin");
//        usVO.setTelefono(7851760L);
//        
//        
//        aprendiz.setUsuarioVO(usVO);
//                
//        aprendiz.ActualizarUsuario();

//-------------------------Eliminar------------------------------------------------------
//        System.out.println("BORRAR USUARIO");
//        usVO.setCedula(6666L);
//        aprendiz.setUsuarioVO(usVO);
//        aprendiz.BorrarUseuario();
        

//-------------------------Listar Aprendices ------------------------------------------------------
//        System.out.println("LISTA DE APRENDICES");
//        for (GerenteVO u : aprendiz.listarUsuario()) {
//            System.out.println("Nombre: " + u.getNombre() + " Correo: "
//                    + u.getCorreo() + " Rol: " + u.getRol());
//        }
        
    }

}
