package com.xliu.event;

import org.springframework.context.ApplicationEvent;

public class WithdrawEvent extends ApplicationEvent {
    private String bankCardID;
    private String withdrawDate;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public WithdrawEvent(Object source, String bankCardID, String withdrawDate) {
        super(source);
        this.bankCardID = bankCardID;
        this.withdrawDate = withdrawDate;
    }

    public String getBankCardID() {
        return bankCardID;
    }

    public void setBankCardID(String bankCardID) {
        this.bankCardID = bankCardID;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        this.withdrawDate = withdrawDate;
    }
}
