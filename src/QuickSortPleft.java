public class QuickSortPleft {
    int[] array=new int[2];

    public void quickSort(int[] array){
        this.array=array;
        quickSort1(0,array.length);
    }

    public void quickSort1(int leftEnd, int rightEnd){
        if (leftEnd>=rightEnd)
            return;

        int middle=array[leftEnd];
        int counter1=leftEnd+1;
        int counter2=rightEnd;
        while (counter1<=counter2){
            if (middle<array[counter1]){
                while (true){
                    if (middle>array[counter2]){
                        changePos(counter1,counter2);
                        break;
                    }
                    if (counter1==counter2){ break;}
                    counter2--;
                }
            }
            counter1++;
        }

        //get Middle Index
        int middleIndex=0;
        int counter3=leftEnd;
        while (true){
            if (array[counter3]>middle){
                middleIndex=counter3-1;
                break;
            }
            counter3++;
        }
        changePos(leftEnd,middleIndex);

        quickSort1(leftEnd, middleIndex-1);
        quickSort1(middleIndex+1, rightEnd);
    }

    public void changePos(int index1,int index2){
        int num=array[index1];
        array[index1]=array[index2];
        array[index2]=num;
    }

}
