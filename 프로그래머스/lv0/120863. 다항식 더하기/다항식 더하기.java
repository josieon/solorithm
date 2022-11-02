import java.util.*;
class Solution {
    public String solution(String polynomial) {
        int xs = 0, normal = 0;
        String [] polynomials = polynomial.split(" ");
        for(String polynom : polynomials){
            if(polynom.equals("+")){
                continue;
            }
            if(!polynom.contains("x")){
                normal += Integer.parseInt(polynom);
            }else{
                if(polynom.length() == 1){
                    xs += 1;
                }else{
                    xs += Integer.parseInt(polynom.substring(0, polynom.length()-1));
                }
            }
        }
        if(xs == 0 && normal == 0){
            return "0";
        }else if(xs != 0 && normal == 0){
            if(xs == 1){
                return "x";
            }else{
                return String.valueOf(xs) + "x";
            }
        }else if(xs == 0 && normal != 0){
            return String.valueOf(normal);
        }else{
            if(xs == 1){
                return "x + " + String.valueOf(normal);
            }else{
                return String.valueOf(xs) + "x + " + String.valueOf(normal); 

            }
        }
    }
}
// class Solution {
//     public String solution(String polynomial) {
//         String[] arr = polynomial.replaceAll(" ", "").split("\\+");
//         if(arr.length == 1)
//             return arr[0];
//         int x = 0, a = 0;
//         for(String tmp : arr){
//             // String tmp = t.trim();
//             if(tmp.length() > 1)
//                 x += Integer.parseInt(tmp.substring(0, tmp.length() - 1));
//             else{
//                 if(tmp.contains("x"))
//                     x++;
//                 else
//                     a += Integer.parseInt(tmp);
//             }
//         }
//         StringBuilder sb = new StringBuilder();
//         if(x > 0){
//             if(x > 1)
//                 sb.append(x);
//             sb.append("x");
//         }
//         if(a > 0){
//             if(x > 0)
//                 sb.append(" + ");
//             sb.append(a);
//         }
//         return sb.toString();
//     }
// }