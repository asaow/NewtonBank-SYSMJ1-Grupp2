package bank;

public class Name {
	
	private String name;
	//private String [] wordArray;

	public boolean letterCheck() {
		  if(name.matches("[a-öA-Ö\\W]")) {
		      return true;
		    }
		    else {
		      return false;
		    }
	}
	public boolean nameCheck(){ 
	
	String [] wordArray = name.split(" ");
	int wordCount = wordArray.length;

	if( wordCount > 1 || wordCount < 5 ) {
		
		wordCount =+ 1;
		return true;
		}

	else return false;
	}
}

