/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.FilmModel;
import java.util.List;
/**
 *
 * @author ASUS
 */
public interface InterfaceFilm {
    public void insert(FilmModel film);

    public void update(FilmModel film);
    public void updateWatchList(FilmModel film);
    public void delete(FilmModel film);
    public void deleteWatchList(FilmModel film);

    public List<FilmModel> getDataFilm();
    public List<FilmModel> getDataWatchList();
    public List<FilmModel> getDetail(int id);
}
