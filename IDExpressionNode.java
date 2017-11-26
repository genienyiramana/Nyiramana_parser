public class IDExpressionNode implements ExpressionNode {
	private String name;
	  private double value;
	  private boolean valueSet;

	  public IDExpressionNode(String name) {
	    this.name = name;
	    valueSet = false;
	  }

	  public expressionsnodes getType() {
	    return ExpressionNode.expressionsnodes.ID_NODE;
	  }

	  public void setValue(double value) {
	    this.value = value;
	    this.valueSet = true;
	  }

	  public double getValue() {
	    if (valueSet)
	      return value;
	    else	      
	    	System.out.println("Variable was not initialized.");
	    	System.exit(0);
	    return 0.0;

	  }

	public String getName() {
		return this.name;
	}
}