package com.sriyan.practice.exceptions;

public class MyCustomException extends Exception {

    public MyCustomException(String message) {
        super(message);
    }
}

class  Student {

   void getAge(int age) throws MyCustomException {

       if(age>200) {
          throw new MyCustomException("Invalid age") ;
       }

    }
}