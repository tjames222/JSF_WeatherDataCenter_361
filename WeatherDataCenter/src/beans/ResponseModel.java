package beans;

public class ResponseModel {
	private int status;
	private String message;
	
	public ResponseModel(int status, String message) {
		this.status=status;
		this.message=message;
	}
}
