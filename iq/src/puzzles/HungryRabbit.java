package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

/**
 * A very hungry rabbit is placed in the center of of a garden, represented by a rectangular N x M 2D matrix.
 * The values of the matrix will represent numbers of carrots available to the rabbit in each square of the garden.
 * If the garden does not have an exact center, the rabbit should start in the square closest to the center with the
 * highest carrot count. On a given turn, the rabbit will eat the carrots available on the square that it is on, and
 * then move up, down, left, or right, choosing the the square that has the most carrots. If there are no carrots left
 * on any of the adjacent squares, the rabbit will go to sleep. You may assume that the rabbit will never have to choose
 * between two squares with the same number of carrots.
 *
 * Write a function which takes a garden matrix and returns the number of carrots the rabbit eats. You may assume the
 * matrix is rectangular with at least 1 row and 1 column, and that it is populated with non-negative integers.
 * For example:
 * [[5, 7, 8, 6, 3],
 * [0, 0, 7, 0, 4],
 * [4, 6, 3, 4, 9],
 * [3, 1, 0, 5, 8]]
 * Should return: 27
 *
 * Take a reductionist approach: divide problem into smaller ones.
 *
 * 1. Find where rabbit should start.
 * 2. Start eating.
 */
public class HungryRabbit {
   private int[][] garden;
   private int carrotsConsumed;

   public HungryRabbit() {
      garden = new int[4][5];

      garden[0][0] = 5;
      garden[0][1] = 7;
      garden[0][2] = 8;
      garden[0][3] = 6;
      garden[0][4] = 3;

      garden[1][0] = 0;
      garden[1][1] = 0;
      garden[1][2] = 7;
      garden[1][3] = 0;
      garden[1][4] = 4;

      garden[2][0] = 4;
      garden[2][1] = 6;
      garden[2][2] = 3;
      garden[2][3] = 4;
      garden[2][4] = 9;

      garden[3][0] = 3;
      garden[3][1] = 1;
      garden[3][2] = 0;
      garden[3][3] = 5;
      garden[3][4] = 8;
   }

   public static void main(String[] args) {
      HungryRabbit hr = new HungryRabbit();
      int[] start = hr.findStart();

      for(int i = 0; i < hr.garden.length; i++) {
         for(int j = 0; j < hr.garden[0].length; j++) {
            System.out.print(" " + hr.garden[i][j]);
         }
         System.out.println();
      }

      System.out.println("Start: " + Arrays.toString(start));

      hr.eat(start);

      // Cells with -1s represent rabbit's path.
      for(int i = 0; i < hr.garden.length; i++) {
         for(int j = 0; j < hr.garden[0].length; j++) {
            System.out.print(" " + hr.garden[i][j]);
         }
         System.out.println();
      }

   }

   private void eat(int[] start) {
      carrotsConsumed += garden[start[0]][start[1]];
      garden[start[0]][start[1]] = -1; // Already visited parcel. No carrots!
      Parcel parcel = findNextParcel(start);
      if (parcel != null) {
         eat(new int[]{parcel.row, parcel.col});
      }
   }

   Parcel findNextParcel(int[] start) {
      Parcel leftParcel = getParcel(new int[]{start[0], start[1] - 1});
      Parcel rightParcel = getParcel(new int[]{start[0], start[1] + 1});
      Parcel topParcel = getParcel(new int[]{start[0] - 1, start[1]});
      Parcel bottomParcel = getParcel(new int[]{start[0] + 1, start[1]});

      int maxValue = 0;
      int nextParcel = -1; //-1 - no parcels left, 0 - leftParcel, 1 - rightParcel, 2 - topParcel, 3 - bottomParcel.

      if(leftParcel != null) {
         maxValue = leftParcel.value;
         nextParcel = 0;
      }

      if(rightParcel != null && rightParcel.value > maxValue) {
         maxValue = rightParcel.value;
         nextParcel  = 1;
      }

      if(topParcel != null && topParcel.value > maxValue) {
         maxValue = topParcel.value;
         nextParcel  = 2;
      }

      if(bottomParcel != null && bottomParcel.value > maxValue) {
         maxValue = bottomParcel.value;
         nextParcel  = 3;
      }

      if(nextParcel >= 0) {
         Parcel p = null;

         switch (nextParcel) {
            case 0:
               p = leftParcel;
               break;
            case 1:
               p = rightParcel;
               break;
            case 2:
               p = topParcel;
               break;
            case 3:
               p = bottomParcel;
               break;
         }
         if(p.value >= 0) {
            return p;
         }
      }
      return null;
   }


   private Parcel getParcel(int[] coordinates) {
      if ((coordinates[0] >= 0 && coordinates[0] <= garden.length - 1) &&
            (coordinates[1] >= 0 && coordinates[1] <= garden[0].length)) {
         int value = garden[coordinates[0]][coordinates[1]];
         if(value == -1) return null;
         return new Parcel(coordinates[0], coordinates[1], value);
      }
      else {
         return null;
      }

   }
   /**
    * Find where rabbit will start.
    *
    * @return
    */
   private int[] findStart() {
      int row = -1, col = -1;
      int row1 = -1, col1 = -1, row2 = -1, col2 = -1;

      if(garden.length % 2 == 0) {
         row1 = garden.length / 2 - 1;
         row2 = garden.length / 2;
      }
      else {
         row = garden.length/2;

      }

      if(garden[0].length % 2 == 0) {
         col1 = garden[0].length / 2 - 1;
         col2 = garden[0].length / 2;
      }
      else {
         col = garden[0].length/2;
      }

      if (row >= 0 && col >= 0) {
         return new int[]{row, col};
      }
      else {
         // Find parcel with largest number of carrots. Using loop is ok since max size of pool is 2x2.
         if(col >= 0) col1 = col2 = col;
         if(row >= 0) row1 = row2 =  row;

         ArrayList<Parcel> parcels = new ArrayList<Parcel>();
         parcels.add(new Parcel(row1, col1, garden[row1][col1]));
         if(col1 != col2) {
            parcels.add(new Parcel(row1, col2, garden[row1][col2]));
         }
         parcels.add(new Parcel(row2, col1, garden[row2][col1]));
         if(row1 != row2) {
            parcels.add(new Parcel(row2, col1, garden[row2][col2]));
         }

         int maxValueIndex = 0;
         int maxValue = parcels.get(0).value;

         for(int i = 1; i < parcels.size(); i++) {
            if(parcels.get(i).value > maxValue) {
               maxValueIndex = i;
               maxValue = parcels.get(i).value;
            }
         }

         return new int[]{parcels.get(maxValueIndex).row, parcels.get(maxValueIndex).col};
      }

   }

   /**
    * Helper object. Represents cell in the matrix.
    */

   class Parcel {
      private int row;
      private int col;
      private int value; // Number of carrots.

      public Parcel(int row, int col, int value) {
         this.row = row;
         this.col = col;
         this.value = value;
      }
   }
}
