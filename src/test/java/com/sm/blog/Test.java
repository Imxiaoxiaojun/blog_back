package com.sm.blog;


/**
 * @ClassName Test
 * @Description TODO
 * @Author zhuyajun
 * @Date 2018/4/12 下午2:54
 * @Version 1.0
 **/
public class Test {
    public static void main(String args[]) {
        System.out.println(getDiffDay(1499500432000L,1500105232000L));
    }

    void formatsql(){
        String str = "ff8080814aed3ba8014af1a91cb50021\n" +
                "ff808081529c7c610152a59fffd30049\n" +
                "ff8080814aed3ba8014af1a93ddb0022\n" +
                "ff8080814aed3ba8014af1a8a337001f\n" +
                "ff8080814aed3ba8014af1a9634d0023\n" +
                "ff8080814aed3ba8014af1a88596001e\n" +
                "ff8080814aed3ba8014af14da7e00013\n" +
                "ff8080814aed3ba8014af1a8c2f60020\n" +
                "ff8080814aed3ba8014af1a861dd001d\n";
        String[] arr = str.split("\n");
        StringBuilder result = new StringBuilder();
        int id = 8;
        for (String line : arr){
            result.append("('").append(line).append("',").append(id).append("),");
        }

        System.out.println(result.substring(0,result.length()-1));
    }

    private static int getDiffDay(Long day1, Long day2){
        if (day1 != null && day2 != null) {
            long diff = day1 - day2;
            diff = Math.abs(diff) / 1000L;
            return Math.round((float)(diff / 86400L));
        } else {
            return 0;
        }
    }
}
