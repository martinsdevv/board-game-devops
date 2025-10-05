package com.spider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class CatalogTest {

    private Catalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
    }

    @Test
    void testAddGameSuccessfully() {
        BoardGame catan = new BoardGame("Catan", "Devir", 3, 4);
        assertTrue(catalog.addGame(catan), "Deveria ser possível adicionar um novo jogo.");
        assertEquals(1, catalog.getAllGames().size(), "O catálogo deveria ter 1 jogo após a adição.");
    }

    @Test
    void testAddDuplicateGame() {
        BoardGame catan1 = new BoardGame("Catan", "Devir", 3, 4);
        BoardGame catan2 = new BoardGame("Catan", "Kosmos", 3, 4); // Mesmo nome
        
        catalog.addGame(catan1);
        assertFalse(catalog.addGame(catan2), "Não deveria ser possível adicionar um jogo com nome duplicado.");
        assertEquals(1, catalog.getAllGames().size(), "O tamanho do catálogo não deveria mudar.");
    }

    @Test
    void testFindGameByName() {
        BoardGame azul = new BoardGame("Azul", "Galápagos", 2, 4);
        catalog.addGame(azul);

        Optional<BoardGame> foundGame = catalog.findGameByName("Azul");
        assertTrue(foundGame.isPresent(), "O jogo 'Azul' deveria ser encontrado.");
        assertEquals("Azul", foundGame.get().getName());
    }

    @Test
    void testFindGameByName_NotFound() {
        Optional<BoardGame> notFoundGame = catalog.findGameByName("Ticket to Ride");
        assertFalse(notFoundGame.isPresent(), "Um jogo que não está no catálogo não deveria ser encontrado.");
    }
}
