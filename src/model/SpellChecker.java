/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Oshen Sathsara <oshensathsara2003@gmail.com>
 */
public class SpellChecker {

    private Set<String> dictionary;

    public SpellChecker() {
        dictionary = new HashSet<>();
        loadDictionary();
    }

    private void loadDictionary() {
        try {
            InputStream inputstream = getClass().getResourceAsStream("/resources/dictionary/dictionary.txt");
            if (inputstream == null) {
                System.err.println("Dictinory not found!");
                return;
            }

            BufferedReader r = new BufferedReader(new InputStreamReader(inputstream));
            String word;
            while ((word = r.readLine()) != null) {
                dictionary.add(word.toLowerCase().trim());
            }
            r.close();
            System.out.println("Dictionary loaded");

        } catch (IOException e) {
            System.out.println("dictionary loading failed" + e.getMessage());
        }
    }
    
    public boolean isWordCorrect(String word){
    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
    return dictionary.contains(word);
    }

}
