package com.github.curriculeon;

import java.util.StringJoiner;

public class GuessGamePlayer implements EntityInterface<Long> {
    private Long id;
    private String name;
    private Integer numberOfGuesses;

    public GuessGamePlayer(Long id, String name, Integer numberOfGuesses) {
        this.id = id;
        this.name = name;
        this.numberOfGuesses = numberOfGuesses;
    }

    public GuessGamePlayer(AccountEntity account, Integer numberOfGuesses) {
        this(account.getId(), account.getName(), numberOfGuesses);
    }

    public GuessGamePlayer(AccountEntity account) {
        this(account, 0);
    }

    @Override
    public String toString() {
        return new StringJoiner(",")
                .add(id.toString())
                .add(name)
                .add(numberOfGuesses.toString())
                .toString()
                .concat("\n");
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void setNumberOfGuesses(Integer numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }
}
