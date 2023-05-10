package com.github.curriculeon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public enum GuessGamePlayerServiceCommand {
    READ_ALL((ae) -> GuessGamePlayerService.INSTANCE.readAll()),
    ADD((ae) -> Collections.singletonList(GuessGamePlayerService.INSTANCE.add(ae))),
    READ((ae) -> Collections.singletonList(GuessGamePlayerService.INSTANCE.read(ae))),
    UPDATE((ae) -> Collections.singletonList(GuessGamePlayerService.INSTANCE.update(ae))),
    DELETE((ae) -> Collections.singletonList(GuessGamePlayerService.INSTANCE.delete(ae))),
    QUIT((ae) -> null);
    private final Function<AccountEntity, List<GuessGamePlayer>> command;

    GuessGamePlayerServiceCommand(Function<AccountEntity, List<GuessGamePlayer>> command) {
        this.command = command;
    }

    public List<GuessGamePlayer> perform(AccountEntity accountEntity) {
        return command.apply(accountEntity);
    }

    public static GuessGamePlayerServiceCommand getUserInput() {
        GuessGamePlayerServiceCommand command;
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

