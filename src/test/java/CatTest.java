import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test //Проверка, что метод getSound() возвращает "Мяу"
    public void getSoundCatTest() {
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals("Кошка не мяукает", expectedResult, actualResult);
    }

    @Test //Проверка, что метод getFood() возвращает еду для кошки
    public void getFoodForCatTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        assertEquals("Кошка питается неправильно", expected, cat.getFood());
    }
}
