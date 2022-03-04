package sort;

public class ShellSort {
    public int[] shellSort(int[] array){
        int len=array.length;
        int temp,gap=len/2;
        while (gap>0){
            for(int i=gap;i<len;i++){
                temp=array[i];
                int preIndex=i-gap;
                while (preIndex>=0&&array[preIndex]>temp){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=temp;
            }
            gap/=2;
        }
        return array;
    }
}
