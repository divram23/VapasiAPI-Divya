package ResponseMethods;

import com.fasterxml.jackson.annotation.JsonSetter;


public class AddBookResponse {
    private String Msg;
    private String ID;

    public AddBookResponse(){
        this.Msg = Msg;
        this.ID = ID;

    }

    public AddBookResponse(String Msg, String ID) {
        this.Msg = Msg;
        this.ID = ID;
    }


    public String getMsg() {
        return Msg;
    }

    @JsonSetter("Msg")
    public void setMsg(String Msg) {
        this.Msg = Msg;
    }


    public String getID() {
        return ID;
    }

    @JsonSetter("ID")
    public void setID(String ID) {
        this.ID = ID;
    }
}


