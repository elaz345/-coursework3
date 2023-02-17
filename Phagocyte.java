import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * Simplest form of life.
 * Fun Fact: Mycoplasma are one of the simplest forms of life.  A type of
 * bacteria, they only have 500-1000 genes! For comparison, fruit flies have
 * about 14,000 genes.
 *
 * @author David J. Barnes, Michael Kölling & Jeffery Raphael
 * @version 2022.01.06 (1)
 */

public class Phagocyte extends Cell {

    /**
     * Create a new Mycoplasma.
     *
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Phagocyte(Field field, Location location, Color col) {
        super(field, location, col);
    }

    /**
     * This is how the Phagocyte decides if it's alive or not
     */
     public void act() {
       List<Cell> neighbours = getField().getLivingNeighbours(getLocation());
       setNextState(true);
       Location newLocation = findMyco();
       if(newLocation != null){
           setColor(Color.GREEN);
           setNextState(true);
       }
       if (newLocation == null){
           setNextState(true);
       }
        }
    
      private Location findMyco()
    {
        Field field = getField();
        Boolean eaten = false;
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Cell cell = field.getObjectAt(where);
            if(cell instanceof Mycoplasma) {
                Mycoplasma myco = (Mycoplasma) cell;
                if(myco.isAlive()) { 
                    myco.setDead();
                    eaten = true;
                    return where;
                }
            }
        }
        return null;
    }
}
