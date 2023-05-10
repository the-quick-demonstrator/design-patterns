package com.github.curriculeon;

import java.util.List;
import java.util.function.Supplier;

public enum AccountService {
    INSTANCE;
    private final RepositoryInterface<Long, AccountEntity> accountRepository;
    private final InputOutputFacade io;

    AccountService(RepositoryInterface<Long, AccountEntity> accountRepository, InputOutputFacade io) {
        this.accountRepository = accountRepository;
        this.io = io;
    }

    AccountService() {
        this(new AccountRepositoryLogger(), new InputOutputFacade());
    }

    public AccountEntity add() {
        final Long id = io.getLongInput("Enter the id of the entity to be created");
        final String name = io.getStringInput("Enter the name of the entity to be created");
        final AccountEntity account = new AccountEntity(id, name);
        return accountRepository.add(account);
    }

    public AccountEntity delete() {
        final Long id = io.getLongInput("Enter the id of the entity to be created");
        return accountRepository.deleteById(id);
    }

    public AccountEntity update() {
        final Long id = io.getLongInput("Enter the new id of the entity to be updated");
        final String name = io.getStringInput("Enter the new name of the entity to be updated");
        final AccountEntity newData = new AccountEntity(id, name);
        return accountRepository.updateById(id, newData);
    }

    public AccountEntity read() {
        final Long id = io.getLongInput("Enter the new id of the entity to be read");
        return accountRepository.findById(id);
    }

    public List<AccountEntity> readAll() {
        return accountRepository.findAll();
    }
}
