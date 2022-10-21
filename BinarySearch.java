
public class BinarySearch extends SearchAlgorithm {

    public BinarySearch(){

        System.out.println("This is a Binary Search object");
    }

    /**
     * @param words - array of words from the file
     * @param wordToFind- target word that we want to find
     * @return and Int of whatever the facade method returns
     * @throws ItemNotFoundException - if target is not in the array
     */
    @Override
    public int search(String[] words, String wordToFind) throws ItemNotFoundException {
        return search(words,0,words.length,wordToFind);
    }

    /**
     * @param words- the array of words from the file
     * @param start- starting index of the range of comparison
     * @param end- ending index of the range of comparison
     * @param wordToFind- target word that we want to find
     *
     * This method is a facade that enables binary search. It uses the
     * compareTo() method to lexicographically compare two strings and
     * adjust the endpoints accordingly
     *
     * @return an int value of the index at which the word is present or throws
     * ItemNotFoundException if there are no instances of the word in the array
     * @throws ItemNotFoundException- if target is not in the array
     */
    private int search(String[]words, int start, int end, String wordToFind)throws ItemNotFoundException{
       start = 0;
       end = words.length;

       while(start<=end){
           int mid = (start+end)/2;

           int comp = wordToFind.compareTo(words[mid]);

           if(comp==0){
               incrementCount();
               return mid;
           }
           if(comp>0){
               incrementCount();
               start=mid+1;
           }
           if(comp<0){
               incrementCount();
               end=mid-1;
           }
       }
       throw new ItemNotFoundException();
    }


    /**
     * @param words- the array of words from the file
     * @param wordToFind- target word that we want to find
     * @return int value of the facade method
     *
     * The method that is used as interface for the more useful facade method
     *
     * @throws ItemNotFoundException- if target is not in the array
     */
    @Override
    public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
        return recSearch(words,0, words.length, wordToFind);
    }


    /**
     * @param words- the array of words from the file
     * @param start- starting index of the range of comparison
     * @param end- ending index of the range of comparison
     * @param wordToFind- target word that we want to find
     *
     * This method is a facade that takes in all necessary elements to
     * perform a recursive binary search and returns the index of the target
     *
     * @return int value of the index of the target
     * @throws ItemNotFoundException- if target is not in the array
     */
    private int recSearch(String[]words, int start, int end, String wordToFind) throws ItemNotFoundException {
        if(start>end){
            throw new ItemNotFoundException();
        }
        int mid = (start+end)/2;
        int comp = wordToFind.compareTo(words[mid]);
        if(comp==0){
            incrementCount();
            return mid;
        }else if(comp<0){
            incrementCount();
            return recSearch(words,start,mid-1,wordToFind);
        }else {
            incrementCount();
            return recSearch(words,mid+1,end,wordToFind);
        }
    }
}
