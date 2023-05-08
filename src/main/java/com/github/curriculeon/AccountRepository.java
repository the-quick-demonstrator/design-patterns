package com.github.curriculeon;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepository implements RepositoryInterface<Long, AccountEntity> {

    private final ReadWriteFacade rw;

    public AccountRepository() {
        final String fileName = getClass().getSimpleName();
        this.rw = DirectoryReference.RESOURCES.getReadWriteFacade("/" + fileName + ".csv");
    }

    @Override
    public List<AccountEntity> findAll() {
        return rw
                .toLines()
                .stream()
                .map(line -> {
                    try {
                        final String[] fields = line.split(",");
                        final Long id = Long.parseLong(fields[0]);
                        final String name = fields[1];
                        return new AccountEntity(id, name);
                    } catch(Throwable t) {
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public AccountEntity add(AccountEntity accountEntity) {
        final Long id = accountEntity.getId();
        if (findById(id) != null) {
            final String errorMessage = "An account entity with an id of %s already exists";
            throw new IllegalArgumentException(String.format(errorMessage, id));
        }
        rw.write(accountEntity.toString(), true);
        return findById(id);
    }

    @Override
    public AccountEntity delete(AccountEntity accountEntity) {
        rw.replaceAllOccurrences(accountEntity.toString(), "");
        return findById(accountEntity.getId());
    }

    @Override
    public AccountEntity updateById(Long id, AccountEntity newData) {
        final AccountEntity accountToDelete = findById(id);
        rw.replaceAllOccurrences(accountToDelete.toString(), newData.toString());
        return findById(id);
    }
}
