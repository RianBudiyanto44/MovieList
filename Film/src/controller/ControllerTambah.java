/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoFilm;
import dao.InterfaceFilm;
import javax.swing.JOptionPane;
import model.FilmModel;
import view.FilmView;
import view.TambahForm;

/**
 *
 * @author ASUS
 */
public class ControllerTambah {
    TambahForm frame;
    InterfaceFilm infcFilm;
    
    public ControllerTambah(TambahForm frame) {
        this.frame = frame;
        infcFilm = new DaoFilm();
    }
    
    public void tambahData(){
        FilmModel film_baru = new FilmModel();
        film_baru.setJudul(frame.getTextJudul().getText());
        film_baru.setSinopsis(frame.getTextSinopsis().getText());
        film_baru.setTahun(Integer.parseInt(frame.getTextTahun().getText()));
        infcFilm.insert(film_baru);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan data baru");

        kembali();
    }
    
    public void kembali(){
        frame.dispose();
        //frame2.dispose();
        new FilmView().setVisible(true);
        
    }
}
