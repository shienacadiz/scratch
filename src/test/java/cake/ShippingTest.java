package cake;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShippingTest {

    @Test
    public void shouldReturnNegativeOneIfItemsExceedsTheBoxes() {
        assertThat(Shipping.minimalNumberOfPackages(16, 2, 1), is(-1));
        assertThat(Shipping.minimalNumberOfPackages(1, 0, 0), is(-1));
        assertThat(Shipping.minimalNumberOfPackages(10, 1, 1), is(-1));
    }

    @Test
    public void happyPathGivenExactNumberOfBoxes(){
        assertThat(Shipping.minimalNumberOfPackages(16, 3, 1), is(4));
        assertThat(Shipping.minimalNumberOfPackages(1, 0, 1), is(1));
        assertThat(Shipping.minimalNumberOfPackages(10, 2, 1), is(2));
    }

    @Test
    public void happyPathGivenAllItemsCanFitLargeAndSmallBoxes() {
        assertThat(Shipping.minimalNumberOfPackages(16, 2, 10), is(8));
        assertThat(Shipping.minimalNumberOfPackages(16, 3, 10), is(4));
        assertThat(Shipping.minimalNumberOfPackages(19, 3, 10), is(7));
    }

    @Test
    public void happyPathGivenAllItemsCanFitInLargeBoxes() {
        assertThat(Shipping.minimalNumberOfPackages(16, 4, 1), is(4));
        assertThat(Shipping.minimalNumberOfPackages(1, 10, 1), is(1));
        assertThat(Shipping.minimalNumberOfPackages(10, 3, 1), is(2));
    }

}
