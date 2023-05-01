package tools;

import dao.AlbumDAO;
import models.Album;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AlbumsImporter {

    public static void importData(String filePath) throws SQLException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int year = Integer.parseInt(values[1]);
                String title = values[2];
                String artist = values[3];
                String[] genres = values[4].split(";");

                Album album = new Album();
                album.setReleaseYear(year);
                album.setTitle(title);
                album.setArtist(artist);
                album.setGenreNames(List.of(genres));

                AlbumDAO albumDAO = new AlbumDAO();
                albumDAO.create(album);
            }
        }
    }
}






