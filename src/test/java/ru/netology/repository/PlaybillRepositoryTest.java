package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class PlaybillRepositoryTest {

    @Test
    void shouldSaveOneFilm() {
        Film first = new Film(1, "Titanic");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);

        Film[] expected = new Film[]{first};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveFewFilm() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);

        Film[] expected = new Film[]{first, second, third};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllWhenEmptySet() {
        PlaybillRepository repo = new PlaybillRepository();

        Film[] expected = new Film[]{};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");
        Film sixth = new Film(6, "Intouchables");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);


        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByExistingId() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);

        Film expected = third;
        Film actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNonexistentId() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);

        Film expected = null;
        Film actual = repo.findById(6);

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveByExistingId() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.removeById(3);

        Film[] expected = new Film[]{first, second, fourth};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNonexistentId() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.removeById(5);

        Film[] expected = new Film[]{first, second, third, fourth};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {

        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");
        Film sixth = new Film(6, "Intouchables");
        Film seventh = new Film(7, "Matrix");
        Film eighth = new Film(8, "Fight Club");

        PlaybillRepository repo = new PlaybillRepository();

        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        repo.save(seventh);
        repo.save(eighth);
        repo.removeAll();

        Film[] expected = new Film[]{};
        Film[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}