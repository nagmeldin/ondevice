package org.engyne;


import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class DeviceService {

   DeviceService deviceService;

   String generateText(){

       String alphabet = "abcdefghijklmnopqrstuvwxyz"; // All characters
       String numbers = "01234567890";
       String alphaNumbers = alphabet + numbers;
       int TOTAL = alphabet.length() + numbers.length();                  // 26 + 10
       int LENGTH = 5;

       // create random string builder:
       StringBuilder sb = new StringBuilder();

       Random random = new Random();

       for(int i = 0; i < LENGTH; i++) {

           int index = random.nextInt(TOTAL);          // Get a random integer < TOTAL

           char randomChar = alphaNumbers.charAt(index);

           sb.append(randomChar);                      // Accumulates  string
       }
       String result = sb.toString();

       return result;
   }

}
