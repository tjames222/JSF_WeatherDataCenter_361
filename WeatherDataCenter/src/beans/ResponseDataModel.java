package beans;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseDataModel extends ResponseModel {
	public ResponseDataModel(int status, String message) {
		super(status, message);
	}
	public ResponseDataModel() {
		super(0, "");
	}
}
