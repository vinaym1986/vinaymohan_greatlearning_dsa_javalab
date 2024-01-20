package com.greatlearning.denominations.sort;

import com.greatlearning.denominations.array.ArraySlicerAndMerger;

public class MergeSort {

    private Integer[] inputArray;

    public MergeSort(Integer[] inputArray) {
        this.inputArray = inputArray;
    }

    public void mergeSort() {

        mergeSortInternal(0, inputArray.length - 1);

    }

    private void mergeSortInternal (int startIndex, int endIndex) {


        if (startIndex < endIndex) {

            int midPointIndex = (startIndex + endIndex) / 2;

            mergeSortInternal(startIndex, midPointIndex);

            mergeSortInternal((midPointIndex + 1), endIndex);

            ArraySlicerAndMerger slicerAndMerger =
                    new ArraySlicerAndMerger(inputArray);
            slicerAndMerger.sliceAndMerge(startIndex, midPointIndex, endIndex);

        }

    }
}
