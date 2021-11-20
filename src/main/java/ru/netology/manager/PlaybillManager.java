package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Film;

@Data
//@NoArgsConstructor
//@AllArgsConstructor

public class PlaybillManager {
    private Film[] movies = new Film[0];
    private int quantityFilm = 10;

    public PlaybillManager() {
    }

    public PlaybillManager(int quantityFilm) {
        this.quantityFilm = quantityFilm;
    }

    public void addFilm(Film movie) {
        Film[] tmp = new Film[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Film[] getMovies() {
        return movies;
    }

    public Film[] listRecentFilm() {
        int resultLength;
        if (quantityFilm < movies.length) {
            resultLength = quantityFilm;
        } else {
            resultLength = movies.length;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}

