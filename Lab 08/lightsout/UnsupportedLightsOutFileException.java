/*
 * Created by Jasque Saydyk and Justin Coffey
 * Lab 07 - Lights Out
 * CS 136L Section 3801
 * 21 March 2017
 * Description - Exception for the Lights Out game
*/
package lightsout;

public class UnsupportedLightsOutFileException extends Exception{

	private static final long serialVersionUID = 1L;

	public UnsupportedLightsOutFileException() {
		// TODO Auto-generated constructor stub
	}

	public UnsupportedLightsOutFileException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedLightsOutFileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedLightsOutFileException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UnsupportedLightsOutFileException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
