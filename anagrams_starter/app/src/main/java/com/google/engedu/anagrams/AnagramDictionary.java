package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private static int wordlength=3;
    private Random random = new Random();

    public HashSet<String> wordSet = new  HashSet<String>();
    public ArrayList<String> wordList = new ArrayList<String>();
    public HashMap<String,ArrayList<String>> lettersToWord= new HashMap<String,ArrayList<String>>();
    public HashMap<Integer,ArrayList<String>> sizeToWord= new HashMap<Integer,ArrayList<String>>();

    String alpha,line;

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));

        while((line = in.readLine()) != null) {
            String word = line.trim();

            wordList.add(word);
            wordSet.add(word);
            String alpha;
            alpha=alphabeticalOrder(word);
            ArrayList<String> temp_words1=new ArrayList<String>();
            if(lettersToWord.containsKey(alpha)){     //here finding that the word are coming is in hash map or not if yes then put it in same key hash map
                                                           //else generate the new key of alphaorder and put word value in it.

                temp_words1=lettersToWord.get(alpha);
                temp_words1.add(word);
                lettersToWord.put(alpha,temp_words1);
            }

            else{
                temp_words1.add(word);
                lettersToWord.put(alpha,temp_words1);
            }
            ArrayList<String> temp_word2=new ArrayList<String>();
            int l=word.length();
            if(sizeToWord.containsKey(l)){

                temp_word2=sizeToWord.get(l);
                temp_word2.add(word);
                sizeToWord.put(l,temp_word2);
            }
            else{
                temp_word2.add(word);
                sizeToWord.put(l,temp_word2);
            }






        }
    }

    public String alphabeticalOrder(String word){
        char[] charArray =word.toCharArray();
        Arrays.sort(charArray);
        String newWord = new String(charArray);

        return newWord;
    }


    public boolean isGoodWord(String word, String base) {

        if(wordSet.contains(word)&&!word.contains(base))
            return true ;
        else
            return false;
    }


    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        String alpha=alphabeticalOrder(word);
        String newWord;

        for(char c='a';c<='z';c++){
            newWord=c+alpha;
            newWord=alphabeticalOrder(newWord);

            if(lettersToWord.containsKey(newWord)){
                result.addAll(lettersToWord.get(newWord));
            }
        }

        for(int i=0;i<result.size();i++){
            //  Log.d("AD list",result.get(i));
            if(!isGoodWord(result.get(i),word)){
                //    Log.d("AD removed",result.remove(i));
                result.remove(i);
            }
        }

        return result;
    }


    public String pickGoodStarterWord() {
        String word=new String();
        int j;
        ArrayList<String>lengthWords=new ArrayList<String>();
        if(wordlength<=MAX_WORD_LENGTH){
            lengthWords=sizeToWord.get(wordlength);
        }
        int i=random.nextInt(lengthWords.size());
        for(j=i;j<lengthWords.size();j++){

            if(getAnagramsWithOneMoreLetter(lengthWords.get(j)).size()>=MIN_NUM_ANAGRAMS){
                word=lengthWords.get(j);
                break;
            }
        }
        if(j==lengthWords.size()-1&&word==null){
            for(j=0;j<i;j++){
                if(getAnagramsWithOneMoreLetter(lengthWords.get(j)).size()>=MIN_NUM_ANAGRAMS){
                    word=lengthWords.get(j);
                    break;
                }

            }
        }

        if(wordlength<=MAX_WORD_LENGTH){
            wordlength++;
        }
        return word;
    }


}
