public class Visitor extends Person {
    private String visitorId;
    private String ticketType;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String id, String visitorId, String ticketType) {
        super(name, age, id);
        this.visitorId = visitorId;
        this.ticketType = ticketType;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}