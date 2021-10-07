import java.io.*;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingFile {


    public static void main(String[] args) throws URISyntaxException {

       File file = new File(Main.class.getResource("/NumberList").toURI());
     //   FileReader file = new FileReader("NumberList");

// не понимаю как относительный путь сделать нормально

        String fileText = "";

        try (FileReader reader = new FileReader(file)) {
            StreamTokenizer tokenizer = new StreamTokenizer(reader); //StreamTokenizer считывает поток за символом.
            tokenizer.nextToken();


//            for (int k = 0; k != tokenizer.TT_EOL; k++) {
//                if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
//                    System.out.println(i);
//                    array[i++] = (int) tokenizer.nval;
//                }
//            }



//            throw new IOException();
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char)reader.read());
            }
            fileText = sb.toString();
        }


//        public static List<Object> streamTokenizerWithDefaultConfiguration(Reader reader) throws IOException {
//            StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
//            List<Object> tokens = new ArrayList<Object>();
//
//            int currentToken = streamTokenizer.nextToken();
//            while (currentToken != StreamTokenizer.TT_EOF) {
//
//                if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
//                    tokens.add(streamTokenizer.nval);
//                } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
//                        || streamTokenizer.ttype == QUOTE_CHARACTER
//                        || streamTokenizer.ttype == DOUBLE_QUOTE_CHARACTER) {
//                    tokens.add(streamTokenizer.sval);
//                } else {

        catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Не получилось сложить числа");
        }

        List<BigInteger> bigIntegersFromFile = Arrays.stream(fileText.split(" "))
                .map(BigInteger::new)
                .collect(Collectors.toList());

        BigInteger bigsum = BigInteger.ZERO;
        for (BigInteger s : bigIntegersFromFile)
        {
            bigsum = bigsum.add(s);
            System.out.println("Сумма всех чисел в файле " + bigsum);
        }

    }
}


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


//1.1) toString() hashCode() equals()


//2) http://sp.freehat.cc/episode/1501/?PAGEN_1=49 про лицензионное соглашение
//3) Вынести в отдельную функцию, применить StreamTokenizer, имя файла в аргументах
//https://www.frolov-lib.ru/books/bsp/v32/ch2_11.htm

//4) Найти библиотеку для работы с аргументами командной строки и встроить ее в приложение