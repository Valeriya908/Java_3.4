package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.repository.PlaybillRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class PlaybillManagerTest {

    @Test
    void shouldAddEmptySet() {

        PlaybillRepository repo = new PlaybillRepository();
        PlaybillManager manager = new PlaybillManager(repo);

        Film[] expected = new Film[]{};
        Film[] actual = manager.findAllFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneFilm() {
        Film first = new Film(1, "Titanic");

        PlaybillRepository repo = new PlaybillRepository();
        PlaybillManager manager = new PlaybillManager(repo);

        manager.addFilm(first);

        Film[] expected = new Film[] {first};
        Film[] actual = manager.findAllFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddFewFilm() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");

        PlaybillRepository repo = new PlaybillRepository();
        PlaybillManager manager = new PlaybillManager(repo);

        manager.addFilm(first);
        manager.addFilm(second);
        manager.addFilm(third);
        manager.addFilm(fourth);

        Film[] expected = new Film[] {first, second, third, fourth};
        Film[] actual = manager.findAllFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldListRecentFilmBaseModifyRangeLimit() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");
        Film sixth = new Film(6, "Intouchables");

        PlaybillRepository repo = Mockito.mock(PlaybillRepository.class);
        PlaybillManager manager = new PlaybillManager(repo);

        Film[] returned = {first, second, third, fourth, fifth, sixth};
        doReturn(returned).when(repo).findAll();

        Film[] expected = new Film[]{sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldListRecentFilmBaseModifyMax() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");
        Film sixth = new Film(6, "Intouchables");
        Film seventh = new Film(7, "Matrix");
        Film eighth = new Film(8, "Fight Club");
        Film ninth = new Film(9, "Shrek");
        Film tenth = new Film(10, "Gladiator");

        PlaybillRepository repo = Mockito.mock(PlaybillRepository.class);
        PlaybillManager manager = new PlaybillManager(repo);

        Film[] returned = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repo).findAll();

        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

        @Test
        void shouldListRecentFilmBaseModifyOverMax () {
            Film first = new Film(1, "Titanic");
            Film second = new Film(2, "Home Alone");
            Film third = new Film(3, "Eternals");
            Film fourth = new Film(4, "Green Mile");
            Film fifth = new Film(5, "Lion King");
            Film sixth = new Film(6, "Intouchables");
            Film seventh = new Film(7, "Matrix");
            Film eighth = new Film(8, "Fight Club");
            Film ninth = new Film(9, "Shrek");
            Film tenth = new Film(10, "Gladiator");
            Film eleventh = new Film(11,"Soul");

            PlaybillRepository repo = Mockito.mock(PlaybillRepository.class);
            PlaybillManager manager = new PlaybillManager(repo);

            Film[] returned = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
            doReturn(returned).when(repo).findAll();

            Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
            Film[] actual = manager.listRecentFilm();

            assertArrayEquals(expected, actual);
        }

    @Test
    void shouldListRecentFilmUserModify() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");

        PlaybillRepository repo = Mockito.mock(PlaybillRepository.class);
        PlaybillManager manager = new PlaybillManager(repo, 5);

        Film[] returned = {first, second, third, fourth, fifth};
        doReturn(returned).when(repo).findAll();

        Film[] expected = new Film[]{fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldListRecentFilmUserModifyOverMax() {
        Film first = new Film(1, "Titanic");
        Film second = new Film(2, "Home Alone");
        Film third = new Film(3, "Eternals");
        Film fourth = new Film(4, "Green Mile");
        Film fifth = new Film(5, "Lion King");
        Film sixth = new Film(6, "Intouchables");
        Film seventh = new Film(7, "Matrix");
        Film eighth = new Film(8, "Fight Club");
        Film ninth = new Film(9, "Shrek");
        Film tenth = new Film(10, "Gladiator");
        Film eleventh = new Film(11,"Soul");

        PlaybillRepository repo = Mockito.mock(PlaybillRepository.class);
        PlaybillManager manager = new PlaybillManager(repo, 11);

        Film[] returned = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        doReturn(returned).when(repo).findAll();

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.listRecentFilm();

        assertArrayEquals(expected, actual);
    }


    }