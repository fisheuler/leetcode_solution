package solution.offer_Acwing;


class Solution_Array {

    public static void main(String[] args){
        int[] array = {2,2};
        System.out.println(getTransformNum(array));
    }
    public static int getTransformNum(int[] array){
        int num=0;

        int zeroNum=0;

        while(zeroNum!=array.length){

            for(int i=0;i<array.length;i++){
                if(array[i]%2==1){
                    array[i]--;
                    num++;
                }
            }
            zeroNum = 0;
            for(int i=0;i<array.length;i++){
                if(array[i]==0){
                    zeroNum++;
                }else{
                    array[i] /=2;
                }
            }
            if(zeroNum!=array.length){
                num++;
            }

        }
        return num;
    }
}