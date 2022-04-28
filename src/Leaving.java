import java.sql.Timestamp;
import java.util.Queue;

public class Leaving extends Event
{
    public Leaving(int  timeStamp, int carID, int peopleInCar)
    {
        super(timeStamp, carID, peopleInCar);
    }

    @Override
    public Event generateFutureEvent(int entryTimeStamp, int carID, int peopleInCar)
    {
        return null;
    }
}
