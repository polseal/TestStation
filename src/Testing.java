public class Testing extends Event
{

    public Testing(int timeStamp,int carID, int peopleInCar) {super(timeStamp, carID, peopleInCar);}

    @Override
    public Leaving generateFutureEvent(int entryTimeStamp, int carID, int peopleInCar)
    {
        int newEventTimeStamp = entryTimeStamp + 4*60*peopleInCar;
        Leaving event = new Leaving(newEventTimeStamp, carID, peopleInCar);
        return event;
    }
}
