package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FundTransferServiceTest {

    private AccountService accountService;
    private FundTransferService fundTransferService;

    @BeforeEach
    void setUp() {
        accountService = mock(AccountService.class);
        fundTransferService = new FundTransferService(accountService);
    }

    @Test
    void testTransferSuccess() {
        when(accountService.getBalance("A1")).thenReturn(1000.0);
        when(accountService.exists("A2")).thenReturn(true);
        when(accountService.debit("A1", 500.0)).thenReturn(true);
        when(accountService.credit("A2", 500.0)).thenReturn(true);

        String result = fundTransferService.transfer("A1", "A2", 500.0);
        assertEquals("SUCCESS: Transfer completed", result);
    }

    @Test
    void testTransferInsufficientFunds() {
        when(accountService.getBalance("A1")).thenReturn(200.0);

        String result = fundTransferService.transfer("A1", "A2", 500.0);
        assertEquals("FAILURE: Insufficient funds", result);
    }

    @Test
    void testTransferSameAccount() {
        String result = fundTransferService.transfer("A1", "A1", 100.0);
        assertEquals("FAILURE: Source and destination cannot be same", result);
    }

    @Test
    void testTransferInvalidAmount() {
        String result = fundTransferService.transfer("A1", "A2", -50.0);
        assertEquals("FAILURE: Invalid amount", result);
    }

    @Test
    void testTransferDestinationNotFound() {
        when(accountService.getBalance("A1")).thenReturn(1000.0);
        when(accountService.exists("A2")).thenReturn(false);

        String result = fundTransferService.transfer("A1", "A2", 100.0);
        assertEquals("FAILURE: Destination account not found", result);
    }

    @Test
    void testTransferTransactionError() {
        when(accountService.getBalance("A1")).thenReturn(1000.0);
        when(accountService.exists("A2")).thenReturn(true);
        when(accountService.debit("A1", 100.0)).thenReturn(false);
        when(accountService.credit("A2", 100.0)).thenReturn(true);

        String result = fundTransferService.transfer("A1", "A2", 100.0);
        assertEquals("FAILURE: Transaction error", result);
    }
}
