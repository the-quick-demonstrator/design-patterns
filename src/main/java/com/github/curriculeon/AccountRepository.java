package com.github.curriculeon;

import java.util.List;

public class AccountRepository implements RepositoryInterface<Long, AccountEntity> {
    @Override
    public List<AccountEntity> findAll() {
        return null;
    }

    @Override
    public AccountEntity add(AccountEntity accountEntity) {
        return null;
    }

    @Override
    public AccountEntity delete(AccountEntity accountEntity) {
        return null;
    }

    @Override
    public AccountEntity updateById(Long id, AccountEntity newData) {
        return null;
    }
}
