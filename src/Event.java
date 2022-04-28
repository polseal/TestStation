import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Queue;

public abstract class Event
{
    private int entryTimeStamp;
    private static int initCarID = 1;
    public int carID;
    private int peopleInCar;

    public Event(int entryTimeStamp, int carID, int peopleInCar)
    {
        this.entryTimeStamp = entryTimeStamp;
        this.carID = carID;
        this.peopleInCar = peopleInCar;
    }

    public Event(int entryTimeStamp, int peopleInCar)
    {
        this.entryTimeStamp = entryTimeStamp;
        this.carID = getNewCarID();
        this.peopleInCar = peopleInCar;
    }

    public int getNewCarID()
    {
        return initCarID++;
    }

    public Event processEvent(Eventlist eventList)
    {
        Event currentEvent = eventList.events.peek();
        eventList.processCurrentEvent();
        Event newEvent = currentEvent.generateFutureEvent(currentEvent.getEntryTimeStamp(), currentEvent.getCarID(),
                currentEvent.getPeopleInCar());

        if(newEvent == null)
        {
            int indexCarId = eventList.carIDs.indexOf(currentEvent.getCarID());
            eventList.carIDs.remove(indexCarId);
        }
        System.out.println(currentEvent.getEntryTimeStamp() + " " + currentEvent.getCarID()
                + " " + currentEvent.getClass().getName() + " " + eventList.carIDs.size());
        return newEvent;
    };

    public int getCarID() {return this.carID;}
    public int getEntryTimeStamp() {return this.entryTimeStamp;}
    public int getPeopleInCar(){return this.peopleInCar;}
    public abstract Event generateFutureEvent(int entryTimeStamp, int carID, int peopleInCar);

    }
