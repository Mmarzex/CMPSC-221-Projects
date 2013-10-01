package function;

public class CalculateTriple implements Function<Double, Double> {

	@Override
	public Double apply(Double parameter) {
		return (parameter * 3.0);
	}
	
}