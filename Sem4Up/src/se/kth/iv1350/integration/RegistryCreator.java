package se.kth.iv1350.integration;

/**
 * Creates all registries
 */
public class RegistryCreator {

    private ItemRegistry itemRegistry;

    private ExternalSystems externalSystems;

    private DiscountRegistry discountRegistry;

    /**
     * Creates all registries.
     */
    public RegistryCreator() {
        itemRegistry = ItemRegistry.getInstanceOf();
        externalSystems = new ExternalSystems();
        discountRegistry = DiscountRegistry.getInstance();
    }

    /**
     * retrieves the discount registry.
     * @return the discount registry
     */
    public DiscountRegistry getDiscountRegistry() {
        return discountRegistry;
    }

    /**
     * retrieves the item registry.
     * @return the item registry.
     */
    public ItemRegistry getItemRegistry() {
        return itemRegistry;
    }

    /**
     * retrieves the external systems.
     * @return the external systems.
     */
    public ExternalSystems getExternalSystems() {
        return externalSystems;
    }

}
