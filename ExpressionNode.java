import java.util.ArrayList;
import java.util.List;

public interface ExpressionNode {
	
  public static enum expressionsnodes{ID_NODE, DOUBLE_NODE, ADD_NODE, MINUS_NODE, MULT_NODE, DIV_NODE, PAREN_NODE, EQUALS_NODE}
  
  public static final int EXPONENTIATION_NODE = 9;
  public static final int FUNCTION_NODE = 10;
  
  public double getValue() throws Exception;
  public expressionsnodes getType();
}
  