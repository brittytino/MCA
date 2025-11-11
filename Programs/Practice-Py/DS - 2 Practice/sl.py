class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def insert_begin(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        print(f"✅ Inserted '{data}' at the beginning.")

    def insert_end(self,data):
        new_node = Node(data)
        if self.head is None:
            return new_node
        temp = head
        while temp.next:
            temp

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
        data=input("Enter the Element: ")
        s.insert_begin(data)
    else:
        break
