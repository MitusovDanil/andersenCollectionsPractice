import java.util.*;



public class CollectionsPractice <T> {
    /**
     * Напишите метод, который на вход получает коллекцию объектов,
     * а возвращает коллекцию уже без дубликатов.
     */
    public Collection <T> getCollectionWithoutDoublets(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    /**
     * Напишите метод, который получает на вход массив элементов типа К (Generic) и возвращает Map<K, Integer>,
     * где K — значение из массива, а Integer — количество вхождений в массив.
     */

    public Map<T,Integer> countRepetitions (List<T> list) {
        Map<T, Integer> map = new HashMap<>();
        for (T element : list) {
            map.put(element, Collections.frequency(list, element));
        }
        return map;
    }
}
