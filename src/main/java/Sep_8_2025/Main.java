package Sep_8_2025;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int iterationCount = 0;

        ArrayList<Disk> diskStack_A = new ArrayList<Disk>();
        ArrayList<Disk> diskStack_B = new ArrayList<Disk>();
        ArrayList<Disk> diskStack_C = new ArrayList<Disk>();

        load1stStack(20,diskStack_A);

        printdiskStack(diskStack_A);
        printdiskStack(diskStack_B);
        printdiskStack(diskStack_C);

        System.out.println();
        System.out.println();
        System.out.println();

        moveDisks(20, diskStack_A, diskStack_B, diskStack_C, iterationCount);

        printdiskStack(diskStack_A);
        printdiskStack(diskStack_B);
        printdiskStack(diskStack_C);


    }


    public static void moveDisks(int numOfDisks, ArrayList<Disk> diskStack_A, ArrayList<Disk> diskStack_B, ArrayList<Disk> diskStack_C, int iterationCount) {

        if (diskStack_C.size() == numOfDisks && iterationCount >= numOfDisks) {
            return;
        }

        int diskMoveCounter = 0;


            if (!diskStack_A.isEmpty()) {
                diskStack_C.add(diskStack_A.removeLast());
                diskMoveCounter++;
            }

            if (!diskStack_A.isEmpty()) {
                diskStack_B.add(diskStack_A.removeLast());
                diskMoveCounter++;
            }


            if (!diskStack_C.isEmpty()) {
                diskStack_B.add(diskStack_C.removeLast());
                diskMoveCounter++;
            }

            if (!diskStack_A.isEmpty()) {
                diskStack_C.add(diskStack_A.removeLast());
                diskMoveCounter++;
            }

            if (!diskStack_B.isEmpty()) {
                diskStack_A.add(diskStack_B.removeLast());
                diskMoveCounter++;
            }


            if (!diskStack_B.isEmpty()) {
                diskStack_C.add(diskStack_B.removeLast());
                diskMoveCounter++;
            }


            if (!diskStack_A.isEmpty()) {
                diskStack_C.add(diskStack_A.removeLast());
                diskMoveCounter++;
            }

        if (iterationCount < numOfDisks) {
            for (int i = 0; i < numOfDisks; i++) {
                if (!diskStack_C.isEmpty()) {
                    diskStack_B.add(diskStack_C.removeLast());
                    diskMoveCounter++;

                }
            }
        }

        iterationCount++;
        moveDisks(numOfDisks, diskStack_A, diskStack_B, diskStack_C, iterationCount);

    }

    public static ArrayList<Disk> load1stStack(int numOfDisks, ArrayList<Disk> diskStack) {

        for (int i = 0; i < numOfDisks; i++) {
            diskStack.add(new Disk());
        }

        return  diskStack;
    }

    public static void printdiskStack(ArrayList<Disk> diskStack) {
        for (int i = 0; i < diskStack.size(); i++) {
            System.out.print("Disk: " + diskStack.get(i).getDiskNum() + "   ");
        }

        if (diskStack.size() == 0) {
            System.out.println("Empty");
        } else {
            System.out.println();
        }
    }
}

class Disk {

    static int diskCounter = 1;
    int diskNum = 0;

    Disk() {
        diskNum = diskCounter++;
    }

    int  getDiskNum() {
        return diskNum;
    }

}
