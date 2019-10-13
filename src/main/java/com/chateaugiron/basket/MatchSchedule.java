package com.chateaugiron.basket;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PlanningSolution
public class MatchSchedule {

    Logger logger = LoggerFactory.getLogger("MatchSchedule");

    private List<Integer> roomList;
    private List<Integer> periodList;
    private List<Match> matchList;
    private HardSoftScore score;

    public MatchSchedule(){
        roomList = new ArrayList<>();
        periodList = new ArrayList<>();
        matchList = new ArrayList<>();
    }

    @ValueRangeProvider(id = "availableRooms")
    @ProblemFactCollectionProperty
    public List<Integer> getRoomList() {
        return roomList;
    }

    @ValueRangeProvider(id = "availablePeriods")
    @ProblemFactCollectionProperty
    public List<Integer> getPeriodList() {
        return periodList;
    }

    @PlanningEntityCollectionProperty
    public List<Match> getMatchList() {
        return matchList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public void printCourseSchedule() {
        matchList.stream()
                .map(c -> "Lecture in Room " + c.getRoomNumber().toString() + " during Period " + c.getPeriod().toString())
                .forEach(k -> System.out.println(k));
    }
}
