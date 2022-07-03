class IntroSort {
    private int countStudents;
    public CompareStudents compareStudents = new CompareStudents();
    public Student[] students;
    IntroSort(Student[] student)
    {
        students = student;
        this.countStudents = students.length;
    }
    private void swap(int i, int j)
    {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }

    private void maxHeap(int i, int heapN, int begin) {
        Student temp = students[begin + i - 1];
        int child;

        while (i <= heapN / 2) {
            child = 2 * i;

            if (child < heapN
                    && compareStudents.compare(students[begin + child - 1], students[begin + child]) == -1)
                child++;

            if (compareStudents.compare(temp,students[begin + child - 1]) == 1 || compareStudents.compare(temp,students[begin + child - 1]) == 2)
                break;

            students[begin + i - 1] = students[begin + child - 1];
            i = child;
        }
        students[begin + i - 1] = temp;
    }
    private void heapify(int begin, int heapN)
    {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }
    private void heapSort(int begin, int end)
    {
        int heapN = end - begin;
        this.heapify(begin, heapN);
        for (int i = heapN; i >= 1; i--) {
            swap(begin, begin + i);
            maxHeap(1, i, begin);
        }
    }

    private void insertionSort(int left, int right)
    {

        for (int i = left; i <= right; i++) {
            Student key = students[i];
            int j = i;
            while (j > left && compareStudents.compare(students[j - 1], key) == 1) {
                students[j] = students[j - 1];
                j--;
            }
            students[j] = key;
        }
    }
    private int findPivot(int a1, int b1, int c1)
    {
        int max = Math.max(Math.max(students[a1].getPrice(), students[b1].getPrice()), students[c1].getPrice());
        int min = Math.min(Math.min(students[a1].getPrice(), students[b1].getPrice()), students[c1].getPrice());
        int median = max ^ min ^ students[a1].getPrice() ^ students[b1].getPrice() ^ students[c1].getPrice();
        if (median == students[a1].getPrice())
            return a1;
        if (median == students[b1].getPrice())
            return b1;
        return c1;
    }
    private int partition(int low, int high)
    {
        Student pivot = students[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if(compareStudents.compare(students[i], pivot) == -1 || compareStudents.compare(students[i], pivot) == 2){
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }
    private void sortDataUtil(int begin, int end, int depthLimit)
    {
        if (end - begin > 16) {
            if (depthLimit == 0) {
                this.heapSort(begin, end);
                return;
            }

            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,
                    begin + ((end - begin) / 2) + 1,
                    end);
            swap(pivot, end);
            int p = partition(begin, end);
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);
        }

        else {
            insertionSort(begin, end);
        }
    }
    public void sortData()
    {
        int depthLimit
                = (int)(2 * Math.floor(Math.log(countStudents) /
                Math.log(2)));

        this.sortDataUtil(0, countStudents - 1, depthLimit);
    }
}
