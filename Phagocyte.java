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

    private int mycoCount = 0;

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
       Location newLocation = killMyco();
       mycoCount = 0;
       //if (numberMyco() == 3){
         //    setColor(Color.RED);
       //}
       if(newLocation != null){
           setColor(Color.GREEN);
           setNextState(true);
       }
       if (newLocation == null){
           setNextState(true);
       }
       
             
        }
    
      private Location killMyco()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(isAlive() && it.hasNext()) {
            Location where = it.next();
            Cell cell = field.getObjectAt(where);
            if(cell instanceof Mycoplasma) {
                Mycoplasma myco = (Mycoplasma) cell;
                if(myco.isAlive()) { 
                    myco.setNextState(false);
                    //mycoCount += 1;
                    return where;
                }
                
            }
        }
        return null;
    }
     private int numberMyco()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        
        while(it.hasNext()) {
            Location currentLoc = it.next();
            Cell cell = field.getObjectAt(currentLoc);
            if(cell instanceof Mycoplasma) {
                Mycoplasma myco = (Mycoplasma) cell;
                if(myco.isAlive()) {
                    mycoCount += 1;
                    myco.setNextState(false);
                }
            }
        }
        return mycoCount;
    }
}
