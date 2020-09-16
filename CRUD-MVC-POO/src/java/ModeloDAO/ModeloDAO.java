package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ModeloDAO implements CRUD{

    Conexion cn = new Conexion();
    Connection con;
    CallableStatement cs;
    ResultSet rs;
    Persona p = new Persona();
    
    
    @Override
    public List listar() {
        
        ArrayList<Persona>list = new ArrayList<>();
        String sql = "{call listar()}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setId_doc(rs.getInt(1));
                per.setNom(rs.getString(2));
                per.setAp1(rs.getString(3));
                per.setAp2(rs.getString(4));
                list.add(per);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Persona list(int id_doc) {
//        String sql = "select * from alumnos where id_documento="+id_doc;
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                
//                p.setId_doc(rs.getInt("id_documento"));
//                p.setNom(rs.getString("nombre"));
//                p.setAp1(rs.getString("ap_paterno"));
//                p.setAp2(rs.getString("ap_materno"));
//                
//            }
//            
//        } catch (Exception e) {
//        }
        
        return p;
    }

    @Override
    public void add(Persona per) {
        
        String sql ="{call registrar(?,?,?,?)}";
        try {
            con = cn.getConnection();
            cs = con.prepareCall(sql);
            cs.setInt(1, p.getId_doc());
            cs.setString(2, p.getNom());
            cs.setString(3, p.getAp1());
            cs.setString(4, p.getAp2());
            
            int r = cs.executeUpdate();
            if(r == 0 ){
                throw new SQLException();
            }
            cs.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void edit(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id_doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
