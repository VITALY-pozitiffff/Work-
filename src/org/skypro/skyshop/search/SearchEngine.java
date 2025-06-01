package org.skypro.skyshop.search;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SearchEngine<K extends Searchable> {
    private List<K> searchables=new ArrayList<>();




    public void add(K k) {
        searchables.add(k);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                // Используем searchTerm как ключ, TreeMap автоматически сортирует по ключам
                results.put(searchable.getSearchTerm(), searchable);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            String searchTerm = searchable.getSearchTerm();
            int count = countOccurrences(searchTerm, search);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}




