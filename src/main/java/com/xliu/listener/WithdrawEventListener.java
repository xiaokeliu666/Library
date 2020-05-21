package com.xliu.listener;

import com.xliu.event.WithdrawEvent;
import org.springframework.context.ApplicationListener;

public class WithdrawEventListener implements ApplicationListener<WithdrawEvent> {
    public void onApplicationEvent(WithdrawEvent event) {
        String bankCardId = event.getBankCardID();

        String withdrawDate = event.getWithdrawDate();

        System.out.println("Receive withdraw event, bank info, card id : " + bankCardId + " , withdraw date : " + withdrawDate);
    }
}
