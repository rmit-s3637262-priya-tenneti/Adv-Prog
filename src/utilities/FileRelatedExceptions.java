package utilities;

@SuppressWarnings("serial")
public class FileRelatedExceptions extends Exception{

	public FileRelatedExceptions(String reason,Throwable cause){
		super(reason,cause);
	}
}
