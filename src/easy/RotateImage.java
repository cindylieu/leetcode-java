package easy;

import java.util.Arrays;

public class RotateImage {

    //You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    //You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    //DO NOT allocate another 2D matrix and do the rotation.

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = {{1,2,3,0},{4,5,6,0},{7,8,9,0},{1,1,1,0}};
        rotateImage.rotate(arr);
        rotateImage.rotate(arr2);
    }

    //Input: matrix = [[1,2,3],
    //                 [4,5,6],
    //                 [7,8,9]]
    //Output: [[7,4,1],
    //         [8,5,2],
    //         [9,6,3]]

    public void rotate(int[][] matrix) {

        System.out.println("Before");
        for (int i = 0; i < matrix.length; i++) { //for each arr
            for (int j = 0; j < matrix[0].length; j++) { //for each item
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) { //for each arr
            for (int j = 0; j < matrix[0].length; j++) { //for each item
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) { //for each arr
            for (int j = 0; j < matrix[0].length/2; j++) { //for each item
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1] = temp;
            }
        }

        System.out.println();
        System.out.println("After");
        for (int i = 0; i < matrix.length; i++) { //for each arr
            for (int j = 0; j < matrix[0].length; j++) { //for each item
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
