public class Driver {

    public static void main(String[] args) {
        FindFile a = new FindFile(3);

        try {
            a.directorySearch("file2.txt", "C:\\Users\\Ajay Vegiraju\\OneDrive\\Documents\\diretory");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //prints the appropriate file paths
        for (String i : a.getFiles()) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}
