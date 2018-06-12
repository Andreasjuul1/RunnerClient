package API;

public class TokenStorage {


	private static TokenStorage myObj;
    private String terminalToken;
    private String userToken;
    private TokenStorage(){

    }

    public String getTerminalToken() {
		return terminalToken;
	}

	public void setTerminalToken(String terminalToken) {
		this.terminalToken = terminalToken;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public static TokenStorage getInstance(){
        if(myObj == null){
            myObj = new TokenStorage();
        }
        return myObj;
    }



}