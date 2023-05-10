package com.github.curriculeon;

public class GuessGamePlayerRepositoryLogger implements RepositoryLoggerInterface<Long, GuessGamePlayer> {
    private RepositoryInterface<Long, GuessGamePlayer> repository;

    public GuessGamePlayerRepositoryLogger() {
        this(new GuessGamePlayerRepository());
    }

    public GuessGamePlayerRepositoryLogger(RepositoryInterface<Long, GuessGamePlayer> repository) {
        this.repository = repository;
    }

    @Override
    public RepositoryInterface<Long, GuessGamePlayer> getRepository() {
        return this.repository;
    }
}
