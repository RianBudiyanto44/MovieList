/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ASUS
 */
public class TableFilmModel extends AbstractTableModel{
    List<FilmModel> list_film;

    public TableFilmModel(List<FilmModel> list_film) {
        this.list_film = list_film;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return list_film.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Tahun";
            case 3:
                return "Status_watched";
            case 4:
                return "Sinopsis";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_film.get(row).getId();
            case 1:
                return list_film.get(row).getJudul();
            case 2:
                return list_film.get(row).getTahun();
            case 3:
                return list_film.get(row).getStatusWatch();
            case 4:
                return list_film.get(row).getSinopsis();
            default:
                return null;
        }
    }
}
