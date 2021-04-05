package com.project.pavani.security.opt;

import java.util.Random;

public class Otp {
    public static String optGenerator(){
        Random otp  =new Random();
        StringBuilder builder=new StringBuilder();
        for(int count=0; count<8;count++) {
            builder.append(otp.nextInt(10));
        }
        return builder.toString();
    }


}
