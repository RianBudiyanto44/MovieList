/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Connector;
import model.FilmModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class DaoFilm implements InterfaceFilm{
    Connection connection;
    final String insert = "INSERT INTO film (judul,sinopsis,tahun,status_watch) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE film SET judul=?, sinopsis=?, tahun=? WHERE id=? ;";
    final String updateWatchList = "UPDATE film SET status_watch='yes' WHERE id=? ;";
    final String delete = "DELETE FROM film WHERE id=? ;";
    final String deleteWatchList = "UPDATE film SET status_watch='no' WHERE id=? ;";
    final String select = "SELECT * FROM film ORDER BY id ASC;";
    final String selectWatchList = "SELECT * FROM film WHERE status_watch='yes' ORDER BY id ASC;";
    final String selectDetail = "SELECT * FROM film WHERE id=? ;";
    
    public DaoFilm() {
        connection = Connector.getConnection();
    }

    @Override
    public void insert(FilmModel film) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, film.getJudul());
            statement.setString(2, film.getSinopsis());
            statement.setInt(3, film.getTahun());
            statement.setString(4, "no");
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(FilmModel film) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, film.getJudul());
            statement.setString(2, film.getSinopsis());
            statement.setInt(3, film.getTahun());
            statement.setInt(4, film.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(FilmModel film) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, film.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<FilmModel> getDataFilm() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<FilmModel> listFilm = null;
        try {
            listFilm = new ArrayList<FilmModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                FilmModel film = new FilmModel();
                film.setId(rs.getInt("id"));
                film.setJudul(rs.getString("judul"));
                //film.setSinopsis(rs.getString("sinopsis"));
                film.setTahun(rs.getInt("tahun"));
                film.setStatusWatch(rs.getString("status_watch"));
                film.setSinopsis(rs.getString("sinopsis"));
                listFilm.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFilm.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFilm;
    }

    @Override
    public List<FilmModel> getDataWatchList() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<FilmModel> listFilm = null;
        try {
            listFilm = new ArrayList<FilmModel>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectWatchList);
            while (rs.next()) {
                FilmModel film = new FilmModel();
                film.setId(rs.getInt("id"));
                film.setJudul(rs.getString("judul"));
                film.setSinopsis(rs.getString("sinopsis"));
                film.setTahun(rs.getInt("tahun"));
                film.setStatusWatch(rs.getString("status_watch"));
                listFilm.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listFilm;
    }

    @Override
    public List<FilmModel> getDetail(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<FilmModel> listFilm = null;
        try {
            listFilm = new ArrayList<FilmModel>();
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(selectDetail);
//            Statement.setInt(1, id);
            
            PreparedStatement ps = connection.prepareStatement(selectDetail);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FilmModel film = new FilmModel();
                film.setId(rs.getInt("id"));
                film.setJudul(rs.getString("judul"));
                //film.setSinopsis(rs.getString("sinopsis"));
                film.setTahun(rs.getInt("tahun"));
                film.setStatusWatch(rs.getString("status_watch"));
                listFilm.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listFilm;
    }

    @Override
    public void updateWatchList(FilmModel film) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateWatchList);
            statement.setInt(1, film.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteWatchList(FilmModel film) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(deleteWatchList);
            statement.setInt(1, film.getId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
