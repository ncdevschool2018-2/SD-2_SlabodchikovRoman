package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleViewModel {
    private long id;
    private SlotViewModel slot;
    private DayViewModel day;
    private SubjectViewModel subject;

    public ScheduleViewModel() {
    }

    public ScheduleViewModel(long id, SlotViewModel slot, DayViewModel day, SubjectViewModel subject) {
        this.id = id;
        this.slot = slot;
        this.day = day;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SlotViewModel getSlot() {
        return slot;
    }

    public void setSlot(SlotViewModel slot) {
        this.slot = slot;
    }

    public DayViewModel getDay() {
        return day;
    }

    public void setDay(DayViewModel day) {
        this.day = day;
    }

    public SubjectViewModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectViewModel subject) {
        this.subject = subject;
    }
}
