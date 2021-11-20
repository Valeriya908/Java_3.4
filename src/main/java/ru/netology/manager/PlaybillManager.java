package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Film;
import ru.netology.repository.PlaybillRepository;

@Data
//@NoArgsConstructor
//@AllArgsConstructor

public class PlaybillManager {
    private PlaybillRepository repository;
    private int quantityFilm = 10;

    public PlaybillManager(PlaybillRepository repository) {
        this.repository = repository;
    }

    public PlaybillManager(PlaybillRepository repository, int quantityFilm) {
        this.quantityFilm = quantityFilm;
        this.repository = repository;
    }

    public void addFilm(Film movie) {
        repository.save(movie);
    }

    public Film[] findAllFilm() {
        return repository.findAll();
    }

    public Film[] listRecentFilm() {
        int resultLength;
        if (quantityFilm < repository.findAll().length) {
            resultLength = quantityFilm;
        } else {
            resultLength = repository.findAll().length;
        }
        Film[] movies = repository.findAll();
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
