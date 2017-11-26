import java.util.LinkedList;
import java.util.Scanner;

public class Express{	

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		parse parser = new parse();

		if (args!= null){
			String fileName = "";
			String xp;
			for(int i = 0; i<args.length; i++){
				fileName += args[i];
			}
			ExpressionFile expfile = new ExpressionFile(fileName);
			xp = expfile.LoadNextLine().replaceAll(" ", "");
			 String[] array; 
			 array = xp.split("(?<=[-+*/=()])|(?=[-+*/=()])");
			 LinkedList<String> listToken = new LinkedList<String>();
			 int i = 0;
				while(i<array.length){
					listToken.add(array[i]);
					i++;
					System.out.println(listToken);
				}
				
			   ExpressionNode expression = parser.parser(listToken);
			   if(expression.toString().equals(expfile.LoadNextLine())){
				   System.out.println("Correct: "+ xp + " == "+ String.format("%1$,.4f",expression.getValue()));
			   }
		}
		else if(in.hasNext()){
			 String input = in.nextLine();
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
		 
}