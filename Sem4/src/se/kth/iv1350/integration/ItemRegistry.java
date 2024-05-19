package se.kth.iv1350.integration;

import se.kth.iv1350.utilities.AmountOfMoney;
import java.util.*;

/**
 *This is a mock database containing Items. 
 */
public class ItemRegistry {

        private static final ItemRegistry ITEM_REGISTRY = new ItemRegistry();
	private HashMap<ItemIdentifier,Item> itemRegistry;
        private ItemIdentifier crashDatabase = new ItemIdentifier(666);

    /**
     *Retrieves an item from the registry.
     * @param itemID identifies which item is sought.
     * @return the item matching the provided ID.
     * @throws se.kth.iv1350.integration.ItemNotFoundException
     */
    public Item getItem(int itemID) throws ItemNotFoundException,DatabaseFailureException{
        ItemIdentifier ID = new ItemIdentifier(itemID);
        if(ID.equals(crashDatabase)){
         throw new DatabaseFailureException(itemID);
        }
        if(itemRegistry.containsKey(ID)){
		return itemRegistry.get(ID);
        }else{
            throw new ItemNotFoundException(itemID);
        }
                
	}

    /**
     * Initializes the registry. 
     * Items are created and entered into the registry.
     */
    private ItemRegistry(){
		
            itemRegistry = new HashMap<>(10);
                Item car = new Item(111,new ItemDescription("This is a car"),new AmountOfMoney(10000),"Vehicle");

            itemRegistry.put(car.getItemID(), car);
            
            Item truck = new Item(112, new ItemDescription("This is a truck"), new AmountOfMoney(20000), "Vehicle");

            itemRegistry.put(truck.getItemID(), truck);
            Item bus = new Item(113, new ItemDescription("This is a bus"), new AmountOfMoney(30000), "Vehicle");

            itemRegistry.put(bus.getItemID(), bus);
            
            Item apple = new Item(200, new ItemDescription("This is an apple"), new AmountOfMoney(10.50), "Food");

            itemRegistry.put(apple.getItemID(), apple);
            
            Item banana = new Item(201, new ItemDescription("This is a banana"), new AmountOfMoney(14.99), "Food");

            itemRegistry.put(banana.getItemID(), banana);
            
            Item baseball = new Item(300, new ItemDescription("This is a baseball"), new AmountOfMoney(10), "Miscellaneous");

            itemRegistry.put(baseball.getItemID(), baseball);

                
                        }
        /**
         * 
         */        
    public static ItemRegistry getInstanceOf(){
        return ITEM_REGISTRY;
    }
	}


