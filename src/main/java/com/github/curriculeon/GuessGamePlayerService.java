package com.github.curriculeon;

import java.util.List;

public enum GuessGamePlayerService {
    INSTANCE;
    private final RepositoryInterface<Long, GuessGamePlayer> accountRepository;
    private final InputOutputFacade io;

    GuessGamePlayerService(RepositoryInterface<Long, GuessGamePlayer> accountRepository, InputOutputFacade io) {
        this.accountRepository = accountRepository;
        this.io = io;
    }

    GuessGamePlayerService() {
        this(new GuessGamePlayerRepositoryLogger(), new InputOutputFacade());
    }

    public GuessGamePlayer add(AccountEntity accountEntity) {
        final GuessGamePlayer player = new GuessGamePlayer(accountEntity.getId(), accountEntity.getName(), 0);
        return accountRepository.add(player);
    }

    public GuessGamePlayer delete(AccountEntity accountEntity) {
        return accountRepository.deleteById(accountEntity.getId());
    }

    public GuessGamePlayer update(AccountEntity accountEntity) {
        final String name = io.getStringInput("Enter the new name of the entity to be updated");
        final Integer numberOfGuesses = io.getIntegerInput("Enter the new number of guesses of the entity to be updated");
        final GuessGamePlayer newData = new GuessGamePlayer(accountEntity.getId(), name, numberOfGuesses);
        return accountRepository.updateById(accountEntity.getId(), newData);
    }

    public GuessGamePlayer read(AccountEntity accountEntity) {
        return accountRepository.findById(accountEntity.getId());
    }

    public List<GuessGamePlayer> readAll() {
        return accountRepository.findAll();
    }
}
