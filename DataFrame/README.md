CZĘŚĆ 1

Zaimplementuj klasę DataFrame, która pozwalać będzie na przechowywanie dowolnej ilości danych, dowolnego typu (predefiniowanego wcześniej) w formacie kolumnowym (analogicznie jak w bazie danych). Konstruktor tej klasy powinien przyjmować jako parametry listę stringów, określającą nazwy kolumn, oraz listę typów określającą typy poszczególnych kolumn:

DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                         new String[]{"int","double","float"}
Wymagania dodatkowe
* Kolumny powinny być przechowywane jako obiekty Series, które pod spodem wykorzystują strukturę ArrayList
* Klasa powinna posiadać metody:
  * size() – zwracającą ilość wierszy w całej DF (uwaga – DF nie może mieć jednej z kolumn dłuższej niż pozostałe
  * get(String colname) – zwracającą kolumnę o podanej nazwie
  * get(String [] cols, boolean copy) – zwracającą nową DataFrame z kolumnami podanymi jako parametry. W zależności od wartości parametru copy albo tworzona jest głęboka kopia, albo płytka.
  * addColumn(String colname, String dtype, boolean inplace) -- dodaje kolumnę przechowujacą określony typ. Jeśli inplace jest ustawione na True, modyfikowana jest istniejąca DataFrame, w przeciwnym razie zwracana jest nowa DataFrame
  * addRow(String[] datarow, boolean inplace) -- dodaje do istniejącej DataFrame wiersz z danymi. Jeśli inplace jest ustawione na True, modyfikowana jest istniejąca DataFrame, w przeciwnym razie zwracana jest nowa DataFrame
  * ilocSet(int i, String c, String value) -- ustawia wartość value dla i-tego  wiersza i c-tej  kolumny. Uwaga, operacja jest wykonywana w miejscu (inplace)
  * iloc(int i) – zwracającą wiersz o podanym indeksie (jako nową DataFrame)
  * iloc(int from, int to) – zwracającą nową DataFrame z wierszami z podanego zakresu
  
CZĘŚĆ 2
  
Do tej pory kolumny przechowywały typy Object, lub z góry okreslone typy. Powoduje to sporo problemów z przetwarzaniem takich danych (ciągłe rzutowanie, sprawdzanie typów, etc.)

* Dodaj klasę abstrakcyjną Value, która będzie posiadać następujące metody:
  * public abstract String toString()
  * public abstract Value add(Value)
  * public abstract Value sub(Value)
  * public abstract Value mul(Value)
  * public abstract Value div(Value)
  * public abstract Value pow(Value)
  * public abstract boolean eq(Value)
  * public abstract boolean lte(Value)
  * public abstract boolean gte(Value)
  * public abstract boolean neq(Value)
  * public abstract boolean equals(Object other)
  * public abstract int hashCode()
  * public abstract Value create(String s) – tworzy konkretny obiekt ze stringa (wartość obiektu jest podana jako string)
* zaimplementuj klasy dziedziczące po Value, implementujące konkretne wartości: Integer, Double, Float, String, DateTime.

Zmodyfikuj konstruktory DataFrame, tak aby zamiast listy stringów przyjmowała listę Class<? extends Value>[]. Następnie nowy obiekt można utworzyć za pomocą metody newInstance().create(…).
Dodatkowe: to mało eleganckie rozwiązanie, bo pozwala na stworzenie instancji pustego obiektu Value. Zastanów się jak ten problem rozwiązać za pomocą wzorca Builder (zobacz wstęp teoretyczny do lab).
