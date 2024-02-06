package com.cbfacademy.apiassessment.familyActivities;

import java.math.BigDecimal;
import java.util.List;

public class ActivitySorter {

    public static void sort(List<FamilyActivity> activities, SortOrder order) {
        if (activities == null || activities.size() <= 1) {
            return;
        }
        quickSort(activities, 0, activities.size() - 1, order);
    }

    private static void quickSort(List<FamilyActivity> activities, int low, int high, SortOrder order) {
        if (low < high) {
            int partitionIndex = partition(activities, low, high, order);
            quickSort(activities, low, partitionIndex - 1, order);
            quickSort(activities, partitionIndex + 1, high, order);
        }
    }

    private static int partition(List<FamilyActivity> activities, int low, int high, SortOrder order) {
        FamilyActivity pivot = activities.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(activities.get(j).getBudget(), pivot.getBudget(), order) <= 0) {
                i++;
                swap(activities, i, j);
            }
        }
        swap(activities, i + 1, high);
        return i + 1;
    }

    private static int compare(BigDecimal a, BigDecimal b, SortOrder order) {
        if (order == SortOrder.ASCENDING) {
            return a.compareTo(b);
        } else {
            return b.compareTo(a);
        }
    }

    private static void swap(List<FamilyActivity> activities, int i, int j) {
        FamilyActivity temp = activities.get(i);
        activities.set(i, activities.get(j));
        activities.set(j, temp);
    }
}