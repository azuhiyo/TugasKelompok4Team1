import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ProgramSimulasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selamat datang di Program Simulasi" + "\n");
        int choice = 0;
        int[] arr = null;
        while (choice != 6) {
            System.out.println("Menu");
            System.out.println("1. Masukkan batas atas dan batas bawah");
            System.out.println("2. Simulasi Bubble Sort ascending");
            System.out.println("3. Simulasi Selection Sort ascending");
            System.out.println("4. Simulasi Bubble Sort descending");
            System.out.println("5. Simulasi Selection Sort descending");
            System.out.println("6. Keluar" + "\n");
            System.out.print("Masukkan pilihan Anda: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan batas atas: ");
                    int upperLimit = input.nextInt();
                    System.out.print("Masukkan batas bawah: ");
                    int lowerLimit = input.nextInt();
                    if (upperLimit <= lowerLimit) {
                        System.out.println("batas atas harus lebih besar dari batas bawah");
                        return;
                    }
                    arr = new int[5];
                    Random random = new Random();
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                    }
                    System.out.println("Array yang telah dibuat: " + Arrays.toString(arr));
                    break;
                case 2:
                    if (arr == null) {
                        System.out.println("Silakan buat array terlebih dahulu");
                    } else {
                        int[] bubbleSortAscendingArray = Arrays.copyOf(arr, arr.length);
                        bubbleSortAscending(bubbleSortAscendingArray);
                        System.out.println("Array yang telah diurutkan secara ascending: " + Arrays.toString(bubbleSortAscendingArray));
                    }
                    break;
                case 3:
                    if (arr == null) {
                        System.out.println("Silakan buat array terlebih dahulu");
                    } else {
                        int[] selectionSortAscendingArray = Arrays.copyOf(arr, arr.length);
                        selectionSortAscending(selectionSortAscendingArray);
                        System.out.println("Array yang telah diurutkan secara ascending: " + Arrays.toString(selectionSortAscendingArray));
                    }
                    break;
                case 4:
                    if (arr == null) {
                        System.out.println("Silakan buat array terlebih dahulu");
                    } else {
                        int[] bubbleSortDescendingArray = Arrays.copyOf(arr, arr.length);
                        bubbleSortDescending(bubbleSortDescendingArray);
                        System.out.println("Array yang telah diurutkan secara descending: " + Arrays.toString(bubbleSortDescendingArray));
                    }
                    break;
                case 5:
                    if (arr == null) {
                        System.out.println("Silakan buat array terlebih dahulu");
                    } else {
                        int[] selectionSortDescendingArray = Arrays.copyOf(arr, arr.length);
                        selectionSortDescending(selectionSortDescendingArray);
                        System.out.println("Array yang telah diurutkan secara descending: " + Arrays.toString(selectionSortDescendingArray));
                        
                    }
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini");
                    break;
                default:
                    System.out.println("Masukkan pilihan yang valid");
            }
        }
    }

    public static void bubbleSortAscending(int[] arr) {
        boolean swapped;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                // jika tidak ada perubahan, array sudah terurut dan proses sorting dihentikan
                break;
            }
            System.out.println("Tahap " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

    public static void selectionSortAscending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println("Tahap " + (i + 1) + ": " + Arrays.toString(arr));

            if (i > 0 && Arrays.equals(Arrays.copyOfRange(arr, 0, i), Arrays.copyOfRange(arr, 0, i + 1))) {
                System.out.println("Tahap " + (i + 1) + " memiliki nilai yang sama dengan tahap sebelumnya. Sorting dihentikan.");
                System.out.println("Array Tahap Sebelumnya: " + Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
                System.out.println("Array Tahap Saat Ini: " + Arrays.toString(Arrays.copyOfRange(arr, 0, i + 1)));
                break;
            }
        }
    }

    public static void bubbleSortDescending(int[] arr) {
        boolean isSwapped = true;
        int i = 0;
        while (i < arr.length - 1 && isSwapped) {
            isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped) { // tambahkan kondisi untuk hanya menampilkan tahap jika array berubah
                System.out.println("Tahap " + (i + 1) + ": " + Arrays.toString(arr));
            }
            i++;
        }
    }

    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            boolean swapOccurred = false; // tambahan variabel penanda
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                    swapOccurred = true; // tandai jika ada swap
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            System.out.println("Tahap " + (i + 1) + ": " + Arrays.toString(arr));
            if (!swapOccurred) {
                break; // hentikan jika tidak ada swap pada tahap ini
            }
        }
    }
}