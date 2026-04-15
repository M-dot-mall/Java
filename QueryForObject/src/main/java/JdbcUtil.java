public class JdbcUtil {
    public static String underlineToCamel(String str){
        if(str == null|| !str.contains("_")){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for(char c:chars){
            boolean nextUpper = false;
            if(c == '_'){
                nextUpper = true;
            }else{
                sb.append(nextUpper?Character.toUpperCase(c):c);
                nextUpper = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String
    }
}
