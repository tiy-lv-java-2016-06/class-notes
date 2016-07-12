package gametracker;

/**
 * Created by jeff on 7/12/16.
 */
public class Game {
    private String name;
    private String genre;
    private String platform;
    private int releaseYear;

    public Game(String name, String genre, String platform, int releaseYear) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
