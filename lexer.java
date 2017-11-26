/*
 * Name: Genie Nyiramana
 * Date: 4/12/2017
 * class: CSCI 240
 */

import java.util.Scanner;
import java.util.ArrayList;

public class lexer{

	public static ArrayList<String> mapping = new ArrayList<String>();
	//function goes through the expression given and returns tokens 
	//their names and values and their type.
	public static ArrayList<String> expressionLexer(String inputs){
		
		//parsing the input for the different tokens
		String[] parsing;
		inputs = inputs.replaceAll(" ", "");
		parsing = inputs.split("(?<=[-+*/=()])|(?=[-+*/=()])");
		
		//switch case to return the correct value, name and token type for each input
		for(String y: parsing){
			//y= y.trim();
		switch(y){
			case "(":
				mapping.add(Token.tokenType.T_LEFT_PAREN.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			case ")":
				mapping.add(Token.tokenType.T_RIGHT_PAREN.toString());
			mapping.add(Token.lexeme(y));
			mapping.add(Token.getValue(y));
				break;
			case "+":
				mapping.add(Token.tokenType.T_PLUS.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			case "-":
				mapping.add(Token.tokenType.T_MINUS.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			case "*":
				mapping.add(Token.tokenType.T_MULT.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			case "/":
				mapping.add(Token.tokenType.T_DIV.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			case "=":
				mapping.add(Token.tokenType.T_EQUALS.toString());
				mapping.add(Token.lexeme(y));
				mapping.add(Token.getValue(y));
				break;
			default:
				try{
					Double.parseDouble( y);
					mapping.add(Token.tokenType.T_DOUBLE.toString());
					mapping.add(Token.lexeme(y));
					mapping.add(Token.getValue(y));
					}
				   catch(Exception err)
				   {
						mapping.add(Token.tokenType.T_ID.toString());
						mapping.add(Token.lexeme(y));
						mapping.add(Token.getValue(y));
				   }
				
				break;
				}
			
		}
		
		return mapping;
	}
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		String input;
		input = in.nextLine();
		// creating list that will hold tokens
		ArrayList<String>lexemes = new ArrayList<String>();
		//calling expressionLexer to go through expression identify tokens
		lexemes = expressionLexer(input);
		
		System.out.printf("The expression %s %n", input);
		//formatting output
		System.out.println("Token type\t\tLexeme\t\t\tValue");
		System.out.println("===========================================================");
		int i = 0;
		while(i<lexemes.size()){
				System.out.printf(String.format("%-25s" + "%-24s"+"%s", lexemes.get(i), lexemes.get(i+1), lexemes.get(i+2)));
				i+=3;
				System.out.println();
			}
			
		}
	}
	
