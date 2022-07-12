package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProcessingTest {

    @Test
    public void shouldTransferAmountFromFirstAccountToSecond(){
        Processing sut = new Processing();
        int firstDummyAccountId = 1;
        int secondDummyAccountId = 2;
        double dummyAmount = 50d;
        AccountRepository mockAccountRepository = mock(AccountRepository.class);
        Account firstMockAccount = mock(Account.class);
        Account secondMockAccount = mock(Account.class);

        when(mockAccountRepository.findAccountById(firstDummyAccountId)).thenReturn(firstMockAccount);
        when(mockAccountRepository.findAccountById(secondDummyAccountId)).thenReturn(secondMockAccount);
        when(firstMockAccount.getAmount()).thenReturn(dummyAmount);
        when(secondMockAccount.getAmount()).thenReturn(dummyAmount);

        assertTrue(
                sut.transfer(firstDummyAccountId, secondDummyAccountId, dummyAmount)
        );
    }
}