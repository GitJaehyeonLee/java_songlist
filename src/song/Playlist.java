package song;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    private Song findSongOrNull(String songName) {
        for (Song song: this.songs) {
            if (songName.equals(song.getName())) {
                return song;
            }
        }
        return null;
    }

    public boolean removeSong(String songName) {
        Song song = findSongOrNull(songName);

        if (song == null) {
            return false;
        }

        this.songs.remove(song);
        return true;
    }

    public void play() {
        System.out.println(String.format("---Playing %s ---", this.name));

        for (Song song : songs) {
            song.play();
        }

        System.out.println("--Done--");
    }
}
