/*
Description: This file is an exception class called BigDecimalException that is 
derived from the CharException class. It is thrown when more than one decimal is 
being set, or when the character being passed is not a valid character (e.g. digits
or decimals).
 */  


package pkgchar;

/**
 *
 * @author antho
 */
public class BigDecimalException extends CharException{
    
    public BigDecimalException(){
        super("Invalid Character for BigDecimal");
    }
    
    
}
