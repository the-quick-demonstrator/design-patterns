package com.github.curriculeon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public enum AccountServiceCommand {
    READ_ALL(AccountService.INSTANCE::readAll),
    ADD(() -> Collections.singletonList(AccountService.INSTANCE.add())),
    READ(() -> Collections.singletonList(AccountService.INSTANCE.read())),
    UPDATE(() -> Collections.singletonList(AccountService.INSTANCE.update())),
    DELETE(() -> Collections.singletonList(AccountService.INSTANCE.delete())),
    QUIT(() -> null);
    private final Supplier<List<AccountEntity>> command;

    AccountServiceCommand(Supplier<List<AccountEntity>> command) {
        this.command = command;
    }

    public List<AccountEntity> perform() {
        return command.get();
    }

    public static AccountServiceCommand getUserInput() {
        AccountServiceCommand command;
        final InputOutputFacade io = new InputOutputFacade();
        final Enum[] enumerations = values();
        final String commands = Arrays.toString(enumerations);
        io.println("Welcome to the %s Menu!", enumerations[0].getClass().getSimpleName());
        io.println("From here, you can enter any of the following commands");
        final String accountRepositoryDecision = io.getStringInput(commands);
        command = valueOf(accountRepositoryDecision.toUpperCase());
        return command;
    }
}
