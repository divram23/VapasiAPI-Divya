package ResponseMethods;

import com.fasterxml.jackson.annotation.JsonSetter;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class AddBookResponse {

    //@JsonProperty("msg")

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

/*public class MyPojo
{
    private AddBookResponse[] addBookResponses;

    public AddBookResponse[] getData ()
    {
        return addBookResponses;
    }

    public void setData (AddBookResponse[] data)
    {
        this.addBookResponses = addBookResponses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+addBookResponses+"]";
    }
}*/
