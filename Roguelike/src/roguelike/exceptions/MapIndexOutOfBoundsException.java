package roguelike.exceptions;

public class MapIndexOutOfBoundsException extends Exception 
{
	public MapIndexOutOfBoundsException(String errorMessage) {
		super(errorMessage);
	}
}
