package com.demo.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayStore {

    public void displayUsingFor(int[] arr) {
        for(int i=0; i<=arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public void displayUsingWhile(int[] arr) {
        int i = 0;
        while(i <= arr.length) {
            System.out.println(arr[i]);
            i++;
        }
    }

    public void sortingArray(int[] arr) {
        boolean swapped;
        for(int i=0; i< arr.length-1; i++) {
                swapped = false;
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) {
                break;
            }
        }
    }

    public void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int countNumber(int target, int arr[]) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    public void insertEle(int ele, int idx, int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int num : arr) {
            res.add(num);
        }

//        for(int i=0; i<arr.length; i++) {
//            res.add(arr[i]);
//        }

        res.add(idx, ele);

      //  System.out.println(res);


        int newArray[] = new int[res.size()];

        for(int i=0; i<res.size(); i++) {
            newArray[i] = res.get(i);
        }

        printArray(newArray);

        //printArray(Arrays.toString(newArray));
    }

    public void excludeDuplicates(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : arr) {
            set.add(num);
        }

        System.out.println(set);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 10, 11, 45, 32, 5, 4, 4, 4, 3};

        ArrayStore array = new ArrayStore();
//        array.sortingArray(arr);
//        array.printArray(arr);
       // System.out.println(array.countNumber(4, arr));

        //array.insertEle(23, 0, arr);

        array.excludeDuplicates(arr);
    }
}
