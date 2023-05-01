import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.GenreDAO;
import data.Database;
import data.DatabaseHikari;
import models.Album;
import models.Artist;
import tools.AlbumsImporter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        try {
//            var artists = new ArtistDAO();
//            Artist artist1 = new Artist("Ionel");
//            artists.create(artist1);
////            artists.create("Michael Jackson");
////            var genres = new GenreDAO();
////            genres.create("Rock"); //TODO: Funk, Soul, Pop
//            Database.getConnection().commit();
//            var albums = new AlbumDAO();
////            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
//            //findByName
//            Album album1 = new Album(2000, "Thriller", "Bon Jovi", Arrays.asList("Funk","Soul","Pop"));
//            albums.create(album1);
//
//            System.out.println(albums.findAll(Album.class).toString());
            AlbumsImporter.importData("C:\\Users\\Cerbu Cristi\\Desktop\\Anul 2, Semestrul 2\\Programare Avansata\\albumlist.csv");
            DatabaseHikari.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
