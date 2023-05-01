package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Album extends AbstractDataModel{

    private int releaseYear;
    private String title;
    private String artist;
    private List<String> genreNames;

    public Album() {
    }

    public Album(int releaseYear, String title, String artist, List<String> genreNames) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genreNames = genreNames;
    }

    @Override
    public void loadObjectFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.releaseYear = rs.getInt("release_year");
        this.title = rs.getString("title");
        this.artist = rs.getString("artist");
        Object[] genresObjArray = (Object[]) rs.getArray("genres").getArray();
        this.genreNames = Arrays.stream(Arrays.copyOf(genresObjArray, genresObjArray.length, String[].class)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Album{" +
                "releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genreNames=" + genreNames +
                ", id=" + id +
                '}' + "\n";
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }

}
