package com.chateaugiron.basket;

import java.util.Arrays;

import javax.annotation.Resource;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanningCalculation implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(PlanningCalculation.class);	
	
	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(PlanningCalculation.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Resource
	public PeriodProvider pp; 
	
	@Override
	public void run(String... args) throws Exception {
		MatchSchedule unsolvedCourseSchedule = new MatchSchedule();
		for (int i = 0; i < 10; i++) {
			unsolvedCourseSchedule.getMatchList().add(new Match());
		}

		unsolvedCourseSchedule.getPeriodList().addAll(pp.getPeriod());
		unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(new Integer[] { 1, 2 }));

		SolverFactory<MatchSchedule> solverFactory = SolverFactory
				.createFromXmlResource("courseScheduleSolverConfiguration.xml");
		Solver<MatchSchedule> solver = solverFactory.buildSolver();
		MatchSchedule solvedCourseSchedule = solver.solve(unsolvedCourseSchedule);

		solvedCourseSchedule.printCourseSchedule();		
	}
}
