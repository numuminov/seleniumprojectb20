package com.cybertek.tests.day11_utils_review_actions.SelfPractice;

public class SingletonePractice {

    private SingletonePractice(){}
    private static int vilS;

    public static int getVilS(){
        if(vilS==0){
            System.out.println("vils is null");

            vilS=12;
        }else {
            System.out.println("vils already"+vilS);
        }




        return vilS;
    }



    }




