public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(){
        super("Item you want has not been found");
    }

    public ItemNotFoundException(String msg){
        super(msg);
    }

}
