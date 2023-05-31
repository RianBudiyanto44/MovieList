/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoFilm;
import dao.InterfaceFilm;
import java.util.List;
import javax.swing.JOptionPane;
import model.FilmModel;
import view.DetailForm;
import view.FilmView;

/**
 *
 * @author ASUS
 */
public class ControllerDetail {
    //int id;
    DetailForm frame;
    FilmView frame2;
    InterfaceFilm infcFilm;
    //List<FilmModel> detail;

    public ControllerDetail(DetailForm frame) {
        this.frame = frame;     
        //detail = infcFilm.getDetail(id);
        infcFilm = new DaoFilm();
    }
    
    public void tampilkanData(FilmModel film){
        
        frame.setTextJudul(film.getJudul());
        frame.setTextSinopsis(film.getSinopsis());
        String tahun = String.valueOf(film.getTahun());
        frame.setTextTahun(tahun);
        
        String Id = String.valueOf(film.getId());
        frame.setTextId(Id);
                
        //int id = film.getId();
    }
    
    public void simpanEdit(int id, int status){
        FilmModel edit = new FilmModel();
        
        edit.setJudul(frame.getTextJudul().getText());
        edit.setSinopsis(frame.getTextSinopsis().getText());
        edit.setTahun(Integer.parseInt(frame.getTextTahun().getText()));

        edit.setId(id);
        if(status == 1) {
            infcFilm.update(edit);
            JOptionPane.showMessageDialog(frame, "Berhasil mengedit data");
        } else if(status == 2) {
            infcFilm.updateWatchList(edit);
            JOptionPane.showMessageDialog(frame, "Berhasil menambah watch list");
        } else {
            infcFilm.delete(edit);
            JOptionPane.showMessageDialog(frame, "Berhasil menghapus");
        }
        

        kembali();
    }
    
    public void deleteWatchList(int id){
        FilmModel edit = new FilmModel();
        
        edit.setJudul(frame.getTextJudul().getText());
        edit.setSinopsis(frame.getTextSinopsis().getText());
        edit.setTahun(Integer.parseInt(frame.getTextTahun().getText()));

        edit.setId(id);
        infcFilm.deleteWatchList(edit);
        JOptionPane.showMessageDialog(frame, "Berhasil menghapus watch list");
        

        kembali();
    }
    
    
    
    public void kembali(){
        frame.dispose();
        //frame2.dispose();
        new FilmView().setVisible(true);
        
    }
    
}
