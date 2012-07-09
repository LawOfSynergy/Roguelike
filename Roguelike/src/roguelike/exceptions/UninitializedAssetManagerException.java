package roguelike.exceptions;

public class UninitializedAssetManagerException extends Exception {
	private static final long serialVersionUID = 1L;

	public UninitializedAssetManagerException() {
		super();
	}

	public UninitializedAssetManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public UninitializedAssetManagerException(String message) {
		super(message);
	}

	public UninitializedAssetManagerException(Throwable cause) {
		super(cause);
	}

}
