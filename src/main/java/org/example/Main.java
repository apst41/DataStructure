package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  private static void findMissingVoter(List<Integer> list1 , List<Integer> list2){
   if (list1.size()>list2.size()){
     list1.removeAll(list2);
     System.out.println(list1.get(0));
     return;
   }
   list2.removeAll(list1);
   System.out.println(list2.get(0));
  }



  public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scann = new Scanner(System.in);
    int noOfCases = scann.nextInt();

    for (int i = 0; i <noOfCases;i++){
      List<Integer> list1 = new ArrayList<>();
      List<Integer> list2 = new ArrayList<>();
      int sizeOfVotingList = scann.nextInt();
      for (int j = 0; j < sizeOfVotingList;j++){
        list1.add(scann.nextInt());
      }
      for (int k = 0; k < sizeOfVotingList-1;k++){
        list2.add(scann.nextInt());
      }

      findMissingVoter(list1,list2);
    }

  }

}
