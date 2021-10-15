import java.io.*;
import java.net.URI;

import org.apache.commons.cli.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) throws IOException {
        //https://urvanov.ru/2019/06/08/apache-commons-cli/
        Options option = new Options();
        option.addRequiredOption("P", "path",
                true, "Path");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(option, args);
        } catch (ParseException pe) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( " Введите путь", option );
        }

        if (cmd.hasOption("P")) {
            System.out.println("Путь введен");
            String getPath = cmd.getOptionValue("P");
            FileReader file = new FileReader(getPath);
            StreamTokenizer streamTokenizer = new StreamTokenizer(file);


            System.out.println(TokenizerFile.readTokenizer(streamTokenizer));

        }
        else {
            System.out.println("Ошибка");

        }

    }
}


//14 строка throws IOException для функции main не имеют смысла/ лучше чтобы в коде было написано что мы  IOException обрабатываем и пишем в
// лог такую проблему и если я оставлю как у меня есть то у меня будет кусок данных из джава машины где буде написано что случилось

//название файла переименовать инт

//16 строка "/NumberList" лучше писать или относительный или абсолютный. у меня абсолютный путь. это опасно потому что при переименовании директории будет


//надо почитать как выглядть структуры данных
//arraylist linkedlist hashmap hashteble
 //  в этой стриме создается аррей лист и там применяются к нему стримы и можно было
//в стрим есть один из механизмов получения стримапи джава - этот файл мы могли считать с помощью стримапиджава


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

// 20 строка - я считываю туда сразу весь файл - это проблема/ я из этого файла прочитала числа - и получается что памяти в два раза больше израсходовалось
//у меня есть 2 массива - один со строками а потмо с числами
//надо считать файл просто по кусочкам. надо считывать даже не строку а символ
//считала - обработала и пошла дальше. для этого в java есть другой класс называется StreamTokenizer - он считывает значения из файла по порядку/ считала оддно значение - обработала

//когда в команду пишут обычно они используют библиотеку где есть обработка ситуаций типа под каким ключем задвать различные параметры например чтобы вывести хелп, добавить попции в программе и одна из опций это имя файла
//эту библиотеку надо встроить в приложение
//подгтовить рассказ как работает почему работает и приветси пример использования пункта 1