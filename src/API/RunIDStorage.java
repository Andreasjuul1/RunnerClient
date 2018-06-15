package API;

public class RunIDStorage {


	private static RunIDStorage myObj;
    private String RunID;
    private RunIDStorage(){

    }


	public String getRunID() {
		return RunID;
	}


	public void setRunID(String runID) {
		RunID = runID;
	}


	public static RunIDStorage getInstance(){
        if(myObj == null){
            myObj = new RunIDStorage();
        }
        return myObj;
    }
}
