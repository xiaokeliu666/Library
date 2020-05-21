package com.xliu.listener;

import com.xliu.event.DepositEvent;
import org.springframework.context.ApplicationListener;

public class DepositEventListener implements ApplicationListener<DepositEvent> {
    public void onApplicationEvent(DepositEvent event) {
        String bankCardId = event.getBankCardID();

        String depositDate = event.getDepositDate();

        System.out.println("Receive deposit event, bank info, card id : " + bankCardId + " , deposit date : " + depositDate);

    }
}
