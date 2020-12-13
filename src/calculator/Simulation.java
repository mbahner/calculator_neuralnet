package calculator;

import java.util.Set;
import java.util.List;
import java.util.Map;

public class Simulation {
	
	private Set<DataPoint> trainingSet;
	
	private Calculator topPreformer;
	private Map<Calculator, Integer> rankingMap;
	
	/**
	 * Start a simulation of calculators
	 * @param bitLength max number of calculated bits
	 * @param calculatorDepth number of transistor layers
	 * @param generationSize the number of calculators in each generationn
	 * @param survivorsPerGeneration the percent of the population that gets to reproduce
	 * @param trainingSetSize number of training set DataPoints
	 */
	public Simulation(int bitLength, int calculatorDepth, int generationSize, double survivorsPerGeneration, int trainingSetSize) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * fill errorMap with randomly generated calculators
	 */
	private void populateGenesis() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * get the set of best performing calculators
	 * @return set of length survivorsPerGeneration that are the calculators with the smallest errors
	 */
	public Set<Calculator> getSurvivors() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * re-populate rankingMap with a generation produced from breeding
	 * @param parents calculators that will be bred
	 */
	public void breed(Set<Calculator> parents) {
		throw new UnsupportedOperationException();
	}
}
