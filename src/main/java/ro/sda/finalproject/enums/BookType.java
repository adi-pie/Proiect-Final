package ro.sda.finalproject.enums;

public enum BookType {ROMANCE ("Romance"),
    RELIGIOUS ("Religious"),
    SCI_FICTION ("Science-Fiction"),
    HUMANITIES ("Humanities"),
    SCIENCE ("Science");

   private final String displayValue;

   private BookType (String displayValue){
   this.displayValue = displayValue;
   }

   public String getDisplayValue(){
       return displayValue;
   }


}
