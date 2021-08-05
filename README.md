# BigDecimal-Program
This program handles large numbers, large numbers that would otherwise break primitive data types.


This program does a couple of things.
it handles BigDecimals using the Char class which is suppose to act like the primitive char.
It stores the collection of Chars in an ArrayList which can be very useful when comparing 
adding, or subtracting BigDecimals. This program also reads a txt file called Numbers.txt 
which contains a sizeable amount of BigDecimals. Once it has read all of the BigDecimals
and once it has stored an ArrayList of BigDecimals in the class, it will then parse through
the BigDecimals in order to sperate the whole number from the fraction, and write that information
to the respective file. Remember, you have to enter the file path in order to read and write. Look 
in the main method for how to properly utilize the copyAndParseFile() method. 
