package com.github.curriculeon;

public class MainApplication {
    public static void main(String[] args) {
        final InputOutputFacade io = new InputOutputFacade();
        final AccountRepositoryFacade accountRepositoryFacade = new AccountRepositoryFacade();

        io.println("Welcome to the Account Manager Menu!");
        io.println("From here, you can select any of the following:");
        final String accountMenuDecision = io.getStringInput("[ login ], [ create ], [ delete ]");
        if("login".equalsIgnoreCase(accountMenuDecision)) {
            final AccountEntity accountEntity = accountRepositoryFacade.readById();
            io.println("Welcome to the Game Selection Menu!");
            io.println("From here, you can select any of the following:");
            final String gameSelectionMenu = io.getStringInput("[ guess ], [ high-low ]");
            if("guess".equalsIgnoreCase(gameSelectionMenu)) {
                new GuessGame(accountEntity).play();
            } else if("high-low".equalsIgnoreCase(gameSelectionMenu)) {
                new HighLowGame(accountEntity).play();
            }
        } else if("create".equalsIgnoreCase(accountMenuDecision)) {
            accountRepositoryFacade.add();
        } else if("delete".equalsIgnoreCase(accountMenuDecision)) {
            accountRepositoryFacade.delete();
        }

    }
}
