class HairbrushSort {
    public void Sort(Worker[] workers, CompareWorker compareWorker) {
        int gap = workers.length;
        boolean isSorted = false;
        while (!isSorted || gap != 1) {
            if (gap > 1) {
                gap = gap * 10 / 13;
            } else {
                gap = 1;
            }
            isSorted = true;
            for (int i = gap; i < workers.length; i++)
                if (compareWorker.compare(workers[i - gap], workers[i]) < 0) {
                    var tmp = workers[i];
                    workers[i] = workers[i - gap];
                    workers[i - gap] = tmp;
                    isSorted = false;
                }
        }
    }
}
