import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        File file = new File(Main.class.getResource("/int").toURI());
        //getResource() отправляет запрос к загрузчику классов, который и ищет в CLASSPATH
        //toUri https://www.tutorialspoint.com/java/io/file_uri.html

        String fileText = "";
        try (FileReader reader = new FileReader(file)) {   //FileReader в Java - это класс, который мы используем для чтения данных из файла. Возвращает строковое представление файлового объекта
            StringBuffer sb = new StringBuffer();      //String простой еще не могла использовать потому что иначе не будет доступен append  Для работы с текстовыми данными в Java есть три класса: String, StringBuffer и StringBuilder. Чтобы справиться с созданием временного мусора из-за модификаций объекта String, можно использовать класс StringBuffer.   https://javarush.ru/groups/posts/2351-znakomstvo-so-string-stringbuffer-i-stringbuilder-v-java
            while (reader.ready()) {              // Метод read () класса FileReader в Java считывает из файла по одному символу за раз.  Пока там все читается
                sb.append((char)reader.read());
            }
            fileText = sb.toString();
        }
        //try потому что оно выполнит и выйдет и закончит выполнение/ и если вдруг не выполнит то покажет ошибку потому что это потенциально проблемный код (http://developer.alexanderklimov.ru/android/java/exception.php#try)
        //я сюда указываю ресурс и он после выхода из try очищает все
//шото я хз надо ли сюда catch

        List<BigInteger> bigIntegersFromFile = Arrays.stream(fileText.split(" "))
                .map(BigInteger::new)    //https://annimon.com/article/2778
                .collect(Collectors.toList());

        BigInteger bigsum = BigInteger.ZERO;
        for(int i = 0; i < bigIntegersFromFile.size() ; i++)
            bigsum = bigsum.add(new BigInteger(String.valueOf(bigIntegersFromFile.get(i))));
        System.out.println("Сумма всех чисел в файле " + bigsum);

    }
}
