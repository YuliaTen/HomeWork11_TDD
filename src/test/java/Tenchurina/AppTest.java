package Tenchurina;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;


public class AppTest {

    StringBuild stringB = new StringBuild();

    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("Проверка на длину массива")
    public  void testLengthMassive(int[] massiv) {
        String result = stringB.masIntToString(massiv);
        Assertions.assertTrue(result.length() > 1);
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("Проверка данных на присутствие только чисел и пробелов между ними")
    public  void testRegMassive(int[] massiv) {
        String result = stringB.masIntToString(massiv);
        Assertions.assertTrue(result.matches("[[0-9]+\\s]+"),"Не соответтвие регулярному выражению");
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("Проверка на присутствие 0 в масиве")
    public  void testRegZeroMassive(int[] massiv) {
         String result = stringB.masIntToString(massiv);
         Assertions.assertTrue(result.matches(".*[0]+.*"),"Нет ноля в массиве");
}


    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("Проверка данных на пустоту")
    public  void testNotNullMassive(int[] massiv) {
        String result = stringB.masIntToString(massiv);
        Assertions.assertNotNull(result,"Результат пустой");
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    @DisplayName("Проверка класса получаемых данных")
    public  void testClassMassive(int[] massiv) {
        String result = stringB.masIntToString(massiv);
        Assertions.assertEquals(result.getClass(),String.class,"Полученный класс не типа стринг");
    }

    public static List<int[]> dataProvider(){
        return List.of(
                new int[]{1,0,3},
                new int[]{4,0,6},
                new int[]{10,0,2}
        );
    }

    @Test
    public void testShouldThrowException(){
        Assertions.assertThrows(
                RuntimeException.class,() -> {stringB.generateException();}
        );
    }
}

