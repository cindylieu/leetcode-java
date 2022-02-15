package easy;

import java.util.*;

public class MinimumIndexSumofTwoLists {

    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

        String[] list3 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list4 = new String[]{"KFC","Burger King","Tapioca Express","Shogun"};

        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
        System.out.println(Arrays.toString(findRestaurant(list3, list4)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1Map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }

        int index = list1.length + list2.length;

        List<String> result = new ArrayList<>();

        for (int j = 0; j < list2.length; j++) {
            if (list1Map.containsKey(list2[j])) {
                if ((list1Map.get(list2[j]) + j) < index) {
                    index = list1Map.get(list2[j]) + j;
                    result.clear();
                    result.add(list2[j]);
                } else if ((list1Map.get(list2[j]) + j) == index) {
                    result.add(list2[j]);
                }
            }
        }

        String[] res = new String[result.size()];
        return result.toArray(res);
    }
}
