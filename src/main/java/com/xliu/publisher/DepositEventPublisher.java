package com.xliu.publisher;

import com.xliu.event.DepositEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class DepositEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void publishDepositEvent(String bankCardId, String depositDate) {
        System.out.println("Will publish deposit event, card id : " + bankCardId + " , date : " + depositDate);
        // Instantiate a new DepositEvent object.
        DepositEvent dEvent = new DepositEvent(this, bankCardId, depositDate);
        // Use Spring injected event publisher to publish the event object.
        this.eventPublisher.publishEvent(dEvent);
    }
}
