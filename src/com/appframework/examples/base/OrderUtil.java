package com.appframework.examples.base;

public class OrderUtil {

	public static void main(String[] args) {
		int[] data = { 2, 5, 9, 6, 1, 7, 3, 4 };
		//bubbleSort(data);
		//selectSort(data);
		//insertSort(data);
		binaryInsertSort(data);
		for (int i : data) {
			System.out.println("i=" + i);
		}

	}

	/**
	 * 冒泡排序
	 * 在待排序的数列基本有序的情况下排序速度较快
	 * 基本思路：依次比较相邻连个元素，第一轮比较完毕，最大值（或最小值）排在末尾，依次共进行n(n-1)/2次比较
	 * 
	 * @param data
	 */
	private static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			// n个元素，总共n-1轮排序,每轮都有一个相比最大的数排到最后
			for (int j=0;j<data.length-i-1;j++) {
				if (data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 基本思路：从所有元素中选择一个最小元素a[i]放在a[0](即让最小元素a[i]与a[0]交换),作为第一轮；
	 * 第二轮从a[1]开始到最后一个元素中选择一个最小元素，放在a[1];...依次类推
	 * 
	 * n个元素要进行n-1轮比较，比较次数和冒泡法一样，但每一轮只进行一次交换，比冒泡法的交换次数少，相对
	 * 于冒泡法效率高
	 * @param data
	 */
	private static void selectSort(int[] data){
		int temp;
		for(int i=0;i<data.length-1;i++){
			//n个元素，共n-1轮
			int lowIndex = i;
			
			for(int j=i+1;j<data.length;j++){
				if(data[j]<data[lowIndex]){
					lowIndex = j;
				}
			}
			
			if(lowIndex != i){
				temp = data[i];
				data[i] = data[lowIndex];
				data[lowIndex] = temp;
			}
		}
	}
	
	/**
	 * 插入法排序
	 * 
	 * 基本思路：对每一个元素，都要将这个元素与所有它之前的元素遍历比较一遍，
	 * 让符合排序顺序的元素挨个移动到当前范围内它最应该出现的位置
	 * @param data
	 */
	private static void insertSort(int[] data){
		int temp;
		for(int i=1;i<data.length;i++){
			//第二个元素开始和前面的元素进行比较
			temp = data[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(temp<data[j]){
					//只要比比较元素temp大，都后移一位
					data[j+1] = data[j];
				}else{
					break;
				}
			}
			//此时temp>temp[j]
			data[j+1] = temp;
		}
	}
	
	/**
	 * 折半插入排序
	 * @Description TODO
	 * @param data
	 * @throws
	 */
	private static void binaryInsertSort(int[] data){
		
		int temp;
		for(int i=1 ;i<data.length;i++){
			temp = data[i];//整天后移时，保证data[i]的值不丢失
			int low = 0;
			int high = i-1;
			while(low<=high){
				//找出中间索引
				int mid = (low+high)/2;
				if(temp>data[mid]){
					//如果temp值大于中间元素的值，则限制它的位置在索引大于mid的那一半中
					low = mid+1;
				}else{
					high = mid-1;
				}
			}
			
			//将low到i处所有元素向后整体移一位
			for(int j=i;j>low;j--){
				data[j] = data[j-1];
			}
			//最后将temp值插入合适的位置
			data[low] = temp;
		}
	}
	
	
}
