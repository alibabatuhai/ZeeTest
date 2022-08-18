class TicketCounter{
    int avail_seat;
    TicketCounter(int avail_seat){
        this.avail_seat=avail_seat;
    }
    void bookTicket(String name, int seat_qty){
        if (avail_seat>=seat_qty && seat_qty>0){
            System.out.println(name+": "+seat_qty+" seats booked succesfully");
            avail_seat-=seat_qty;
        }
        else if (avail_seat<seat_qty){
            System.out.println(name+": Seats not available");
        }
    }
}
class TicketBooking extends Thread{
    TicketCounter tc;
    String name;
    int seat_qty;
    TicketBooking(TicketCounter tc, String name, int seat_qty){
        this.tc=tc;
        this.name=name;
        this.seat_qty=seat_qty;
    }
    public void run(){
        tc.bookTicket(name, seat_qty);
    }
}
public class BusTicketReservation {
    public static void main(String[] args){
        TicketCounter tc = new TicketCounter(5);
        TicketBooking tb = new TicketBooking(tc, "Dan", 2);
        TicketBooking tb1 = new TicketBooking(tc, "Russ", 4);
        tb.start();
        try{
            Thread.sleep(100);
        }
        catch (Exception e){
            System.out.println(e);
        }
        tb1.start();
        System.out.println(tc.avail_seat);
    }
}