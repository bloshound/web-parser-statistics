Консольное приложение для скачивания, парсинга и сохрения html в базе данных. При запуске требуется ввести url адрес существующего сайта в интернете.
Url требуется обязательно вводить с указанием протокола(http или https). Если указаны url без протокола, или сайт по указанному адресу
не может быть получен,или указан неправильный адрес, перехватывается Exception и следует повторный ввод - до тех пор пока не будет
введено слово exit - в этом случае программа будет закрыта.

В программе используется Spring boot. В частности Spring boot JPA для сохранения сущностей в базе данных (PostgreSQL).
Сущностью является описание нашего сайта - url, и карта содержащая слова с данного сайта c количеством вхождений на данной html странице.

Утилитные методы представлены 3 классами:
 1) HTMLDownloader - для скачки html страницы с веденного url на локальный носитель.
 2) HTMLParser - для парсинга данной html страницы и получения чистого текста без тегов.
 3) Util - для разбора существующего текста на слова (по разделителям согласно условию). подсчета входждений слов в карту
 и сортировку.
 
 SiteService - пока только делает сохранение url в базу данных 
 MainService - основная логика приложения
 
 
Console application for downloading, parsing and saving html in the database. When launching, you need to enter the url address of an existing website on the Internet.
Url must be entered indicating the protocol (http or https). If url without protocol is specified, or the site at the specified address
cannot be received, or an incorrect address is specified, an Exception is caught and the re-entry follows - until there is
the word exit is entered - in this case, the program will be closed.
 
The program uses Spring boot. Specifically Spring boot JPA for persisting entities in a database (PostgreSQL).
The essence is the description of our site - url, and a map containing words from this site with the number of occurrences on this html page.

Utility methods are represented by 3 classes:
 1) HTMLDownloader - to download the html page from the entered url to the local media.
 2) HTMLParser - for parsing the given html page and getting clean text without tags.
 3) Util - for parsing the existing text into words (by separators according to the condition). counting word entries into the map
 and sorting.
 
 SiteService - for now, only makes saving url to the database
 MainService - the main logic of the application