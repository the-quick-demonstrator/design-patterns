package com.github.curriculeon;

import com.github.curriculeon.arcade.AccountEntity;
import com.github.curriculeon.arcade.AccountRepository;
import org.junit.Assert;
import org.junit.Test;

public class AccountRepositoryTest {
    @Test
    public void testAddMethod() {
        // given
        final Long id = 15L;
        final String name = "Leon";
        final AccountEntity account = new AccountEntity(id, name);
        final AccountRepository accountRepository = new AccountRepository();

        // when
        final AccountEntity persistedAccount = accountRepository.add(account);

        // then
        Assert.assertEquals(id, persistedAccount.getId());
        Assert.assertEquals(name, persistedAccount.getName());
    }
}
