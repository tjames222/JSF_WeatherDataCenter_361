package beans;

public class ResponseModel {
	@SuppressWarnings("unused")
	private int status;
	@SuppressWarnings("unused")
	private String message;
	
	public ResponseModel(int status, String message) {
		this.status=status;
		this.message=message;
	}
}
