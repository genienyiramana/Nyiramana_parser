public class ExpTree{

  public static Node root;

  public ExpTree(int data)
  {
      root = new Node(data);
  }

  public void add(Node parent, Node child, String orientation)
  {
      if (orientation.equals("left"))
      {
         parent.setLeft(child);
      }
      else
      {
          parent.setRight(child);
      }
  }
}

class Node {
  private int key;
  private Node left;
  private Node right;

  Node (int key) {
      this.key = key;
      right = null;
      left = null;
  }

  public void setKey(int key) {
      this.key = key;
  }

  public int getKey() {
      return key;
  }

  public void setLeft(Node left) {
      this.left = left;
  }

  public Node getLeft() {
      return left;
  }

  public void setRight(Node right ) {
      this.right = right;
  }

  public Node getRight() {
      return right;
  }

}

