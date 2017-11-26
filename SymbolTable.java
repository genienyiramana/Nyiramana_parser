import java.util.Map;
import java.util.HashMap;

public class SymbolTable{
	
	static Map<String, String> symbols = new HashMap<String, String>();
	/*String symbol;
	double value;
	public SymbolTable(String symbol, double value){
		this.symbol = symbol;
		this.value = value;
	}*/
	public static void AddSymbol(String symbol, String value){
		symbols.put(symbol, value);
	}
	
	public static String FindSymbol(String Symbol){
		if(symbols.containsKey(Symbol)){
			return symbols.get(Symbol);
		}
		else{
			System.out.println(Symbol+" has not been declared");
			System.exit(0);
		}
		return "";
	}
}