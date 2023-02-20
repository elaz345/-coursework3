import java.awt.Color;
import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.util.ListIterator;

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
    private int killCount = 0;
    private int numberEaten = 0;
    
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
       //setNextState(true);
       //Location newLocation = killMyco();
       mycoCount = 0;
       setColor(Color.BLUE);
       eatsMyco();
       
    
      // killMyco();
       if (killCount == 1){
             setColor(Color.BLACK);
       }
       //setColor(Color.BLUE);
       setNextState(true);
       /*if(newLocation != null){
           setColor(Color.GREEN);
           killMyco();
           setNextState(true);
       }
       if (newLocation == null){
           setColor(Color.BLUE);
           setNextState(true);
       }
       */
             
        }
   
     private void eatsMyco(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        ListIterator<Location> it = adjacent.listIterator();
        while (isAlive() && it.hasNext()) {
            Location loc = it.next();
            Cell cell = field.getObjectAt(loc);
            if(instanceOfMyco(cell)) {
                cell.setNextState(false);
                numberEaten++; 
            }
        }  
        
    }
    
      private void killMyco()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        ListIterator<Location> it = adjacent.listIterator();
        while(isAlive() && it.hasNext()) {
            Location where = it.next();
            Cell cell = field.getObjectAt(where);
            if(instanceOfMyco(cell)) {
                Mycoplasma myco = (Mycoplasma) cell;
                if(myco.isAlive()) { 
                    myco.setDead();
                    killCount++;
                }
            }
        }
        //return null;
    }
    
}
