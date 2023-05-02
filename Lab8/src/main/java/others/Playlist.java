package others;

import models.Album;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Playlist {

    private String name;
    private Timestamp createdTimestamp;
    private Set<Album> albums;

    public Playlist(String name, Set<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public Playlist(String name) {
        this.name = name;
        this.createdTimestamp = new Timestamp(System.currentTimeMillis());
        albums = new HashSet<>();
    }

    public Playlist() {
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", albums=" + albums +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
