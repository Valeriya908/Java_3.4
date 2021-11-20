package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class PlaybillManagerTest {

    @Test
    public void shouldEmptySet() {
        PlaybillManager manager = new PlaybillManager();

        Film[] expected = new Film[]{};
        Film[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {
        Film first = new Film(1,"Titanic");

        PlaybillManager manager = new PlaybillManager();

        manager.addFilm(first);

        Film[] expected = new Film[]{first};
        Film[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFewMovie() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");

        PlaybillManager manager = new PlaybillManager();

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);

        Film[] expected = new Film[]{first, second, third};
        Film[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListRecentFilmBaseModifyRangeLimit() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");
        Film fourth = new Film(4,"Green Mile");
        Film fifth = new Film(5,"Lion King");
        Film sixth = new Film(6,"Intouchables");

        PlaybillManager manager = new PlaybillManager();

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);


        Film[] expected = new Film[]{sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListRecentFilmBaseModifyMax() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");
        Film fourth = new Film(4,"Green Mile");
        Film fifth = new Film(5,"Lion King");
        Film sixth = new Film(6,"Intouchables");
        Film seventh = new Film(7,"Matrix");
        Film eighth = new Film(8,"Fight Club");
        Film ninth = new Film(9,"Shrek");
        Film tenth = new Film(10,"Gladiator");

        PlaybillManager manager = new PlaybillManager();

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);


        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListRecentFilmBaseModifyOverMax() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");
        Film fourth = new Film(4,"Green Mile");
        Film fifth = new Film(5,"Lion King");
        Film sixth = new Film(6,"Intouchables");
        Film seventh = new Film(7,"Matrix");
        Film eighth = new Film(8,"Fight Club");
        Film ninth = new Film(9,"Shrek");
        Film tenth = new Film(10,"Gladiator");
        Film eleventh = new Film(11,"Soul");

        PlaybillManager manager = new PlaybillManager();

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListRecentFilmUserModify() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");
        Film fourth = new Film(4,"Green Mile");
        Film fifth = new Film(5,"Lion King");
        Film sixth = new Film(6,"Intouchables");
        Film seventh = new Film(7,"Matrix");
        Film eighth = new Film(8,"Fight Club");
        Film ninth = new Film(9,"Shrek");
        Film tenth = new Film(10,"Gladiator");
        Film eleventh = new Film(11,"Soul");

        PlaybillManager manager = new PlaybillManager(4);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldListRecentFilmUserModifyOverMax() {
        Film first = new Film(1,"Titanic");
        Film second = new Film(2,"Home Alone");
        Film third = new Film(3,"Eternals");
        Film fourth = new Film(4,"Green Mile");
        Film fifth = new Film(5,"Lion King");
        Film sixth = new Film(6,"Intouchables");
        Film seventh = new Film(7,"Matrix");
        Film eighth = new Film(8,"Fight Club");
        Film ninth = new Film(9,"Shrek");
        Film tenth = new Film(10,"Gladiator");
        Film eleventh = new Film(11,"Soul");

        PlaybillManager manager = new PlaybillManager(11);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);
        manager.addFilm(fifth);
        manager.addFilm(sixth);
        manager.addFilm(seventh);
        manager.addFilm(eighth);
        manager.addFilm(ninth);
        manager.addFilm(tenth);
        manager.addFilm(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }
}