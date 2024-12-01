import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test //Проверка на пол
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHaveMane = true;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals("У самца пропала грива", expectedHaveMane, actualHaveMane);
    }

    @Test //Проверка вызова метода getKittens()
    public void getKittensMethodCallTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test //Проверка метода getFood()
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals("Лев питается неправильно", expected, actual);
    }
}
