public class LinearSearch extends SearchAlgorithm {


    /**
     * @param words- the array of words from the file
     * @param wordToFind- the target word we are trying to find
     * Pre-Condition: Array of Strings only, Target has to be a string
     * Post-Condition: Gives the index of the item if it has been found
     *
     * @return int Index of Item in the list
     * @throws ItemNotFoundException- when the target word is not in the array
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[count].equals(wordToFind)){
                flag=true;
                return count;
            }
            count++;
            incrementCount();
        }
        if(!flag){
            throw new ItemNotFoundException();
        }
        return -1;
    }


    /**
     * @param words- the array of words from the file
     * @param wordToFind- the target word we are trying to find
     * @return int value of the facade method
     * @throws ItemNotFoundException- when the target word is not in the array
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {

        return recSearch(words,0, words.length, wordToFind);
    }

    /**
     * @param words- the array of words from the file
     * @param start- starting index of the range of comparison
     * @param end- ending index of the range of comparison
     * @param wordToFind- the target word we are trying to find
     *
     * This method is a facade to employ a recursive linear search which needs more parameters than
     * the original method. It calls the method with new start and end points till the word is found
     * if it is not found it throws a ItemNotFoundException
     *
     * @return index of the word or exception
     * @throws ItemNotFoundException- when the target word is not in the array
     */
    public int recSearch(String[] words,int start, int end, String wordToFind) throws ItemNotFoundException{
        if(end<start){
            throw new ItemNotFoundException();
        }
        if(words[start].equals(wordToFind)){
            return start;
        }

        return recSearch(words,start+1, end,wordToFind);
    }
}
