public class DoubleExpressionNode implements ExpressionNode {
  private double value;
  public DoubleExpressionNode(String value) {
	    this.value = Double.valueOf(value);
	  }
  
  public DoubleExpressionNode(double value) {
    this.value = value;
  }

  

  public double getValue() {
    return value;
  }

  public expressionsnodes getType() {
    return ExpressionNode.expressionsnodes.DOUBLE_NODE;
  }
}