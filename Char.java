/*
Description: This file/class is a complex type called Char that models the primitive
type char. It has multiple constructors that for the most part attempt to follow 
the one code path. This file will assist in storing a character, in order to make a 
bigDecimal possible.
 */  

package pkgchar;


public class Char {
    
    //Data section of the class
    
    private char character;
    
                     //********* CONSTRUCTORS ********** following the one code path
    
    public Char(){
       this(0);
    }
    
    public Char(char c){
        this.character = c;
    }
    
    public Char(int c){
        this((char)c);
    }
    
    
    //Need some help with this one, might need to ask a question about this constructor
    public Char(final Char c){
        this(c.toChar());
    }
    
    public Char(String c){
        this(c.charAt(0));
    }
    
                    // ********** MUTATOR Methods ***********
    
    /*
    Function: equals(final Char c) (Overloaded method)
    Description: This method sets the data section to the data section of the argument
    Inputs: A Char complex type is required for input
    Outputs: No outputs 
    */
    
    public void equals(final Char c){
        this.equals(c.toChar());
    }
    
    /*
    Function: equals(char c) (Overloaded method)
    Description: This method sets the data section to the primitive argument
    Inputs: A primitive char 
    Outputs: No outputs 
    */
    
    public void equals(char c){
        this.character = c;
    }
    
    /*
    Function: equals with int parameter
    Description: This method sets the data section of the class as a character
    from the int argument. This method will throw an exception if the int that 
    is passed is less than 32 or greater than 127. (Reference the ASCII table)
    to gain a better understanding if why.
    Inputs: An int between 32 and 127, to include those numbers
    Outputs: No outputs 
    */
    
    
    public void equals(int c) throws CharException{
    
        if(c < 32 || c > 127){
            throw new CharException();
        } else {
            this.equals((char)c); 
        }
           
    }
    
                    // ********** ACCESSOR Methods ***********
    
    /*
    Function: toChar
    Description: This method simply returns the data section of the class.
    Inputs: None
    Outputs: It will return the primitive char that is currently being held in 
    the data section
    */
    
    public char toChar(){
        return character;
    }
    
    /*
    Function: toInt
    Description: This method will return the data section of the class as an int
    Inputs: None
    Outputs: It will return an int data type based on the char value in the data 
    section
    */
    
    public int toInt(){
        return (int)character;
    }
    
    /*
    Function: toString
    Description: This method returns the data section of the class as a string
    Inputs: None
    Outputs: a String of the primitive character in the data section will be the output
    */
    
    public String toString(){
        return "" + character;
    }
    
    /*
    Function: toHexString
    Description: This method returns the class as a hexidecimal string
    Inputs: None
    Outputs: a Hexidecimal value of the primitive char stored in the data section
    */
    
    public String toHexString(){
        String str = Integer.toHexString(toInt());
        return str;  
    }
    
    /*
    Function: String add(char c)(overloaded method)
    Description: This method concatenates the data section of the class with the 
    parameter and returns the value as a string
    Inputs: You need to pass a primitive char as a parameter
    Outputs: a String with two primitive chars
    */
    
    public String add(char c){
        String str = this.toString() + c;
        return str;
    }
    
    /*
    Function: String add(final Char c)(overloaded method)
    Description: This method concatenates the data section of the class with the 
    data section of the parameter and returns the two characters as a string.
    Inputs: a complex type 
    Outputs: a String with two primitive chars
    */
    
    
    //This method might need some work
    //passing something as a parameter has to deal with reference primitive type and heaps its a memory thing
    public String add(final Char c){
        
        String str = "" + this.toChar();
        str += c.toChar();
        
        return str;
    }

    
}
