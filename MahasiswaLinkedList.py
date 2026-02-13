class Node:
    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None

class MahasiswaLinkedList:
    def __init__(self):
        self.head = None
        self.count = 0

    def insert_at_pos(self, pos):
        if pos < 1 or pos > self.count + 1:
            print("Posisi tidak valid!")
            return
        
        nim = input("Masukkan NIM : ")
        nama = input("Masukkan Nama: ")
        new_node = Node(nim, nama)

        if pos == 1:
            new_node.next = self.head
            self.head = new_node
        else:
            temp = self.head
            for _ in range(1, pos - 1):
                temp = temp.next
            new_node.next = temp.next
            temp.next = new_node
        
        self.count += 1
        print("Data berhasil ditambahkan.")

    def delete_at_pos(self, pos):
        if not self.head or pos < 1 or pos > self.count:
            print("Posisi tidak valid!")
            return

        if pos == 1:
            self.head = self.head.next
        else:
            temp = self.head
            for _ in range(1, pos - 1):
                temp = temp.next
            temp.next = temp.next.next
        
        self.count -= 1
        print("Data berhasil dihapus.")

    def delete_first_occurrence(self):
        target = input("Masukkan NIM yang ingin dihapus: ")
        if not self.head: return

        if self.head.nim == target:
            self.head = self.head.next
            self.count -= 1
            return

        temp = self.head
        while temp.next and temp.next.nim != target:
            temp = temp.next
        
        if temp.next:
            temp.next = temp.next.next
            self.count -= 1
            print(f"NIM {target} berhasil dihapus.")
        else:
            print("NIM tidak ditemukan.")

    def show_data(self):
        if not self.head:
            print("List Kosong.")
            return
        temp = self.head
        i = 1
        while temp:
            print(f"{i}. NIM: {temp.nim}, Nama: {temp.nama}")
            temp = temp.next
            i += 1

# Main Program
ll = MahasiswaLinkedList()
while True:
    print(f"\n--- MENU LINKED LIST (PYTHON) ---")
    print(f"Jumlah Data: {ll.count}")
    print("1. Insert at Beginning")
    print("2. Insert at Given Position")
    print("3. Insert at End")
    print("4. Delete from Beginning")
    print("5. Delete Given Position")
    print("6. Delete from End")
    print("7. Delete First Occurrence (by NIM)")
    print("8. Show Data")
    print("9. Exit")
    
    pilihan = input("Pilih menu: ")
    if pilihan == '1': ll.insert_at_pos(1)
    elif pilihan == '2':
        p = int(input(f"Posisi (1-{ll.count+1}): "))
        ll.insert_at_pos(p)
    elif pilihan == '3': ll.insert_at_pos(ll.count + 1)
    elif pilihan == '4': ll.delete_at_pos(1)
    elif pilihan == '5':
        p = int(input(f"Posisi (1-{ll.count}): "))
        ll.delete_at_pos(p)
    elif pilihan == '6': ll.delete_at_pos(ll.count)
    elif pilihan == '7': ll.delete_first_occurrence()
    elif pilihan == '8': ll.show_data()
    elif pilihan == '9': break
    else: print("Pilihan salah!")