package fr.secondtrade.webapi.models;

public class Response {
	
	private int status;
	private Object data;
	
	public Response(){
		
	}

	public Response(int status, Object data) {
		this.setStatus(status);
		this.setData(data);
	}
	
	public void incrStatusBy(int increment) { 
		setStatus(getStatus() + increment);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
