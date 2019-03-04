package etc.Study4;

/**
 * @author choijaeyong on 03/03/2019.
 * @project Algorithm
 * @description
 */
public class HeapMain {
  public static void main(String[] args) {
    int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };

  }
}

class HeapSort {
  public void heapSort(int[] arr) {
    Heap heap = new Heap();
    for(int i=0; i < arr.length ; i++) {
      heap.insertHeap(arr[i]);
    }
    for(int i = arr.length -1 ; i >=0 ; i--) {
      arr[i] = heap.deleteHeap();
    }
    System.out.println("힙정렬: ");
    // 정렬메소드하나 추가.
}

class Heap {
  private int heapsSize;
  private int[] itemHeap;
  public Heap() {
    heapsSize = 0;
    itemHeap = new int[50];
  }

  public void insertHeap(int item) {
    int i = ++heapsSize; // 첫 i 는 1이다. 인덱스 1 부터 값을 넣는다.
    while((i!=1) && (item > itemHeap[i / 2])) {
      itemHeap[i] = itemHeap[i/2];
      i = i /2;
    }
    itemHeap[i] = item;
  }
  public int getHeapsSize() {
    return heapsSize;
  }

  public int deleteHeap() {
    int parent,child;
    int item, tmp;
    item = itemHeap[1];
    tmp = itemHeap[heapsSize--];
    parent = 1;
    child = 2;

    while(child <= heapsSize) {
      if ((child < heapsSize) && (itemHeap[child] < itemHeap[child + 1])) {
        child++;
      }
      if (tmp >= itemHeap[child]) {
        break;
      }
      itemHeap[parent] = itemHeap[child];
      parent = child;
      child = child * 2;
    }

    itemHeap[parent] = tmp;
    return item;
    }


  }

}