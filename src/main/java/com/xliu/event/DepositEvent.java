package com.xliu.event;

import org.springframework.context.ApplicationEvent;

public class DepositEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    private String bankCardID;
    private String depositDate;

    public String getBankCardID() {
        return bankCardID;
    }

    public void setBankCardID(String bankCardID) {
        this.bankCardID = bankCardID;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public DepositEvent(Object source, String bankCardID, String depositDate) {
        super(source);
        this.bankCardID = bankCardID;
        this.depositDate = depositDate;
    }
}
