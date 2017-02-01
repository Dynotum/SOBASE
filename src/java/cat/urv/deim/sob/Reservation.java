package cat.urv.deim.sob;


public class Reservation {

private float totalPrice;
private int IDOrder;
public static int previousNumber=2;
private int IDTour; 
private int quantity;
private String IDUser;


    public Reservation(float totalPrice, int IDOrder, int IDTour, int quantity, String IDUser) {
        this.totalPrice = totalPrice;
        this.IDOrder = IDOrder;
        this.IDTour = IDTour;
        this.quantity = quantity;
        this.IDUser = IDUser;
    }
    
    public Reservation(float totalPrice,int IDTour, int quantity, String IDUser) {
        this.totalPrice = totalPrice;
        this.IDTour = IDTour;
        this.quantity = quantity;
        this.IDUser = IDUser;
        this.IDOrder=previousNumber;
        previousNumber++;
    }

    public Reservation() {    }

    public Reservation(String alias, int idOferta, float preuTotal, int persones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getTotal_price() {
        return totalPrice;
    }

    public int getOrder_id() {
        return IDOrder;
    }

    public int getOffer_id() {
        return IDTour;
    }

    public int getPeople() {
        return quantity;
    }

    public String getUser_id() {
        return IDUser;
    }
    
    public String getMounth(int idTour){
        String nameTour = "";
        
        switch ((int)idTour) {
            case 1:
                nameTour = "January";
                break;
            case 2:
                nameTour = "February";

                break;
            case 3:
                nameTour = "March";

                break;
            case 4:
                nameTour = "April";
                break;
            case 5:
                nameTour = "May";
                break;
            case 6:
                nameTour = "June";
                break;
            case 7:
                nameTour = "July";
                break;
            case 8:
                nameTour = "August";
                break;

            default:
                nameTour="error";
            break;
        }
        
        return nameTour;
    }
    public String getMounth(float idTour){
        String nameTour = "";
        
        switch ((int)idTour) {
            case 1:
                nameTour = "January";
                break;
            case 2:
                nameTour = "February";

                break;
            case 3:
                nameTour = "March";

                break;
            case 4:
                nameTour = "April";
                break;
            case 5:
                nameTour = "May";
                break;
            case 6:
                nameTour = "June";
                break;
            case 7:
                nameTour = "July";
                break;
            case 8:
                nameTour = "August";
                break;

            default:
                nameTour="error";
            break;
        }
        
        return nameTour;
    }
    public String getNameTour(float idTour){
        String nameTour = "";
        
        switch ((int)idTour) {
            case 1:
                nameTour = "mexico";
                break;
            case 2:
                nameTour = "athens";

                break;
            case 3:
                nameTour = "london";

                break;
            case 4:
                nameTour = "rome";
                break;
            case 5:
                nameTour = "amsterdam";
                break;
            case 6:
                nameTour = "brussels";
                break;
            case 7:
                nameTour = "lisbon";
                break;
            case 8:
                nameTour = "prague";
                break;

            default:
                nameTour="error";
            break;
        }
        
        return nameTour;
    }

    public void setTotal_price(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrder_id(int IDOrder) {
        this.IDOrder = IDOrder;
    }

    public void setOffer_id(int IDTour) {
        this.IDTour = IDTour;
    }

    public void setPeople(int quantity) {
        this.quantity = quantity;
    }

    public void setUser_id(String IDUser) {
        this.IDUser = IDUser;
    }
    public String getComandaInfo() {
        return "<br><h2 align= \"center\">"+getNameTour(totalPrice)+ "</h2><br><br><b> RESERVATION SiteReservation # "+quantity+"</b><br><br><b>NUMBER OF PLACES: </b>"
                +IDTour+ " SIT(S).<br><br><b>TOTAL PRICE:    €</b> "+IDOrder+"<br>";
    }
    public String getComandaReserva() {
        return "<br><h1 align= \"center\" valign=\"top\">"+getNameTour(IDTour)+ "</h1><br><br><b>MY RESERVATION # : "+IDOrder+"</b><br><br><br><b>NUMBER OF PLACES: </b>"+quantity+
                " SITS.<br><br><b>TOTAL PRICE: € </b>"+totalPrice+" euros.<br>"; 
    }
  
}