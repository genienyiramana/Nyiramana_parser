public class MultExpressionNode
      extends SequenceExpressionNode {

  public MultExpressionNode() {
    super();
  }

  public MultExpressionNode(ExpressionNode a,
                                      boolean positive) {
    super(a, positive);
  }

  public expressionsnodes getType() {
    return ExpressionNode.expressionsnodes.MULT_NODE;
  }

  public double getValue() throws Exception {
    double prod = 1.0;
    for (Term t : terms) {
      if (t.positive)
        prod *= t.expression.getValue();
      else
        prod /= t.expression.getValue();
    }
    return prod;
  }
}