/*
Description: This file is an exception class called CharException that extends 
from Exception and will be thrown if the char being passed is not within the 
parameters of 32 or 127. Please reference (http://www.asciitable.com/) to see 
why those numbers are selected. 
 */  


package pkgchar;

/**
 *
 * @author antho
 */
public class CharException extends Exception{
    public CharException(){
        super("Invalid Character");
    }
    
    public CharException(String errorMsg){
        super(errorMsg);
    }
}
