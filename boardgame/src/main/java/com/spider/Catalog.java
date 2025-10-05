package com.spider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalog {
    private final List<BoardGame> games = new ArrayList<>();

    public boolean addGame(BoardGame game) {
        if (findGameByName(game.getName()).isPresent()) {
            return false; // Jogo já existe
        }
        return games.add(game);
    }

    public List<BoardGame> getAllGames() {
        return new ArrayList<>(games);
    }

    public Optional<BoardGame> findGameByName(String name) {
        return games.stream()
                .filter(game -> game.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
