package com.github.curriculeon;

public class AccountRepositoryLogger implements RepositoryLoggerInterface<Long, AccountEntity> {
    private final AccountRepository accountRepository;

    public AccountRepositoryLogger() {
        this(new AccountRepository());
    }

    public AccountRepositoryLogger(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public RepositoryInterface<Long, AccountEntity> getRepository() {
        return accountRepository;
    }
}
