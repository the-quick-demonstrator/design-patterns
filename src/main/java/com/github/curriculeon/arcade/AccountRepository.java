package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.CsvRepositoryInterface;

public class AccountRepository implements CsvRepositoryInterface<Long, AccountEntity> {

    @Override
    public AccountEntity parse(String line) {
        try {
            final String[] fields = line.split(",");
            final Long id = Long.parseLong(fields[0]);
            final String name = fields[1];
            return new AccountEntity(id, name);
        } catch(Throwable t) {
            return null;
        }
    }
}
