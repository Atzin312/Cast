/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.conexion;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.personal;
import model.Noticia;
import model.Comentarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author atzin
 */
public class noticia {

    Statement ps;
    ResultSet rs;
    String data;
    private String response;

    ModelAndView mav = new ModelAndView();

    //Modelado de Home 
    @RequestMapping("/home")
    public ModelAndView home(HttpServletRequest request/*2*/) throws SQLException, MalformedURLException, IOException, ClassNotFoundException {

        mav.setViewName("home");
        return mav;
    }

    //Traer Noticias
    @RequestMapping("/noticias")
    @ResponseBody
    public String noticias(HttpServletRequest request/*2*/) {
        List<Noticia> noticia = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sitionoticias", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *,CONCAT(p.nombre,' ',p.apePaterno,' ',p.apeMaterno) AS nombreCompleto FROM `noticias` INNER JOIN personal p ON p.idPersonal = noticias.idPersonal");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

                Noticia not = new Noticia();
                not.setIdNoticia(rs.getInt(1));
                not.setIdPersonal(rs.getInt(2));
                not.setNoticia(rs.getString(3));
                not.setNombreCompleto(rs.getString(10));
                noticia.add(not);
            }

            con.close();
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.writeValueAsString(noticia);

        } catch (Exception e) {
            System.out.println(e);
        }
        return data;

    }
    
    //Crear una nueva Noticia
    @RequestMapping("/nuevaNoticia")
    @ResponseBody
    public void nuevaNoticia(HttpServletRequest request/*2*/) {

        String txtIdPersonal = request.getParameter("txtIdPersonal");
        String txtNoticia = request.getParameter("txtNoticia");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sitionoticias", "root", "");
            Statement stmt = con.createStatement();

            String sql = "INSERT INTO noticias(idPersonal,noticia) VALUES (idPersonaTXT, 'noticiaTXT')";
            System.out.println("SQL 1 " + sql);
            sql = sql.replace("idPersonaTXT", txtIdPersonal);
            sql = sql.replace("noticiaTXT", txtNoticia);
            //sql = sql.replace("idPersonal"+ txtIdPersonal + " 'noticia" , txtNoticia + "'");
            System.out.println("SQL REPLACE " + sql);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    //Cargar Comentarios
    @RequestMapping("/comentarios")
    @ResponseBody
    public String comentarios(HttpServletRequest request/*2*/) {
        List<Comentarios> comentarios = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sitionoticias", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT co.idComentario, co.comentario,nt.idNoticia,pe.idPersonal,CONCAT(pe.nombre,\" \",pe.apePaterno,\" \",pe.apeMaterno) nombreCompleto FROM comentarios co LEFT JOIN noticias nt ON nt.idNoticia = co.idNoticia LEFT JOIN personal pe ON pe.idPersonal = co.idPersonal LEFT JOIN usuarios us ON us.idUsuario = co.idUsuario");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

                Comentarios com = new Comentarios();
                com.setIdComentario(rs.getInt(1));
                com.setComentario(rs.getString(2));
                com.setIdNoticia(rs.getInt(3));
                com.setIdPersonal(rs.getInt(4));
                com.setNombreCompleto(rs.getString(5));
                comentarios.add(com);
            }

            con.close();
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.writeValueAsString(comentarios);

        } catch (Exception e) {
            System.out.println(e);
        }
        return data;

    }

    
    //Crear un nuevo Comentario
    @RequestMapping("/nuevoComentario")
    @ResponseBody
    public void nuevoComentario(HttpServletRequest request/*2*/) {
        String txtIdComentario = request.getParameter("txtIdPersonalCom");
        String txtComentario = request.getParameter("txtComentario");
        String txtNoticia = request.getParameter("txtNoticia");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sitionoticias", "root", "");
            Statement stmt = con.createStatement();

            String sql = "INSERT INTO comentarios(idNoticia,idPersonal,comentario) VALUES (idNoticiaCOM,idPersonaCOM, 'comentarioCOM')";
            System.out.println("SQL 1 " + sql);
            sql = sql.replace("idNoticiaCOM", txtNoticia);
            sql = sql.replace("idPersonaCOM", txtIdComentario);
            sql = sql.replace("comentarioCOM", txtComentario);
            //sql = sql.replace("idPersonal"+ txtIdPersonal + " 'noticia" , txtNoticia + "'");
            System.out.println("SQL REPLACE " + sql);
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
