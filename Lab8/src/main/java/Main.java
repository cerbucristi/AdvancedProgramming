import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.GenreDAO;
import data.Database;
import models.Album;
import models.Artist;

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
            var albums = new AlbumDAO();
//            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            Album album1 = new Album(2000, "Thriller", "Bon Jovi", Arrays.asList("Funk","Soul","Pop"));
            albums.create(album1);

            Database.getConnection().commit();
            System.out.println(albums.findAll(Album.class).toString());
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
