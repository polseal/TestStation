import java.util.Queue;
import java.util.Random;

public class Arriving extends Event
{
    public Arriving(int timeStamp, int peopleInCar)
    {
        super(timeStamp, peopleInCar);
    }

    @Override
    public Testing generateFutureEvent(int entryTimeStamp, int carID, int peopleInCar)
    {
        Random rand = new Random();
        int newEventTimeStamp = entryTimeStamp + rand.nextInt(60, 120);
        Testing event = new Testing(newEventTimeStamp, carID, peopleInCar);
        return event;
    }
}
