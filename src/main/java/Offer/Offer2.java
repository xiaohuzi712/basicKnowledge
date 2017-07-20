package Offer;

/**
 * Created by huchao on 2017/7/20.
 *  offer2
 * 题目描述:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 实现步骤:
 * 因为二维数组每一列和每一行递增，可以通过从二维数组左下角或左上角进行遍历。
 *  1.循环字符串，发现字符串为空格，就使用append方法并替换
 */
public class Offer2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);
            if (ch==' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
       String res =  new Offer2().replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(res);
    }
}
