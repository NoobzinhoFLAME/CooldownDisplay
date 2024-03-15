package com.noobzinhoflame.CooldownDisplay.events.custom;

import com.noobzinhoflame.CooldownDisplay.events.CustomEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TimeSecondEvent extends CustomEvent {

    private TimeType type;

    public enum TimeType {

        MILLISECONDS
    }
}
