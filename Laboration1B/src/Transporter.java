import java.util.List;

public interface Transporter<T extends Transportable> {

     void loadObjects(List<T> objectsToLoad);
     void unloadObjects(List<T> objectsToUnload);
}
