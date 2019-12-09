package CafeApp;
/*
Written by Matthew created on 19/11/19
 */

public class Staff{

    private int loginID;

    protected Staff() {
    }//Default Constructor

    protected Staff(int loginNo) {
        loginID = loginNo;
    }//Alternative constructor

    //set loginID
    protected void setLoginID(int loginNo) { loginID = loginNo; }
    protected int getLoginID() {return loginID;}
}//class
