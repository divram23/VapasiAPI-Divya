package ResponseMethods;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBookResponse {

    @JsonProperty("bookid")

    private String Msg;
    private String ID;

    AddBookResponse() {
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


    public void setMsg(String Msg) {
        this.Msg = Msg;
    }


    public String getID() {
        return ID;
    }


    public void setID(String ID) {
        this.ID = ID;
    }
}
