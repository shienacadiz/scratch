package cake;

public class Shipping {
    public static final int ITEMS_IN_LARGE_PACKAGES = 5;
    public static final int ITEMS_IN_SMALL_PACKAGES = 1;

    public static final int ITEMS_EXCEEDS_PACKAGES_AVAILABLE = -1;

    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int itemsLeft = items;
        int packagesUsed = 0;

        for(int x=0 ; x < availableLargePackages ; x++) {
            if(itemsLeft<=0) {
                break;
            }
            itemsLeft-=ITEMS_IN_LARGE_PACKAGES;
            packagesUsed++;
        }

        for(int x=0 ; x < availableSmallPackages ; x++) {
            if(itemsLeft<=0) {
                break;
            }
            itemsLeft-=ITEMS_IN_SMALL_PACKAGES;
            packagesUsed++;
       }

        if(itemsLeft > 0) {
            return ITEMS_EXCEEDS_PACKAGES_AVAILABLE;
        } else {
            return packagesUsed;
        }
    }
}