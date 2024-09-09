/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        /*// int[][] matrix = new int[rows][];
        // for (int i = 0; i < rows; i++) {
        //     matrix[i] = new int [columns];
        //     Arrays.fill(matrix[i], -1);
        // }

        // int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        // while (head != null) {
        
        //     for (int col = leftColumn; col <= rightColumn && head != null; col++) {
        //         matrix[topRow][col] = head.val;
        //         head = head.next;
        //     }
        //     topRow++;

        
        //     for (int row = topRow; row <= bottomRow && head != null; row++) {
        //         matrix[row][rightColumn] = head.val;
        //         head = head.next;
        //     }
        //     rightColumn--;

 
        //     for (int col = rightColumn; col >= leftColumn && head != null; col--) {
        //         matrix[bottomRow][col] = head.val;
        //         head = head.next;
        //     }
        //     bottomRow--;

       
        //     for (int row = bottomRow; row >= topRow && head != null; row--) {
        //         matrix[row][leftColumn] = head.val;
        //         head = head.next;
        //     }
        //     leftColumn++;
        // }

        // return matrix;*/


        int m=rows,n=columns;
        int top = 0, left = 0, right = n - 1, bottom = m - 1;
        // int ar[] = {1, 5, 2, 4, 3, 2, 5, 7, 9, 5, 3, 2, 6, 7, 8, 9, 0, 1, 2, 4};
        int dou[][] = new int[m][];
        int i, j;
        for(i=0;i<m;i++)
        {
            dou[i] = new int [n];
            Arrays.fill(dou[i], -1);
        }

        ListNode temp = head;

        while (temp!=null) {
            // Fill top row (left to right)
            for (j = left; j <= right && temp!=null; j++) {
                dou[top][j] = temp.val;
                temp=temp.next;
            }
            top++; // Move the top boundary down

            // Fill right column (top to bottom)
            for (i = top; i <= bottom && temp!=null; i++) {
                dou[i][right] = temp.val;
                temp=temp.next;
            }
            right--; // Move the right boundary left

            if (top <= bottom) {
                // Fill bottom row (right to left)
                for (j = right; j >= left && temp!=null; j--) {
                    dou[bottom][j] = temp.val;
                temp=temp.next;
                }
                bottom--; // Move the bottom boundary up
            }

            if (left <= right) {
                // Fill left column (bottom to top)
                for (i = bottom; i >= top && temp!=null; i--) {
                    dou[i][left] = temp.val;
                     temp=temp.next;
                }
                left++; // Move the left boundary right
            }
        }

        return dou;

    }
}