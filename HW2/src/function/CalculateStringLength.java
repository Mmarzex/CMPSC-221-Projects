package function;

public class CalculateStringLength implements Function<Integer, String> {

	@Override
	public Integer apply(String parameter) {
		return parameter.length();
	}
	
}