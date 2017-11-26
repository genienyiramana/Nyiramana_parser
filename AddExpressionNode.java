public class AddExpressionNode
      extends SequenceExpressionNode {

  public AddExpressionNode() {
    super();
  }

  public AddExpressionNode(ExpressionNode a,
                                boolean positive) {
    super(a, positive);
  }

  public expressionsnodes getType() {
    return ExpressionNode.expressionsnodes.ADD_NODE;
  }

  public double getValue() throws Exception {
    double sum = 0.0;
    for (Term t : terms) {
      if (t.positive)
        sum += t.expression.getValue();
      else
        sum -= t.expression.getValue();
    }
    return sum;
  }
}