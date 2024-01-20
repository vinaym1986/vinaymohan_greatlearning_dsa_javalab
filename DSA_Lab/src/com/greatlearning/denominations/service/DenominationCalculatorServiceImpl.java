package com.greatlearning.denominations.service;

import com.greatlearning.denominations.sort.MergeSort;

import java.util.Arrays;

public class DenominationCalculatorServiceImpl implements IDenominationsCalculatorService {


    private Integer[] denominations;
    private int paymentAmount;


    public DenominationCalculatorServiceImpl (Integer[] denominations, int paymentAmount) {

        this.denominations = denominations;
        this.paymentAmount = paymentAmount;

    }

    @Override
    public void calculate() {
        performSort();

        int denominationIndex = 0;

        int workingPaymentAmount = paymentAmount;


        while (denominationIndex < denominations.length) {

            int denomination = denominations[denominationIndex];
            int noOfDenominations = workingPaymentAmount / denomination;

            //balance amount
            int balanceAmount = workingPaymentAmount % denomination;

            //if denomination can be used or not
            if(noOfDenominations != 0) {


                //print the denomination value and its count
                System.out.printf("Denomination value : %d , Count : %d \r\n",
                        denomination, noOfDenominations);


            }

            //set pending balance for next iteration
            workingPaymentAmount = balanceAmount;

            //when no more balance remaining, break from loop
            if(workingPaymentAmount == 0) {
                break;
            }

            denominationIndex++;
        }

        if(workingPaymentAmount != 0) {

            System.out.println("Unable to provide the exact denominations");
            System.out.println("Remaining amount : " + workingPaymentAmount);
        }

    }

    private void performSort() {

        MergeSort sorter = new MergeSort(denominations);
        sorter.mergeSort();
        System.out.println("Sorted array " + Arrays.toString(denominations));
    }

}