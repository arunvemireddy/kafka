package link.arunv.kafka.model;

public class Movies {
    int id;
    String movie_name;
    String director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", movie_name='" + movie_name + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}
