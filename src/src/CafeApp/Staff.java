package CafeApp;
/*
Written by Matthew
 */

public class Staff{

    private int loginID;

    public Staff() {
    }//Default Constructor

    public Staff(int loginNo) {
        loginID = loginNo;
    }//Alternative constructor

    //set loginID
    public void setLoginID(int loginNo) { loginID = loginNo; }

    public int getLoginID() {return loginID;}


}//class
