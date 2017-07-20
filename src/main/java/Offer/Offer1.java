package Offer;

/**
 * Created by huchao on 2017/7/20.
 * offer1
 * 题目描述:
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 实现步骤:
 * 因为二维数组每一列和每一行递增，可以通过从二维数组左下角或左上角进行遍历。
 *  1.若左上角元素大于目标元素，则列索引减1
 *  2.若左上角元素小于目标元素，则行索引加1
 */
public class Offer1 {
    public boolean Find(int target, int[][] array) {
        int max_index = array.length-1;
        int row_index =0;
        int column_index = array[0].length-1;
        while (row_index<=max_index&&(column_index>=0)){
            if(array[row_index][column_index]<target){
                ++row_index;
            }else if(array[row_index][column_index]>target){
                --column_index;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean res = new Offer1().Find(10,array);
        System.out.println(res);
    }
}
