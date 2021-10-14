import java.io.IOException;
import java.io.StreamTokenizer;
import java.math.BigInteger;


public class TokenizerFile {

    public static boolean readTokenizer(StreamTokenizer tokenizer) throws IOException {
        BigInteger bigsum = BigInteger.ZERO;
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    bigsum = bigsum.add(new BigInteger(tokenizer.sval));

                }
            }
            System.out.println("Сумма всех чисел в файле " + bigsum);

        return false;
    }
}

//10102021
//в другой функции менй у меня будет создание токенайзера и мы передеаем его в вфункцю ридтокенайзер (вызывывая ридтокенайзер)

//__________________________________________________________________________
//14 строка throws IOException для функции main не имеют смысла/ лучше чтобы в коде было написано что мы  IOException обрабатываем и пишем в
// лог такую проблему и если я оставлю как у меня есть то у меня будет кусок данных из джава машины где буде написано что случилось
//готово

//название файла переименовать инт
//готово

//16 строка "/NumberList" лучше писать или относительный или абсолютный. у меня абсолютный путь. это опасно потому что при переименовании директории будет
//не смогла относительный путь сделать

//надо почитать как выглядят структуры данных
//arraylist linkedlist hashmap hashteble
//  в этой стриме создается аррей лист и там применяются к нему стримы и можно было
//в стрим есть один из механизмов получения стримапи джава - этот файл мы могли считать с помощью стримапиджава

//ГОТОВО
//вместо 37 строки forEach она может просто проводиь сравнение с двумя числами/ брать одно значение и предыдущее значение и проводить операции и необязательно делать второй цикл
//for (type itVar : array)
//{
//    Блок операторов;
//}
// у нас есть итератор по самому обьекту коллекции и мы просто берем следующий и следующий и добавляем к нему какие-то действия
//

//бигинтеджер выделяются на стеке и такие числа бигинтеджер и бигдецимал они представляют обьекты памяти это обьем памяти где я могу хранить число/ проблема простых чисел в том что когда они переполняются и возникают ошибки переполнения и они переходят в следующее число/ и вместо 9.99  млрд + 1 в простых числах будет 0 //
// бигдецимл - запрещено использовтаь дабл, невозможно представить дробное число с максимальной точностью - из-за того что мы используем числа в  которых числа флот и дабл это примитывы с огрниченным размером и мы получаем ограниченную точность
//https://habr.com/ru/company/luxoft/blog/270383/
//https://habr.com/ru/post/219595/ - об опансности исползования расчета максимальных обьектов/ ошибки округления постоянно происходят - самое простое это считать в центах и копейках

//ГОТОВО
// 20 строка - я считываю туда сразу весь файл - это проблема/ я из этого файла прочитала числа - и получается что памяти в два раза больше израсходовалось
//у меня есть 2 массива - один со строками а потмо с числами
//надо считать файл просто по кусочкам. надо считывать даже не строку а символ
//считала - обработала и пошла дальше. для этого в java есть другой класс называется
// StreamTokenizer - он считывает значения из файла по порядку/ считала оддно значение - обработала


//когда в команду пишут обычно они используют библиотеку где есть обработка ситуаций типа под каким ключем задвать различные
// параметры например чтобы вывести хелп, добавить попции в программе и одна из опций это имя файла
//эту библиотеку надо встроить в приложение
//подгтовить рассказ как работает почему работает и приветси пример использования пункта 1


//1) List Map -> LinkedList ArrayList HashMap, придумать пару примеров, + TreeMap и объяснить как работает РАССКАЗ!!!!
//Stream API  - новый способ взаимодействия с данными, представляя их в виде конечного потока данных.
//  - map — прибавляет число к каждому числу например  .map(x -> x + 11)

//toCollection(Supplier collectionFactory)
//Собирает элементы в заданную коллекцию. Если нужно конкретно указать, какой List, Set или другую коллекцию мы хотим использовать, то этот метод поможет.
//например Deque<Integer> deque = Stream.of(1, 2, 3, 4, 5)
//    .collect(Collectors.toCollection(ArrayDeque::new));
//
//Set<Integer> set = Stream.of(1, 2, 3, 4, 5)
//    .collect(Collectors.toCollection(LinkedHashSet::new));

//Пример   HashMap  Дан массив аргументов. Нужно получить Map, где каждому ключу будет соответствовать своё значение.
//String[] arguments = {"-i", "in.txt", "--limit", "40", "-d", "1", "-o", "out.txt"};
//Map<String, String> argsMap = new LinkedHashMap<>(arguments.length / 2);
//for (int i = 0; i < arguments.length; i += 2) {
//    argsMap.put(arguments[i], arguments[i + 1]);
//}
//argsMap.forEach((key, value) -> System.out.format("%s: %s%n", key, value));
//

//  Пример ArrayList
//дан список студентов
//List<Student> students = Arrays.asList(
//        new Student("Alex", Speciality.Physics, 1),
//        new Student("Rika", Speciality.Biology, 4),
//        new Student("Julia", Speciality.Biology, 2),
//        new Student("Steve", Speciality.History, 4),
//
//);
//
//enum Speciality {
//    Biology, ComputerScience, Economics, Finance,
//    History, Philosophy, Physics, Psychology
//}
//
//    У класса Student реализованы все геттеры и сеттеры, toString и equals+hashCode.
//
//        Нужно сгруппировать всех студентов по курсу.
//        students.stream()
//        .collect(Collectors.groupingBy(Student::getYear))
//        .entrySet().forEach(System.out::println);
// 1=[Alex: Physics 1, Mike: Finance 1, Richard: History 1, Ann: Psychology 1]
// 2=[Julia: Biology 2, Hinata: Biology 2, Kate: Psychology 2]
// 3=[Maximilian: ComputerScience 3]
// 4=[Rika: Biology 4, Steve: History 4, Sergey: ComputerScience 4]
// 5=[Tim: ComputerScience 5]

//stream api преобразование в tree map https://coderoad.ru/35116264/Java-8-Stream-API-toMap-%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B2-TreeMap

//1.1) toString() hashCode() equals()


//2) http://sp.freehat.cc/episode/1501/?PAGEN_1=49 про лицензионное соглашение
//3) Вынести в отдельную функцию, применить StreamTokenizer, имя файла в аргументах
//https://www.frolov-lib.ru/books/bsp/v32/ch2_11.htm

//4) Найти библиотеку для работы с аргументами командной строки и встроить ее в приложение



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