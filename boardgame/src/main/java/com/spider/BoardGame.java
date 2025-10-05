package com.spider;

import java.util.Objects;

public class BoardGame {
    private String name;
    private String publisher;
    private int minPlayers;
    private int maxPlayers;

    public BoardGame(String name, String publisher, int minPlayers, int maxPlayers) {
        this.name = name;
        this.publisher = publisher;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}