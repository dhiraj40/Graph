package TownConnection;

public class Connection {
    public String firstTown;
    public String secondTown;
    public int cost;

    public Connection(){

    }

    public Connection(String firstTown, String secondTown, int cost) {
        this.firstTown = firstTown;
        this.secondTown = secondTown;
        this.cost = cost;
    }

    public String toString(){
        return "["+firstTown+","+secondTown+","+cost+"]";
    }
}
