package function;

public class CalculateSuccessor implements Function<Integer, Integer> {

	@Override
	public Integer apply(Integer parameter) {
		return (parameter + 1);
	}
	
}