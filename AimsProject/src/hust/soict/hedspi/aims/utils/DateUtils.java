package hust.soict.hedspi.aims.utils;

public class DateUtils {
	static void swap(MyDate[] arr, int i, int j)
    {
        MyDate temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(MyDate[] arr, int low, int high)
    {
        MyDate pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++)
        {

            if (compareTwoDates(arr[j],pivot)<0)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSortNumberOfDates(MyDate[] arr, int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);
            quickSortNumberOfDates(arr, low, pi - 1);
            quickSortNumberOfDates(arr, pi + 1, high);
        }
    }
    public static int compareTwoDates(MyDate date1, MyDate date2){
        if(date1.getYear()>date2.getYear()){
            return 1;
        }else if(date1.getYear()==date2.getYear()){
            if(date1.getMonth()>date2.getMonth()){
                return 1;
            }else if(date1.getMonth()==date2.getMonth()){
                if(date1.getDay()>date2.getDay()){
                    return 1;
                }else if(date1.getDay()==date2.getDay()){
                    return 0;
                }else return -1;
            }else return -1;
        }else return -1;
    }
}
