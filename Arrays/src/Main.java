import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Random rand = new Random(0);
        Scanner kb = new Scanner(System.in);

        // ctrl+shift+"/" делает блочный комментарий

        /*System.out.printf("Введите размер массива: ");
        int n = 5;//kb.nextInt();

        //массив рандомных данных
        int[] arr = new int[n];
        for(int i=0; i<arr.length;i++)
        {
            arr[i] = rand.nextInt(0,100);
            System.out.print(arr[i] + "\t");
        }

        // операции с массивами
        System.out.println("Сумма элементов массива: "  + IntStream.of(arr).sum());
        System.out.println("Среднее арифметическое: "   + IntStream.of(arr).average().getAsDouble());
        System.out.println("Минимальное значение: "     + IntStream.of(arr).min().getAsInt());
        System.out.println("Максимальное значение: "    + IntStream.of(arr).max().getAsInt());

        //сортировка массивов
        arr = IntStream.of(arr).sorted().toArray();
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i] + "\t");
        }

        *//*sort(T[] a, Comparator<? super T> c)
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i] + "\t");
        }*/

        //Двумерные массивы и действия над ними
        System.out.println("Введите количество строк: ");
        int rows = 3;//kb.nextInt();
        System.out.println("Введите кол-во столбцов: ");
        int cols = 4;//kb.nextInt();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = rand.nextInt(100);
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        //System.out.println("Сумма элементов массива: " + IntStream.of(Arrays.stream(arr).toArray()).sum());
        int[] flatten = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println("Сумма элементов массива: "+ IntStream.of(flatten).sum());
        System.out.println("Среднее арифметическое: " + IntStream.of(flatten).average().getAsDouble());
        System.out.println("Минимальное значение: "   + IntStream.of(flatten).min().getAsInt());
        System.out.println("Максимальное значение: "  + IntStream.of(flatten).max().getAsInt());

        Arrays.sort(arr, Comparator.comparingInt(a->a[0]));
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
