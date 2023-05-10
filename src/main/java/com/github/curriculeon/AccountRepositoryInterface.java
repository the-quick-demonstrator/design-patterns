package com.github.curriculeon;

public interface AccountRepositoryInterface extends FileRepositoryInterface<Long, AccountEntity> {
    @Override
    default AccountEntity parse(String line) {
        final String[] fields = line.split(",");
        final Long id = Long.parseLong(fields[0]);
        final String name = fields[1];
        return new AccountEntity(id, name);
    }
}
