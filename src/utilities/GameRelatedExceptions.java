package utilities;

@SuppressWarnings("serial")
public class GameRelatedExceptions extends Exception{

	public GameRelatedExceptions(String reason,Throwable cause){
		super(reason,cause);
	}

}
