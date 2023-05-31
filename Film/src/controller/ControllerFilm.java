/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DaoFilm;
import dao.InterfaceFilm;
import java.util.List;
import model.FilmModel;
import model.TableFilmModel;
import view.DetailForm;
import view.FilmView;
import view.TambahForm;
/**
 *
 * @author ASUS
 */
public class ControllerFilm {
    FilmView frame;
    InterfaceFilm infcFilm;
    List<FilmModel> list_film;
    List<FilmModel> watch_list;
    //List<FilmModel> detail;

    public ControllerFilm(FilmView frame) {
        this.frame = frame;

        infcFilm = new DaoFilm();
        list_film = infcFilm.getDataFilm();
        watch_list = infcFilm.getDataWatchList();
        //detail = infcFilm.getDetail(id);
    }
    
    public void load_table() {
        TableFilmModel tfm = new TableFilmModel(list_film);
        frame.getTabelFilm().setModel(tfm);
        
        TableFilmModel tfm2 = new TableFilmModel(watch_list);
        frame.getTabelWatchList().setModel(tfm2);
        
    }

    public void detail(int id) {
        TableFilmModel tfm = new TableFilmModel(list_film);
        frame.getTabelFilm().setModel(tfm);
    }
    
    public void halaman_detail(int row, int status){
        FilmModel film = list_film.get(row);
        //frame.dispose();
        new DetailForm(film, status).setVisible(true);
    }
    
    public void halaman_tambah(){
        //FilmModel film = list_film.get(row);
        //frame.dispose();
        new TambahForm().setVisible(true);
    }
    
    
}
