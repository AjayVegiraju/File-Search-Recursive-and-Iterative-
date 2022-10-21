import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class FindFile {
    private final int maxFiles;
    private int count = 0;
    private final String[] files;

    /**
     * @param maxFiles- the user specified limit
     * sets the private instance variable to a value of user's liking
     * and makes a new string array if that size
     *
     */
    public FindFile(int maxFiles) {
        this.maxFiles = maxFiles;
        files = new String[maxFiles];
    }

    /**
     * @param target- The name of the file we that is being found
     * @param dirName- the path of the directory
     *
     * Acts as an interface but really only throws an exception
     *
     * @throws FileNotFoundException- if the file specified does not exist
     */
    public void directorySearch(String target, String dirName) throws FileNotFoundException {

        File f = new File(dirName);
        if(f.exists()){
            directorySearch(f, target);
        }else{
            throw new FileNotFoundException("File does not exist");
        }


    }

    /**
     * @param file- A directory that we are trying to find a target in (based off of dirName)
     * @param target- a file in the directory that we are trying to find
     *
     * This method is a facade that recursively searches for a file in a directory
     *
     * @throws IllegalArgumentException- if the number of occurrences of the file name is more than
     *                                   maxFiles
     */
    private void directorySearch(File file, String target)
            throws IllegalArgumentException {
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                directorySearch(f, target);
            }
        } else {
            if (file.getName().equals(target)) {
                if (count < maxFiles) {
                    files[count] = file.toString();
                    count++;
                } else {
                    throw new IllegalArgumentException("Number of duplicate" +
                            " files is more than specified");
                }
            }
        }
    }

    /**
     * @return maxFiles
     */
    public int getMaxFiles() {
        return maxFiles;
    }

    /**
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count
     *
     * safely set count parameter to this.count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return files array
     */
    public String[] getFiles() {
        return files;
    }
}
