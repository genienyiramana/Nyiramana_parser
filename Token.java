/*
 * Name: Genie Nyiramana
 * Date: 4/12/2017
 * class: CSCI 240
 */

public class Token{
	public static enum tokenType {T_LEFT_PAREN, T_RIGHT_PAREN, 
		T_PLUS, T_MINUS, T_MULT, T_DIV, T_ID, T_EQUALS, T_DOUBLE, 
		T_EPSILON};

	public tokenType t;
	public String s;
	
	//constructor
	public Token(tokenType t, String s){
		this.t = t;
		this.s = s;
	}
	
	//function to return the value of each token
	public static String getValue(String val){
		switch(val){
		case "(":
		case ")":
		case "+":
		case "-":
		case "*":
		case "/":
		case "=":
			return String.format("%1$,.3f", 0.0);
		default:
			//particularly for variables and doubles
			try{
				// returns value of double if it is indeed a double
				Double.parseDouble( val );
				return String.format("%1$,.3f", Double.parseDouble(val));
			}
			   catch(Exception err)
			   {
				   		//exit program and tell the user if the wrong thing was given or 
				   		//return the value of the string ID for variables
				   	 if(val.contains("!") || val.contains("@") ||val.contains("#")||val.contains("$")||val.contains("%")
				   			||val.contains("^")||val.contains("*") ||val.contains("(")||val.contains(")")||val.contains("|")
				   			||val.contains("-")||val.contains("+")||val.contains(":")||val.contains(";")||val.contains("{")
				   			||val.contains("[")||val.contains("}")||val.contains("]")||val.contains("\"")||val.contains("\\")
				   			||val.contains("'")||val.contains("<")||val.contains(">")||val.contains(",")
				   			||val.contains(".")||val.contains("/")||val.contains("?")){
				   		 System.out.println(val + " is an unacceptable");
				   		 System.exit(0);
				   	 }
				   	 
			   		 return  String.format("%1$,.3f", 0.0);

			   }
			}
		}
	//returns the token that was given by user
	public static String lexeme(String name){
		return name;
	}
	
	@Override
	public String toString(){
		return t.toString();
	}
	
}