package com.github.curriculeon;

public class GuessGamePlayerRepository implements FileRepositoryInterface<Long, GuessGamePlayer> {

    @Override
    public GuessGamePlayer parse(String line) {
        final String[] fields = line.split(",");
        final Long id = Long.parseLong(fields[0]);
        final String name = fields[1];
        final Integer numberOfGuesses = Integer.parseInt(fields[2]);
        return new GuessGamePlayer(id, name, numberOfGuesses);
    }
}
