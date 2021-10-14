import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class ListMapExample {
    public static void main(String[] args) {
        Employer c = new Employer("ytw");
        Employer e = new Employer("ytw");
        c.toString();


//пример ArrayList
        ArrayList<String> whoWasInPervouralsk = new ArrayList<>();
        System.out.println(whoWasInPervouralsk.size());
   //     (whoWasInPervouralsk.ensureCapacity(10));

        whoWasInPervouralsk.add("Ksu");
        whoWasInPervouralsk.add("Andrey");
        whoWasInPervouralsk.add("Sanya");
        whoWasInPervouralsk.add(0, "Ann");

        whoWasInPervouralsk.remove("Sanya");
        System.out.println(whoWasInPervouralsk.contains("Sanya"));

        whoWasInPervouralsk.set(0,"Mona");
        whoWasInPervouralsk.clear();

    }

    public static void films (String[] args) {
        //пример LinkedList
        LinkedList<String> cinema = new LinkedList<>();

        String film1 = "The Silence of the Lambs";
        String film2 = "What We Do in the Shadows";

        cinema.add(film1);
        cinema.add(film2);

        System.out.println(cinema.getFirst());
        System.out.println(cinema.getLast());

    }

    public static void japan(String[] args) {
        //пример HashMap
        HashMap<Integer, String> emperorsOfJapan = new HashMap<>();

        emperorsOfJapan.put(660, "Дзимму");
        emperorsOfJapan.put(581, "Суйдзей");
        emperorsOfJapan.put(549, "Аннэй");
        System.out.println(emperorsOfJapan.containsKey(581));
        System.out.println(emperorsOfJapan.containsValue("Дзимму"));

        Set<Integer> keys = emperorsOfJapan.keySet();  //отдельно получить список всех ключей
        System.out.println("Ключи: " + keys);

        ArrayList<String> values = new ArrayList<>(emperorsOfJapan.values());
        System.out.println("Значения: " + values);

        System.out.println(emperorsOfJapan.size()); //число элементов в словаре

        //пример TreeMap
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>(emperorsOfJapan);
        System.out.println(tm);

//        SortedMap<Integer,String> emperorsOfJapanSorted = new ConcurrentSkipListMap<Integer,String>(); //отсортировать в порядке возрастания на основе ключей
//        emperorsOfJapanSorted.put(660, "Дзимму");
//        emperorsOfJapanSorted.put(581, "Суйдзей");
//        emperorsOfJapanSorted.put(549, "Аннэй");
    }
}




//ЗАДАНИЕ прочитать что такое capasity и два метода к нему - ensureCapasity и trimToSize
//массив постоянно растет и склеивается
//arraylist - это удобная обертка над массивом
//важно знать про размеры arraylist

//ЗАДАНИЕ разобраться для чего нужен hashcode и equals
//внутренняя работа hashmap - что такое bucket https://habr.com/ru/post/421179/ и equals

//ЗАДАНИЕ toString возвращает - если я хочу преобразовать в строку то надо возрвращать
// public String toString() {
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
//    }

//command + n - создает генераторы конструкторов и тд

//ЗАДАНИЕ +  в класс main в (Main) распарсить аргументы программной строи и  +  добавить токенайзер
//после компиляции программы - отдала ее пользователю - он запускает программу и в аргументах программы пишет имя файла в виде валидного пути
//        File file = new File(Main.class.getResource("/NumberList").toURI()); вместо  /NumberList будет значение аргумента которое передаст пользователь
// я передам в параметрах путь к которому лежит файл который нужно обработать - а путь будет написан в переменной которую передаст мне пользователь
//для этого мне нужно использовать библиотеку
//

//особенно про исключение
//выбрать самого сексуального из сериала Сверхъестественное
//3) Прочитать про Исключения, проверяемые \непроверяемые, как создать свое исключение, как перехватывать их
//4) конструктор метод поле класс, абстрактный класс, интерфейс, наследование классов, работа с интерфейсами, default методы интерфейсов, переопределение методов, Рассказать и показать.
//5) Добавить библиотеку junit и написать тест. - создать новый проект и применить в нем все фишки из пункта 4 и привести примеры






//    public static void main(String[] args) {
//
//        List<String> lines = new ArrayList<>();
//        Path file = Paths.get("/NumberList");
//        Stream<String> lineStream = Files.lines(file, StandardCharsets.UTF_8).collect(Collectors.joining(System.lineSeparator()));
//        String fileText = "";
//
//        try (FileReader reader = new FileReader(file)) {
//            StreamTokenizer tokenizer = new StreamTokenizer(reader);
//
//        }