import java.io.*;//

public class Main {
    public static void main(String[] args)
    {
        //System.out.println("Hello, World!");
        /*Human human = new Human("Montana", "Antonio",25);
        System.out.println(human);

        Student student = new Student("Jessie","Pinkman", 22, "Chemistry","WW_220",95,96);
        System.out.println(student);

        Teacher teacher = new Teacher("White", "Walter", 50, "Chemistry",25);
        System.out.println(teacher);*/

        // Проявление полиморфизма в ООП - эта запись идентична закоментированной выше записи
        Human[] group = new Human[]
                {
                        new Human("Montana", "Antonio",25),
                        new Student("Jessie","Pinkman", 22, "Chemistry","WW_220",95,96),
                        new Teacher("White", "Walter", 50, "Chemistry",25)
                };
        /*for(Human h:group)
        {
            System.out.println(h);
        }*/

///////////////////////////запись данных в файл (сериализация)////////////////////////////

        //Массив объектов нельзя просто преобразовать в байты. Нужна сериализация объектов
        //FileOutputStream("group.dat") - создает поток для записи байтов в файл "group.dat"
        //ObjectOutputStream(...) - оборачивает файловый поток для записи объектов
        //try(...) - конструкция try-with-resources, автоматически закроет потоки
        //oos.writeObject(group); Сериализует весь массив group и записывает его в файл как единый объект

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group.dat")))
        {
            oos.writeObject(group);//Запись всего массива целиком
            System.out.println("Данные успешно записаны в файл group.dat");
        }
        catch(IOException ex)
        {
            System.out.println("Ошибка записи: " + ex.getMessage());
        }

////////////////////////// Чтение данных из файла///////////////////////////////////////

        //FileInputStream("group.dat") - открывает поток для чтения байтов из файла
        //ObjectInputStream(...) - оборачивает файловый поток для чтения объектов
        //try(...) - снова автоматическое управление ресурсами
        //readObject() - читает объект из файла
        //(Human[]) - приведение типа (мы знаем, что там массив Human)

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("group.dat")))
        {
            Human[] loadedGroup = (Human[]) ois.readObject();
            System.out.println("\nЗагруженные данные:");
            for(Human h : loadedGroup)
            {
                System.out.println(h);
            }
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println("Ошибка чтения: " + ex.getMessage());
        }
    }

}