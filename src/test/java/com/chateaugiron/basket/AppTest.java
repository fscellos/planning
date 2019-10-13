package com.chateaugiron.basket;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

public class AppTest {

    static MatchSchedule unsolvedCourseSchedule;

    @BeforeAll
    public static void setUp() {

        unsolvedCourseSchedule = new MatchSchedule();

        for(int i = 0; i < 10; i++){
            unsolvedCourseSchedule.getMatchList().add(new Match());
        }

        unsolvedCourseSchedule.getPeriodList().addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
        unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(new Integer[] { 1, 2 }));
    }

    @Test
    public void test_whenCustomJavaSolver() {

        SolverFactory<MatchSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfiguration.xml");
        Solver<MatchSchedule> solver = solverFactory.buildSolver();
        MatchSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);        
        assertNotNull(solvedCourseSchedule.getScore());
        assertEquals(-4, solvedCourseSchedule.getScore().getHardScore());        
    }

    @Test
    public void test_whenDroolsSolver() {

        SolverFactory<MatchSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfigDrools.xml");
        Solver<MatchSchedule> solver = solverFactory.buildSolver();
        MatchSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);        
        assertNotNull(solvedCourseSchedule.getScore());
        assertEquals(0, solvedCourseSchedule.getScore().getHardScore());
    }
}