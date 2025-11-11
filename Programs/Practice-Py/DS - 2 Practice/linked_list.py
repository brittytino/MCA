class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        print(f"✅ Inserted '{data}' at the beginning.")

    def insert_at_end(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            print(f"✅ Inserted '{data}' as the first node (list was empty).")
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node
        print(f"✅ Inserted '{data}' at the end.")

    def display(self):
        if self.head is None:
            print("🚫 The linked list is empty.")
            return
        temp = self.head
        print("📋 Current Linked List: ", end="")
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

    def count_nodes(self):
        count = 0
        temp = self.head
        while temp:
            count = count +1
            temp = temp.next
        print(f"🔢 Total nodes in the list: {count}")
        return count

    def delete_at_beginning(self):
        if self.head is None:
            print("🚫 Cannot delete — list is empty.")
            return
        removed = self.head.data
        self.head = self.head.next
        print(f"🗑️ Deleted '{removed}' from the beginning.")

    def delete_at_end(self):
        if self.head is None:
            print("🚫 Cannot delete — list is empty.")
            return
        if self.head.next is None:
            print(f"🗑️ Deleted '{self.head.data}' (it was the only node).")
            self.head = None
            return
        temp = self.head
        while temp.next.next:
            temp = temp.next
        print(f"🗑️ Deleted '{temp.next.data}' from the end.")
        temp.next = None

    def search(self, key):
        temp = self.head
        position = 1
        while temp:
            if temp.data == key:
                print(f"🔍 Element '{key}' found at position {position}.")
                return True
            temp = temp.next
            position += 1
        print(f"❌ Element '{key}' not found in the list.")
        return False

    def insert_sorted(self, data):
        new_node = Node(data)
        if self.head is None or data < self.head.data:
            new_node.next = self.head
            self.head = new_node
            print(f"✅ Inserted '{data}' in sorted order (new head).")
            return
        temp = self.head
        while temp.next and temp.next.data < data:
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node
        print(f"✅ Inserted '{data}' in sorted order.")


# --------------------------
# Main Program (Dynamic Menu)
# --------------------------
s = SinglyLinkedList()

while True:
    print("\n📘 Menu:")
    print("1. Insert at beginning")
    print("2. Insert at end")
    print("3. Display list")
    print("4. Count nodes")
    print("5. Delete at beginning")
    print("6. Delete at end")
    print("7. Search for an element")
    print("8. Insert in sorted order")
    print("9. Exit")

    choice = input("Enter your choice (1-9): ")

    if choice == '1':
        data = input("Enter data to insert at beginning: ")
        s.insert_at_beginning(data)
    elif choice == '2':
        data = input("Enter data to insert at end: ")
        s.insert_at_end(data)
    elif choice == '3':
        s.display()
    elif choice == '4':
        s.count_nodes()
    elif choice == '5':
        s.delete_at_beginning()
    elif choice == '6':
        s.delete_at_end()
    elif choice == '7':
        key = input("Enter the data to search: ")
        s.search(key)
    elif choice == '8':
        data = input("Enter data to insert in sorted order: ")
        s.insert_sorted(data)
    elif choice == '9':
        print("👋 Exiting... Goodbye!")
        break
    else:
        print("⚠️ Invalid choice. Please try again.")
