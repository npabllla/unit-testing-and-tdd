package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Client {
    private int id;
    private String name;
    private Collection<Account> accounts = new ArrayList<>(); //TODO

    public Client(int id, String name) {
        if (id == 0 || id < 0) throw new IllegalArgumentException("Client id should not be zero or negative");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Client name should not be null or empty");

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Account> getAccounts() {
        return this.accounts;
    }

    public void addAccount(Account newAccount) {
        if (newAccount == null) throw new IllegalArgumentException("");
        if (newAccount.getClient().id != this.id) throw new IllegalArgumentException("");

        accounts.add(newAccount);
    }

    public void printAccountIds() {
        this.accounts.forEach(
                account -> System.out.println(account.getId())
        );
    }
}
