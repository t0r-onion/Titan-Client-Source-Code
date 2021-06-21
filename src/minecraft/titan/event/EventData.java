package titan.event;
import java.lang.reflect.Method;

/**
 * Created by Hexeption on 18/12/2016.
 */
public class EventData {

    public final Object source;

    public final Method target;

    public final byte priority;

    EventData(Object source, Method target, byte priority) {

        this.source = source;
        this.target = target;
        this.priority = priority;
    }

}
