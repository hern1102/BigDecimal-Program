/*
Description: THIS WILL BE THE MAIN FILE OF THE PROGRAM. This program does a couple of things.
it handles BigDecimals using the Char class which is suppose to act like the primitive char.
It stores the collection of Chars in an ArrayList which can be very useful when comparing 
adding, or subtracting BigDecimals. This program also reads a txt file called Numbers.txt 
which contains a sizeable amount of BigDecimals. Once it has read all of the BigDecimals
and once it has stored an ArrayList of BigDecimals in the class, it will then parse through
the BigDecimals in order to sperate the whole number from the fraction, and write that information
to the respective file. Remember, you have to enter the file path in order to read and write. Look 
in the main method for how to properly utilize the copyAndParseFile() method. 
 */  

package pkgchar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class BigDecimal {
    
    /*
    ArrayList below is a container that will allow me to store
    all of the Chars in order to make a big decimal
    */
    
    private ArrayList<Char> aryList = new ArrayList<>();
    private ArrayList<BigDecimal> bdArrayList = new ArrayList<>();
    
    /*
    A Char object is created in order to store multiple instances of Chars, and
    access the functionality of Char to make big decimal happen.
    */
    private Char charObject;

                        // ********  CONSTRUCTORS  ********
    
    public BigDecimal() throws BigDecimalException{
        this("0.0");
    }
    
    public BigDecimal(String str) throws BigDecimalException{
        
        this.equals(str);
          
    }
    
    
                        //******** MUTATOR methods *********
    
    
    /*
    Function: equals (char ch)(overloaded method)
    Description: This method adds a char to the container
    Inputs: a primitive char that will be added to the container
    Outputs: None
    */
    
    public void equals(char ch)throws BigDecimalException{
        int counter = 0;
        //Must determine if the value is actually a digit
        //Makes sure that there is only one decimal point
        
        if((int)ch == 46  || ((int)ch <= 57 && (int)ch >= 48)){ 
            for(Char c : aryList){
                if(c.toInt() == 46){
                    counter++;
                }
             }
            if((int)ch == 46 && counter == 1){
                throw new BigDecimalException();
            }else{
                aryList.add(charObject = new Char(ch));
            }
            
        } else {
            throw new BigDecimalException();
        }
    }
    
    /*
    Function: equals (String value)(overloaded method)
    Description: This method takes a string, and parses it in order to place
    each char in the container (ArrayList)
    Inputs: a string
    Outputs: None
    */
    
    public void equals(String str)throws BigDecimalException{
        
        for(int i = 0; i < str.length(); i++)
            this.equals(str.charAt(i));
            
    }
    
    /*
    Function: BigDecimal add(BigDecimal BigD)
    Description: Adds the value of two bigDecimals and returns the value
    Inputs: a big decimal is required in order to add two big decimals
    Outputs: a bigdecimal
    */
    
    
    public BigDecimal add(BigDecimal BigD) throws BigDecimalException{
        int carryFlag = 0;
        String mainBigD = String.valueOf(fraction());
        String parameterBigD = String.valueOf(BigD.fraction());
        
        int padding = Math.abs(mainBigD.length() -  parameterBigD.length());
        
        
        
        if(mainBigD.length() != parameterBigD.length()){
            if(mainBigD.length() > parameterBigD.length()){
                for(int i = 0; i < padding; i++){
                    
                    BigD.equals('0');
                    
                }
            } else {
                for(int i = 0; i < padding; i++){
                    
                    equals('0');
                    
                }
            }
            
        } 
          for(int i = aryList.size() - 1 ; i > -1 ; i--){
              
              if((this.at(i)).toString().equals(".") !=  true){
                 int sum = carryFlag + Integer.parseInt((this.at(i)).toString()) + Integer.parseInt((BigD.at(i)).toString());
              
              if(sum >= 10){
                  
                  carryFlag = 1;
                  sum = sum % 10;
                  
              } else {
                  carryFlag = 0;
              }
              
              this.at(i).equals(String.valueOf(sum).charAt(0)); 
           }   
              
          }
          
        return this;
    }
    
    /*
    Function: BigDecimal sub(BigDecimal)
    Description: This method subtracts two values and returns the result as a bigDecimal
    Inputs: a bigDecimal that is going to subtract another big decimal
    Outputs: ther result of two bigdecimals subtracted
    */
    
    public BigDecimal sub(BigDecimal BigD) throws BigDecimalException{
        
        BigDecimal num = BigD;
        BigDecimal bd = this;
        int counter = 0;
        int sum;
        String mainBigD = String.valueOf(fraction());
        String parameterBigD = String.valueOf(BigD.fraction());
        
        
        int padding = Math.abs(mainBigD.length() -  parameterBigD.length());
        
        
        
        if(mainBigD.length() != parameterBigD.length()){
            if(mainBigD.length() > parameterBigD.length()){
                for(int i = 0; i < padding; i++){
                    
                    num.equals('0');
                    
                }
            } else {
                for(int i = 0; i < padding; i++){
                    
                    equals('0');
                    
                }
            }
            
        } 
        
        if(Double.valueOf(toString()) > Double.valueOf(num.toString())){
            
            for(int i = num.toString().length() - 1 ; i > - 1; i--){
              
              if((num.at(i)).toString().equals(".") !=  true){
                 
                  if(counter == 0){
                      sum = 10 - Integer.parseInt((num.at(i)).toString());
                      counter++;
                  } else {
                      sum = 9 - Integer.parseInt((num.at(i)).toString());
                  }
              
              
              num.at(i).equals(String.valueOf(sum).charAt(0)); 
                  
              
              }

            }
            num = this.add(num);
            bd = num;
            
        } else if (Double.valueOf(toString()) < Double.valueOf(num.toString())){
            
            for(int i = this.toString().length() - 1 ; i > 0; i--){
              
              if((this.at(i)).toString().equals(".") !=  true){
                 
                  if(counter == 0){
                      sum = 10 - Integer.parseInt((this.at(i)).toString());
                      counter++;
                  } else {
                      sum = 9 - Integer.parseInt((this.at(i)).toString());
                  }
              
              
              this.at(i).equals(String.valueOf(sum).charAt(0)); 
   
              }

            }
            
             num = num.add(this);
             bd = num;
            
        } else {
            
            //if they are both the same size, and you are using this method
            //then call the default constructor which will cause the BigDecimal 
            //value to be 0.0. And return 0.0
            num = new BigDecimal();
            bd = num;
        }
        
        return bd;
    }
    

                         // ********* ACCESSOR methods **********

    /*
    Function: toDouble
    Description: returns the value stored in the container as a double
    Inputs:None
    Outputs: a double 
    */
    
    public double toDouble(){
        
        double dbl;
        dbl = Double.parseDouble(toString());
        return dbl;
        
    }
    
    /*
    Function: toString
    Description: returns the value stroed in the container as a string
    Inputs:none
    Outputs: a string of the value stored in the container
    */
    
    @Override
    public String toString(){
        String str;
        StringBuilder builder = new StringBuilder();
        // Append all Char in StringBuilder to the StringBuilder.
        for(Char ch : aryList) {
            builder.append(ch);
        }
        str = builder.toString();
        return str;
    }
    
    /*
    Function: Char at(int index)
    Description: returns the value at the particular index as a Char
    Inputs: the index for a char in an arraylist that you would liked returned
    Outputs: the Char you were looking for
    */
    
    public Char at(int index){
        Char ch;
        ch = (Char)aryList.get(index);
        return ch;
    }
    
    
        // ********    Additional methods that support File IO  **********
    
    
    /*
    Function: 
    Description: returns only the whole number portion of the decial number as an int
    Inputs: none
    Outputs: the output will be an int
    */

    public int wholeNumber(){
        int num;
        String tempNum = "";
        String str = toString();
        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i) != 46){
                char c = str.charAt(i);
                tempNum += c;
            }
            
            if((int)str.charAt(i + 1) == 46){
                num = Integer.parseInt(tempNum);
                return num;
            }
                
        }
        num = Integer.parseInt(tempNum);
        return num;
    }
    
    /*
    Function: fraction
    Description: returns the fractional portion of the number as a double
    Inputs: none
    Outputs: the output will be a double
    */
    
    
    
    public double fraction(){
        int counter = 0;
        double numDbl;
        String tempNum = "";
        String str = toString();
        for (int i = 0; i < str.length(); i++) {
            
            if((int)str.charAt(i) == 46){
                counter++;
                char c = str.charAt(i);
                tempNum += c;
                
            }
            
            if(counter == 1 && (int)str.charAt(i) != 46){
                char c = str.charAt(i);
                tempNum += c;
            }
              
        }
        numDbl = Double.parseDouble(tempNum);

        return numDbl;
        
    }
    
    
    /*
    Function: copyAndParseFile
    Description: This method will allow you read file line by line and will store the 
    contents as a bigDecimal in a collection of bidDecimals using ArrayList
    Inputs: This requires for you to pass a parameters the following: the file path for the
    file that you wish to read, the file path for the text file that you would like to put
    all the whole numbers in, and the file path that you would like to put all of the fractions
    in.
    Outputs: When calling the method, it will pass all of the above information parsed, 
    to the exact file paths that you passed.
    */
    
    
    public void copyAndParseFile(String path, String destWhole, String destFrac){
            bdArrayList = new ArrayList<>();
            BigDecimal bd;
            
            FileReader fr = null;
            BufferedReader br = null;
            BufferedWriter bw = null;
            FileWriter fw = null;
            
                   
            try{
                fr  = new FileReader(path);
                br = new BufferedReader(fr);
                fw = new FileWriter(destWhole);
                bw = new BufferedWriter(fw);
                
           
                
                String line;
                while((line = br.readLine()) != null){
                   bdArrayList.add(bd = new BigDecimal(line));
                } 
                
                for(BigDecimal BigD : bdArrayList){
                    
                    //bw.write(BigD.wholeNumber());
                    //bw.newLine();
                    //bw2.write(BigD.fraction());
                    //System.out.println(BigD.wholeNumber());
                    //System.out.println(BigD.fraction());
                    
                }
                
                writeFile(destWhole, destFrac);
                    
            }
            catch(Exception e){
                System.out.println("Error opening file");
                 }
            finally{
                try{
                    fr.close();
                    br.close();
                }
                catch(Exception e){
                System.out.println(e.getMessage());
                }
            }
    }
    
    /*
    Function: writeFile
    Description: this method writes the contents to the two file paths that are passed to
    it. It also incorporates two methods that allow for the parsing bid decimals. 
    It is incorporated into copyAndParseFile so you only have to call one function
    for this assignment.
    Inputs: two file paths you wish to write data to.
    Outputs: The two files that you provided will now have parsed information that 
    consist of whole numbers and their fractions.
    */
    
    public void writeFile(String WhNumPath, String fracNumPath){

        BufferedWriter bw1 = null;
        FileWriter fw1 = null;
        BufferedWriter bw2 = null;
        FileWriter fw2 = null;
        

        try 
        { 
          fw1 = new FileWriter(WhNumPath);
          bw1 = new BufferedWriter(fw1);
          fw2 = new FileWriter(fracNumPath);
          bw2 = new BufferedWriter(fw2);
          
          String line;
          
          for(BigDecimal BigD : bdArrayList){
            line = String.valueOf(BigD.wholeNumber());
                    bw1.write(line);
                    bw1.newLine();
          }
          
          for(BigDecimal BigD : bdArrayList){
            line = String.valueOf(BigD.fraction());
                    bw2.write(line);
                    bw2.newLine();
          }
          
        } 
        catch (Exception e) 
        { 
            System.err.println("Couldn't open file"); 
        }
        finally{
            try{
                
                bw1.close();          
                fw1.close();
                bw2.close();
                fw2.close();
               
            }
            catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
    
    }
    
    
    public static void main(String[] args) {
        
        //  ****** Test code for Char methods and the CharException *******
        
        Char ch = new Char('A');
        Char c = new Char('B');
        
        System.out.println(ch.add(c));
        System.out.println(ch.toChar() + " In Hex: " + ch.toHexString());
        System.out.println(ch.toChar() + " In Decimal: " + ch.toInt());
        
        try{
            System.out.println("Try to set 140 as character");
            ch.equals(140);
            System.out.println(ch.toChar());
        } catch(CharException ce){
            System.out.println(ce.getMessage());
        }
        Char x = new Char(c);
        System.out.println(x.toString());
        
        
        //  ****** Test code for BigDecimal and BigDecimalException *******

        try{
            
            BigDecimal bd1 = new BigDecimal("55.5555");
            BigDecimal bd2 = new BigDecimal("11.15");
            BigDecimal bd3 = new BigDecimal("11.11");
            System.out.println("This is BigDecimal number 1: " + bd1.toString());
            System.out.println("This is BigDecimal number 2: " + bd2.toString());
            System.out.println("This is what you get when you call the add method (bd1 + bd2): " + bd1.add(bd2));
            System.out.println("This is BigDecimal number 1: " + bd1.toString());
            System.out.println("This is BigDecimal number 2: " + bd2.toString());
            System.out.println("This is BigDecimal number 3: " + bd3.toString());
            System.out.println("This is what you get when you call the subtract method (bd1 - bd3): " + bd1.sub(bd3));
            
           
            
            
            /*
            The method below will read Numbers.txt and send the parsed data to wholeNumbers.txt
            and fraction.txt  
            
            Please pass as parameters copyAndParseFile((String) file path of file to read, (String) file path to write
            whole numbers to, (String) file path to write fractions to);
            
            Ensure you pass the proper file paths in order to make it work I have my file paths as an example. 
            */
            
            bd1.copyAndParseFile("C:\\Users\\antho\\Desktop\\Numbers.txt", "C:\\Users\\antho\\Desktop\\wholeNumbers.txt", 
                    "C:\\Users\\antho\\Desktop\\fraction.txt");
            
        } catch(BigDecimalException bde){
            System.out.println(bde.getMessage());
        }
              
      }
    
   }
