package klarna;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class OrderFoodsTest {

    @Test
    public void shouldPassWhenIngredientIsEverything() {
        assertThat("banana,honey,mango,peach,pineapple,strawberry", is(OrderFoods.ingredients("Classic")));
        assertThat("banana,cherry,chocolate,ice cream,peanut", is(OrderFoods.ingredients("Just Desserts")));
    }

    @Test
    public void shouldPassWhenThereIsExcludedIngredients() {
        assertThat("black currant,blueberry",
            is(OrderFoods.ingredients("Freezie,-blackberry,-frozen yogurt,-grape juice")));
        assertThat("black currant,blueberry",
            is(OrderFoods.ingredients("Freezie,-blackberry,-frozen yogurt,-grape juice,-blackberry")));
        assertThat("banana,honey,mango,peach,pineapple", is(OrderFoods.ingredients("Classic,-strawberry,-peanut")));
        assertThat("", is(OrderFoods.ingredients("Classic,-peach,-strawberry,-pineapple,-banana,-mango,-honey")));
    }

    @Test
    public void shouldPassWhenThereIsEmptyItemsOnCommaSeparatedString() {
        assertThat("banana,honey,mango,peach,pineapple", is(OrderFoods.ingredients("Classic,,-strawberry,,,-peanut")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenIngredientIsInvalid() {
        OrderFoods.ingredients("Greenie,banana");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMenuIsInvalid() {
        assertThat("", is(OrderFoods.ingredients("Berry,-peach,-strawberry,-pineapple,-banana,-mango,-honey")));
    }
}
