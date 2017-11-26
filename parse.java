import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class parse{
	LinkedList<String> tokensList;
	Token lookahead;
	String token;
	
	 private void nextToken()
	  {
	    tokensList.pop();
	    // at the end of input we return an epsilon token
	    if (tokensList.isEmpty())
	      token = "";
	    else
	     token = tokensList.getFirst();
	  }
	 public ExpressionNode parser(LinkedList<String> tokensList) throws Exception{
		 	for(String x: tokensList){
		 		this.tokensList = tokensList;
		 	}
		    this.token = this.tokensList.getFirst();

		    ExpressionNode expr = Expression();

		    return expr;
		    
		}
	 public ExpressionNode Expression() throws Exception{
			
		 ExpressionNode expr = Term();
			/*try{
				nextToken();
			}
			catch(NoSuchElementException e){
				System.out.println("noooo");
			}*/
		  return RestExpr(expr);
	}
	public ExpressionNode  RestExpr(ExpressionNode expr) throws Exception{
		switch(this.token){
		case"+":
		case "-":
			AddExpressionNode sum;
		    if (expr.getType() == ExpressionNode.expressionsnodes.ADD_NODE)
		      sum = (AddExpressionNode)expr;
		    else
		      sum = new AddExpressionNode(expr, true);

		    boolean positive = this.token.equals("+");
		    nextToken();
		    ExpressionNode t = Term();
		    sum.add(t, positive);
		    return RestExpr(sum);
		}		
		
		  // sum_op -> EPSILON
		  return expr;
	}
	public ExpressionNode Term() throws Exception{
		 ExpressionNode f = Factor();
		 return RestTerm(f);
	}

	private ExpressionNode RestTerm(ExpressionNode expression) throws Exception
	{// term_op -> MULTDIV factor term_op
		nextToken();
		switch(this.token){
		case"*":
		case"/":
		
			MultExpressionNode prod;

		    if (expression.getType() == ExpressionNode.expressionsnodes.MULT_NODE)
		      prod = (MultExpressionNode)expression;
		    else
		      prod = new MultExpressionNode(expression, true);

		    boolean positive = this.token.equals("*");
		    nextToken();
		    ExpressionNode f = Factor();
		    prod.add(f, positive);
		    return RestTerm(prod);
		  }


		return expression;
	}
	public ExpressionNode Factor() throws Exception{
		// factor -> argument factor_op
	    
	   if(this.token.equals("(")){
	      nextToken();
	      ExpressionNode expr = Expression();
	      if (!this.token.equals(")"))
	    	  throw new Exception("Closing brackets expected");
	      return expr;
	    }
	   else if (this.token.equals("-")){
		    boolean positive = this.token.equals("+");
		    nextToken();
		    ExpressionNode t = Factor();
		      return new AddExpressionNode(t, false);
		  }
	   else{
		   try{
			   Double.parseDouble( this.token );
			   ExpressionNode a = new DoubleExpressionNode(this.token);
			    return a;
		   		}
		   catch(NumberFormatException e){
			   if(SymbolTable.symbols.containsKey(this.token)){
				   ExpressionNode expr = new IDExpressionNode(this.token);
				   return new DoubleExpressionNode(SymbolTable.FindSymbol(this.token));
			   } 
			   else{
				   String name = this.token;
				   ExpressionNode expr = new IDExpressionNode(this.token);
			    	nextToken();
			    	if(this.token.equals("=")){
			    		try{nextToken();}
			    		catch(Exception err){
			    			System.out.println("Missing Right hand assignment");
						    System.exit(0);
			    		}
			    		SymbolTable.AddSymbol(name, this.token);
			    		return new DoubleExpressionNode(this.token);
			    	}
			    	else{
					    System.out.println("not declared");
					    System.exit(0);
					   } 
			   }
			    
			    return null;
			   }
		   
		   }
	   
	  }
	
	public static void main(String[] args) throws Exception{
		parse parser = new parse();

		String input = "3+2";
		 input = input.replaceAll(" ", "");
		 String[] array; 
		 array = input.split("(?<=[-+*/=()])|(?=[-+*/=()])");
		 LinkedList<String> listToken = new LinkedList<String>();
		 int i = 0;
			while(i<array.length){
				listToken.add(array[i]);
				i++;
				System.out.println(listToken);
			}
			
		   ExpressionNode expression = parser.parser(listToken);
		   System.out.println("The value of the expression is "+String.format("%1$,.4f",expression.getValue()));
	}
	}