import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExpressionFile{
	String CommentLine;
	String ExpressionLines;
	String FileName;
	public ExpressionFile(String fl){
		this.FileName = fl;
	}
	public String LoadNextLine() throws FileNotFoundException, IOException{
	try (BufferedReader br = new BufferedReader(new FileReader(this.FileName))) {
	    String line ;
	    while ((line = br.readLine()) != null) {
	    	return line;
	    	}
	    return null;
	}

}
}