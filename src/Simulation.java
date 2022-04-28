import java.util.Queue;
import java.util.Random;

public class Simulation
{
    Eventlist eventList;
    int startTime;
    int peopleInCar;
    int totalTime;
    Queue<Integer> carTestLane;

    Simulation(int entryTimeStamp, int peopleInCar, Eventlist eventList)
    {
            this.startTime = entryTimeStamp;
            this.peopleInCar = peopleInCar;
            this.eventList = eventList;
            Arriving newEvent = new Arriving(this.startTime, this.peopleInCar);
            this.eventList.events.add(newEvent);
            this.eventList.carIDs.add(newEvent.getCarID());
    };

    public void run()
    {
        Random rand = new Random();
        int totalTime = 0;
        int newArrival = 0;
        int entryTimeStamp = this.startTime;
        int peopleInCar = this.peopleInCar;
        Event result = getThisEvent();

        while (this.eventList.events.size() > 0)
        {

            if(this.eventList.carIDs.size()<10)
            {   int intervalNewArrival = rand.nextInt(30, 120);
                int newPeopleInCar = rand.nextInt(1, 5);
                newArrival = entryTimeStamp + intervalNewArrival;
                if (newArrival < 3600)
                {

                Simulation Sim = new Simulation(newArrival, newPeopleInCar, this.eventList);
                entryTimeStamp = newArrival;

                }
            }

            this.addNewEvent(result);
            result = getThisEvent();
        }
    }

    public Event getThisEvent ()
    {
        return eventList.events.peek();
    }

    public void addNewEvent (Event event)
    {
        Event newEvent = event.processEvent(this.eventList);
        if(newEvent!=null) {this.eventList.events.add(newEvent);}
    }

}
