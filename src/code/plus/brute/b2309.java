package code.plus.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 * 난쟁이가 9명인데 7명이 찐 난쟁이, 7명 난쟁이 키(height)의 합이 100
 * 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다.
 * 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 * 브루트 포스 -> 무식하게 구하는 방법, 모든 경우의 수 다 구하기
 * 1. 진짜 난쟁이 7명을 구하는 방식
 * 2. 가짜 2명을 구하는 방식
 * 2번이 성능이 더 좋다. 1번은 어떻게 구할건데 7중 for문으로? 2번은 for문 2번 돌리면 된다.
 */
public class b2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        ArrayList<Integer> array = new ArrayList<>();
//        int total = 0;
//        for (int i = 0; i < 9; i++){
//            int height = Integer.parseInt(br.readLine());
//            array.add(height); // 리스트에 모든 난쟁이들의 키를 집어넣기
//            total += height;
//        }
//
//
//        int fake1 = 0;
//        int fake2 = 0;
//        for (int i = 0; i < array.size() - 1; i++){ // i랑 j 중복 방지를 위해 i는 인덱스 7까지만
//            for (int j = i + 1; j < array.size(); j++){ // i랑 j 중복 방지
//                if (total - (array.get(i) + array.get(j)) == 100){
//                    fake1 = array.get(i);
//                    fake2 = array.get(j);
//                    array.remove(Integer.valueOf(fake1));
//                    array.remove(Integer.valueOf(fake2));
//                    break;
//                }
//            }
//            if (fake1 != 0){ // 찾았으면 더 이상 for문을 돌지 않고 바로 빠져나오기 위함. 성능 향상
//                break;
//            }
//        }
//
//        Collections.sort(array);
//        for (Integer height : array) {
//            System.out.println(height);
//        }
//
        // 배열을 이용하여 구해보자.
        int[] heights = new int[9]; // 아홉명만 주어지므로
        int total = 0;
        for (int i = 0; i < 9; i++){
            int height = Integer.parseInt(br.readLine()); // String -> Integer -> int (x) , String -> int (O)
            heights[i] = height;
            total += height;
        }

        int fake1= 0;
        int fake2 = 0;

        for (int i = 0; i < heights.length - 1; i++){
            for (int j = i + 1; j < heights.length; j++){
                if (total - (heights[i] + heights[j]) == 100){
                    fake1 = heights[i];
                    fake2 = heights[j];
                    break;
                }
            }
            if (fake1 != 0) break;
        }

        Arrays.sort(heights);
        for (int height : heights) {
            if (height != fake1 && height != fake2){
                System.out.println(height);
            }
        }
    }
}
