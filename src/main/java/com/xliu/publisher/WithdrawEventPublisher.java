package com.xliu.publisher;

import com.xliu.event.WithdrawEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawEventPublisher implements ApplicationEventPublisherAware {
    // Local ApplicationEventPublisher variable.
    private ApplicationEventPublisher eventPublisher;

    // Must override this method, Spring framework will inject ApplicationEventPublisher object automatically.

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void publishWithdrawEvent(String bankCardId, String withdrawDate)
    {
        System.out.println("Will publish withdraw event, card id : " + bankCardId + " , date : " + withdrawDate);
        // Instantiate a new WithdrawEvent object.
        WithdrawEvent wdEvent = new WithdrawEvent(this, bankCardId, withdrawDate);
        // Use Spring injected event publisher object to publish the event object.
        this.eventPublisher.publishEvent(wdEvent);
    }
}
