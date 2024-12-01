import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test //Проверка метода eatMeat()
    public void eatMeatFelineTest() throws Exception {
        List<String> actual = List.of("Животные", "Птицы", "Рыба");
        assertEquals(actual, feline.eatMeat());
    }

    @Test //Проверка метода getFamily()
    public void getFamilyFelineTest() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult, actualResult);
    }

    @Test //Проверка метода getKittens(), который возвращает одного котенка
    public void getKittensOneKittenTest() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test //Проверка метода getKittens() с указанным количеством котят
    public void getKittensCountTest() {
        int expectedResult = 5;
        int actualResult = feline.getKittens(5);
        assertEquals(expectedResult, actualResult);
    }
}
