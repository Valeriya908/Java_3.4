package ru.netology.repository;

import ru.netology.domain.Film;

public class PlaybillRepository {
    private Film[] movies = new Film[0];

    public Film[] findAll() {
        return movies;
    }

    public void save(Film movie) {
        Film[] tmp = new Film[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public Film findById(int id) {
        for (Film movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public Film[] removeAll() {
        Film[] tmp = new Film[0];
        movies = tmp;
        return movies;
    }
}

