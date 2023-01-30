package song;

import java.util.ArrayList;

public class PocuTunes {
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playlists;

    public PocuTunes() {
        this(new ArrayList<Song>(), new ArrayList<Playlist>());
    }

    public PocuTunes(ArrayList<Song> songs, ArrayList<Playlist> playlists) {
        this.songs = songs;
        this.playlists = playlists;
    }

    public int getSongCount() {
        return this.songs.size();
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void addPlayList(Playlist playlist) {
        this.playlists.add(playlist);
    }

    private Song findSongOrNull(String songName) {
        for (Song song : this.songs) {
            if (songName.equals(song.getName())) {
                return song;
            }
        }
        return null;
    }

    private Playlist findPlaylistOrNull(String playListName) {
        for (Playlist playlist : this.playlists) {
            if (playlist.equals(playlist.getName())) {
                return playlist;
            }
        }
        return null;
    }

    public boolean removeSong(String songName) {
        for (Playlist playlist : this.playlists) {
            playlist.removeSong(songName);
        }

        Song songOrNull = findSongOrNull(songName);

        if (songOrNull == null) {
            return false;
        }

        this.songs.remove(songOrNull);
        return true;
    }

    public boolean removePlayList(String playlistName) {
        for (Playlist playlist : this.playlists) {
            if (playlistName.equals(playlist.getName())) {
                this.playlists.remove(playlist);
                return true;
            }
        }
        return false;
    }

    public void playPlayList(String playlistName) {
        Playlist playlist = findPlaylistOrNull(playlistName);

        if (playlist == null) {
            System.out.println(String.format("PlayList %s not found!", playlistName));
            return;
        }
        playlist.play();
    }

    public void playSong(String songName) {
        Song song = findSongOrNull(songName);

        if (song == null) {
            System.out.println(String.format("Song not found"));
            return;
        }
        song.play();
    }
}
