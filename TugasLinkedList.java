import java.util.Scanner;

class Node {
    String nim;
    String nama;
    Node next; // Pointer ke node selanjutnya

    public Node(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

public class TugasLinkedList {
    static Node head = null;
    static int count = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU LINKED LIST MAHASISWA ---");
            System.out.println("Jumlah Data: " + count);
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at Given Position");
            System.out.println("3. Insert at End");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete Given Position");
            System.out.println("6. Delete from End");
            System.out.println("7. Delete First Occurrence (by NIM)");
            System.out.println("8. Show Data");
            System.out.println("9. Exit");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (pilihan) {
                case 1: insertAtPos(1); break;
                case 2:
                    System.out.print("Masukkan posisi (1-" + (count + 1) + "): ");
                    int posIn = sc.nextInt(); sc.nextLine();
                    insertAtPos(posIn);
                    break;
                case 3: insertAtPos(count + 1); break;
                case 4: deleteAtPos(1); break;
                case 5:
                    System.out.print("Masukkan posisi (1-" + count + "): ");
                    int posDel = sc.nextInt(); sc.nextLine();
                    deleteAtPos(posDel);
                    break;
                case 6: deleteAtPos(count); break;
                case 7: deleteByNim(); break;
                case 8: showData(); break;
                case 9: System.exit(0);
                default: System.out.println("Pilihan salah!");
            }
        }
    }

    static void insertAtPos(int pos) {
        if (pos < 1 || pos > count + 1) {
            System.out.println("Posisi tidak valid!");
            return;
        }
        System.out.print("Masukkan NIM : "); String nim = sc.nextLine();
        System.out.print("Masukkan Nama: "); String nama = sc.nextLine();
        Node newNode = new Node(nim, nama);

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
        }
        count++;
        System.out.println("Data berhasil ditambahkan.");
    }

    static void deleteAtPos(int pos) {
        if (head == null || pos < 1 || pos > count) {
            System.out.println("Posisi tidak valid atau list kosong!");
            return;
        }
        if (pos == 1) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) temp = temp.next;
            temp.next = temp.next.next;
        }
        count--;
        System.out.println("Data berhasil dihapus.");
    }

    static void deleteByNim() {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String target = sc.nextLine();
        if (head == null) return;

        if (head.nim.equals(target)) {
            head = head.next;
            count--;
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.nim.equals(target)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            count--;
            System.out.println("NIM " + target + " berhasil dihapus.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    static void showData() {
        if (head == null) {
            System.out.println("List Kosong.");
            return;
        }
        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". NIM: " + temp.nim + ", Nama: " + temp.nama);
            temp = temp.next;
            i++;
        }
    }
}