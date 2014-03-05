package exceptions;

public class MissingChoiceException extends Exception {
	private int errorno;
	private String errormsg;
	public MissingChoiceException (String message) {
		
		super(message);
		this.errormsg = message;
	}
	
	public MissingChoiceException(int errorno) {
		super();
		this.errorno = errorno;
		
	}
	public MissingChoiceException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		
	}
	public int getErrorno() {
		return errorno;
	}
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
}