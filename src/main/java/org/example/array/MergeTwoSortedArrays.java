package org.example.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int removeElement(int[] nums, int val) {
        int count = 0 ;
        int finalLength= nums.length-1;

        for(int i=0;i<=finalLength;i++){
            while(finalLength>= 0 && nums[finalLength] ==val){
                finalLength--;
            }

            if( i < finalLength &&  nums[i] == val){
                nums[i] = nums[finalLength];
                finalLength--;

            }

        }


        return  finalLength;
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {


    }

    public static void main(String[] args) {
       int[] nums = new int[]{1};

        System.out.println(removeElement(nums,1));

    }
}
