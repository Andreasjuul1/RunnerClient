package API;

public class CardStorage {


	private static CardStorage myObj;
    private String CardNumber;
    private CardStorage(){

    }

    public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}


	public static CardStorage getInstance(){
        if(myObj == null){
            myObj = new CardStorage();
        }
        return myObj;
    }



}