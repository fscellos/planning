package com.chateaugiron.basket;


import java.util.Arrays;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 MatchSchedule unsolvedCourseSchedule = new MatchSchedule();
    	 for(int i = 0; i < 10; i++){
             unsolvedCourseSchedule.getMatchList().add(new Match());
         }

         unsolvedCourseSchedule.getPeriodList().addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
         unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(new Integer[] { 1, 2 }));
    	
    	 SolverFactory<MatchSchedule> solverFactory = SolverFactory.createFromXmlResource("courseScheduleSolverConfiguration.xml");
         Solver<MatchSchedule> solver = solverFactory.buildSolver();
         MatchSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);
         
         solvedCourseSchedule.printCourseSchedule();
         System.out.println("OKI");
    }
}
