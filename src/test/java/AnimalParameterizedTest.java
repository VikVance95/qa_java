import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String kindOfAnimal;
    private final List<String> expected;

    public AnimalParameterizedTest(String kindOfAnimal, List<String> expected) {
        this.kindOfAnimal = kindOfAnimal;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getListOfMealDataForHerbivoreAndPredator() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}

        };
    }

    @Test
    public void getAnimalFoodTest() throws Exception {
        Animal animal = new Animal();
        List<String> actualResult = animal.getFood(kindOfAnimal);
        Assert.assertEquals(expected, actualResult);
    }

}
