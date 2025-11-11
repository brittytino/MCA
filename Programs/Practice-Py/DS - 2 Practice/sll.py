# all_structures.py
# Single-file interactive implementation:
# - SinglyLinkedList (many ops)
# - Stack (push/pop/peek/min/max/display)
# - Queue (enqueue/dequeue via linked nodes)
# - CircularQueue (array-based)
# - Deque (double-ended queue) implemented without collections

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# -----------------------
# Singly Linked List
# -----------------------
class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # Insert at beginning
    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        print(f"Inserted '{data}' at beginning.")

    # Insert at end
    def insert_at_end(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            print(f"Inserted '{data}' as the first node.")
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node
        print(f"Inserted '{data}' at end.")

    # Insert at position (1-based). If pos > length+1 -> append at end
    def insert_at_position(self, pos, data):
        if pos <= 1 or self.head is None:
            self.insert_at_beginning(data)
            return
        new_node = Node(data)
        temp = self.head
        i = 1
        while temp.next and i < pos - 1:
            temp = temp.next
            i += 1
        # insert after temp
        new_node.next = temp.next
        temp.next = new_node
        print(f"Inserted '{data}' at position {i+1}.")

    # Display list
    def display(self):
        if self.head is None:
            print("List is empty.")
            return
        temp = self.head
        out = []
        while temp:
            out.append(str(temp.data))
            temp = temp.next
        print(" -> ".join(out) + " -> None")

    # Count nodes / length
    def length(self):
        count = 0
        temp = self.head
        while temp:
            count += 1
            temp = temp.next
        print(f"Length: {count}")
        return count

    # Delete at beginning
    def delete_at_beginning(self):
        if self.head is None:
            print("Cannot delete; list is empty.")
            return
        removed = self.head.data
        self.head = self.head.next
        print(f"Deleted '{removed}' from beginning.")

    # Delete at end
    def delete_at_end(self):
        if self.head is None:
            print("Cannot delete; list is empty.")
            return
        if self.head.next is None:
            removed = self.head.data
            self.head = None
            print(f"Deleted '{removed}' (only node).")
            return
        temp = self.head
        while temp.next.next:
            temp = temp.next
        removed = temp.next.data
        temp.next = None
        print(f"Deleted '{removed}' from end.")

    # Delete at position (1-based)
    def delete_at_position(self, pos):
        if self.head is None:
            print("Cannot delete; list is empty.")
            return
        if pos <= 1:
            self.delete_at_beginning()
            return
        temp = self.head
        i = 1
        while temp.next and i < pos - 1:
            temp = temp.next
            i += 1
        if temp.next is None:
            print(f"Position {pos} is out of bounds; nothing deleted.")
            return
        removed = temp.next.data
        temp.next = temp.next.next
        print(f"Deleted '{removed}' from position {pos}.")

    # Search - return list of positions where data matches (1-based)
    def search(self, key):
        temp = self.head
        pos = 1
        found_positions = []
        while temp:
            if temp.data == key:
                found_positions.append(pos)
            temp = temp.next
            pos += 1
        if found_positions:
            print(f"Element '{key}' found at positions: {found_positions}")
        else:
            print(f"Element '{key}' not found.")
        return found_positions

    # Sort the linked list (simple approach: extract values, sort, rebuild)
    def sort(self):
        if self.head is None or self.head.next is None:
            print("List has 0 or 1 node; already sorted.")
            return
        vals = []
        temp = self.head
        while temp:
            vals.append(temp.data)
            temp = temp.next
        try:
            vals.sort()
        except Exception as e:
            # If data types are not comparable (e.g., mixed types), sort by string representation
            vals.sort(key=lambda x: str(x))
        # rebuild
        self.head = None
        for v in reversed(vals):
            self.insert_at_beginning(v)
        print("List sorted.")

    # Merge another list (append other to end of this list). Other remains unchanged as list nodes are reused.
    def merge(self, other):
        if not isinstance(other, SinglyLinkedList):
            print("Can only merge with another SinglyLinkedList.")
            return
        if other.head is None:
            print("Other list is empty; nothing to merge.")
            return
        if self.head is None:
            # simple: set head to other's head (note: this will share nodes)
            # To avoid sharing nodes, we copy values
            temp = other.head
            while temp:
                self.insert_at_end(temp.data)
                temp = temp.next
            print("Merged by copying nodes from other list (this was empty).")
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        # append copies of other's nodes
        other_temp = other.head
        while other_temp:
            temp.next = Node(other_temp.data)
            temp = temp.next
            other_temp = other_temp.next
        print("Merged other list into this list (copied nodes).")

# -----------------------
# Stack (using Python list)
# -----------------------
class Stack:
    def __init__(self):
        self.items = []

    def push(self, data):
        self.items.append(data)
        print(f"Pushed '{data}' onto stack.")

    def pop(self):
        if not self.items:
            print("Stack is empty. Nothing to pop.")
            return None
        val = self.items.pop()
        print(f"Popped '{val}' from stack.")
        return val

    def display(self):
        if not self.items:
            print("Stack is empty.")
            return
        print("Top -> " + " | ".join(reversed([str(x) for x in self.items])))

    def peek(self):
        if not self.items:
            print("Stack is empty.")
            return None
        print(f"Top element: {self.items[-1]}")
        return self.items[-1]

    def minimum(self):
        if not self.items:
            print("Stack is empty.")
            return None
        m = min(self.items)
        print(f"Minimum in stack: {m}")
        return m

    def maximum(self):
        if not self.items:
            print("Stack is empty.")
            return None
        M = max(self.items)
        print(f"Maximum in stack: {M}")
        return M

# -----------------------
# Queue (linked-list based)
# -----------------------
class QueueNode:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None

    def enqueue(self, data):
        node = QueueNode(data)
        if self.rear is None:
            self.front = self.rear = node
        else:
            self.rear.next = node
            self.rear = node
        print(f"Enqueued '{data}' to queue.")

    def dequeue(self):
        if self.front is None:
            print("Queue is empty. Nothing to dequeue.")
            return None
        val = self.front.data
        self.front = self.front.next
        if self.front is None:
            self.rear = None
        print(f"Dequeued '{val}' from queue.")
        return val

    def peek(self):
        if self.front is None:
            print("Queue is empty.")
            return None
        print(f"Front element: {self.front.data}")
        return self.front.data

    def display(self):
        if self.front is None:
            print("Queue is empty.")
            return
        temp = self.front
        out = []
        while temp:
            out.append(str(temp.data))
            temp = temp.next
        print("Front -> " + " -> ".join(out) + " -> None")

# -----------------------
# Circular Queue (array-based)
# -----------------------
class CircularQueue:
    def __init__(self, capacity):
        self.capacity = max(1, capacity)
        self.arr = [None] * self.capacity
        self.front = 0
        self.size = 0

    def is_full(self):
        return self.size == self.capacity

    def is_empty(self):
        return self.size == 0

    def enqueue(self, data):
        if self.is_full():
            print("Circular Queue is full. Cannot enqueue.")
            return False
        idx = (self.front + self.size) % self.capacity
        self.arr[idx] = data
        self.size += 1
        print(f"Enqueued '{data}' to circular queue.")
        return True

    def dequeue(self):
        if self.is_empty():
            print("Circular Queue is empty. Nothing to dequeue.")
            return None
        val = self.arr[self.front]
        self.arr[self.front] = None
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        print(f"Dequeued '{val}' from circular queue.")
        return val

    def display(self):
        if self.is_empty():
            print("Circular queue is empty.")
            return
        out = []
        for i in range(self.size):
            out.append(str(self.arr[(self.front + i) % self.capacity]))
        print("CircularQueue: " + " | ".join(out))

# -----------------------
# Deque (double-ended queue) - implemented with nodes and head/tail references
# -----------------------
class Deque:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_front(self, data):
        node = Node(data)
        if self.head is None:
            self.head = self.tail = node
        else:
            node.next = self.head
            self.head = node
        print(f"Inserted '{data}' at front of deque.")

    def insert_rear(self, data):
        node = Node(data)
        if self.tail is None:
            self.head = self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        print(f"Inserted '{data}' at rear of deque.")

    def delete_front(self):
        if self.head is None:
            print("Deque is empty. Nothing to delete from front.")
            return None
        val = self.head.data
        self.head = self.head.next
        if self.head is None:
            self.tail = None
        print(f"Deleted '{val}' from front of deque.")
        return val

    def delete_rear(self):
        if self.tail is None:
            print("Deque is empty. Nothing to delete from rear.")
            return None
        if self.head == self.tail:
            val = self.tail.data
            self.head = self.tail = None
            print(f"Deleted '{val}' (only element) from rear of deque.")
            return val
        # find second last
        temp = self.head
        while temp.next != self.tail:
            temp = temp.next
        val = self.tail.data
        temp.next = None
        self.tail = temp
        print(f"Deleted '{val}' from rear of deque.")
        return val

    def display(self):
        if self.head is None:
            print("Deque is empty.")
            return
        temp = self.head
        out = []
        while temp:
            out.append(str(temp.data))
            temp = temp.next
        print("Front -> " + " -> ".join(out) + " -> Rear")

# -----------------------
# Interactive menus
# -----------------------
def input_nonempty(prompt):
    while True:
        v = input(prompt)
        if v.strip() == "":
            print("Input cannot be empty. Try again.")
        else:
            return v

def linked_list_menu():
    ll = SinglyLinkedList()
    other_ll = SinglyLinkedList()  # for merge tests if user wants
    while True:
        print("\n--- Singly Linked List Menu ---")
        print("1. Insert at beginning")
        print("2. Insert at end")
        print("3. Insert at position")
        print("4. Delete at beginning")
        print("5. Delete at end")
        print("6. Delete at position")
        print("7. Display")
        print("8. Search")
        print("9. Length")
        print("10. Sort")
        print("11. Merge another list into this")
        print("12. Create/Fill another list (for merge)")
        print("13. Back to main menu")
        ch = input("Choice (1-13): ").strip()
        if ch == '1':
            data = input_nonempty("Data to insert at beginning: ")
            ll.insert_at_beginning(data)
        elif ch == '2':
            data = input_nonempty("Data to insert at end: ")
            ll.insert_at_end(data)
        elif ch == '3':
            pos = input_nonempty("Position (1-based): ")
            try:
                pos_i = int(pos)
            except:
                print("Position must be an integer.")
                continue
            data = input_nonempty("Data to insert: ")
            ll.insert_at_position(pos_i, data)
        elif ch == '4':
            ll.delete_at_beginning()
        elif ch == '5':
            ll.delete_at_end()
        elif ch == '6':
            pos = input_nonempty("Position (1-based) to delete: ")
            try:
                pos_i = int(pos)
            except:
                print("Position must be an integer.")
                continue
            ll.delete_at_position(pos_i)
        elif ch == '7':
            ll.display()
        elif ch == '8':
            key = input_nonempty("Value to search: ")
            ll.search(key)
        elif ch == '9':
            ll.length()
        elif ch == '10':
            ll.sort()
        elif ch == '11':
            print("Merging other list into current list (copies nodes).")
            ll.merge(other_ll)
        elif ch == '12':
            print("Fill the 'other' list for merge. Existing content will remain; you can add multiple items.")
            while True:
                v = input("Enter value to add to OTHER list (blank to stop): ")
                if v == "":
                    break
                other_ll.insert_at_end(v)
            print("Other list now:")
            other_ll.display()
        elif ch == '13':
            break
        else:
            print("Invalid choice. Try again.")

def stack_menu():
    st = Stack()
    while True:
        print("\n--- Stack Menu ---")
        print("1. Push")
        print("2. Pop")
        print("3. Display")
        print("4. Peek (top)")
        print("5. Min")
        print("6. Max")
        print("7. Back to main menu")
        ch = input("Choice (1-7): ").strip()
        if ch == '1':
            data = input_nonempty("Value to push: ")
            st.push(data)
        elif ch == '2':
            st.pop()
        elif ch == '3':
            st.display()
        elif ch == '4':
            st.peek()
        elif ch == '5':
            st.minimum()
        elif ch == '6':
            st.maximum()
        elif ch == '7':
            break
        else:
            print("Invalid choice. Try again.")

def queue_menu():
    q = Queue()
    while True:
        print("\n--- Queue Menu ---")
        print("1. Enqueue")
        print("2. Dequeue")
        print("3. Display")
        print("4. Peek (front)")
        print("5. Back to main menu")
        ch = input("Choice (1-5): ").strip()
        if ch == '1':
            val = input_nonempty("Value to enqueue: ")
            q.enqueue(val)
        elif ch == '2':
            q.dequeue()
        elif ch == '3':
            q.display()
        elif ch == '4':
            q.peek()
        elif ch == '5':
            break
        else:
            print("Invalid choice. Try again.")

def circular_queue_menu():
    cap = None
    cq = None
    while True:
        print("\n--- Circular Queue Menu ---")
        print("1. Create circular queue (set capacity)")
        print("2. Enqueue")
        print("3. Dequeue")
        print("4. Display")
        print("5. Back to main menu")
        ch = input("Choice (1-5): ").strip()
        if ch == '1':
            s = input_nonempty("Enter capacity (integer > 0): ")
            try:
                cap = int(s)
                if cap <= 0:
                    raise ValueError
            except:
                print("Invalid capacity.")
                cap = None
                continue
            cq = CircularQueue(cap)
            print(f"Circular queue with capacity {cap} created.")
        elif ch == '2':
            if cq is None:
                print("Create the circular queue first (option 1).")
            else:
                val = input_nonempty("Value to enqueue: ")
                cq.enqueue(val)
        elif ch == '3':
            if cq is None:
                print("Create the circular queue first (option 1).")
            else:
                cq.dequeue()
        elif ch == '4':
            if cq is None:
                print("Create the circular queue first (option 1).")
            else:
                cq.display()
        elif ch == '5':
            break
        else:
            print("Invalid choice. Try again.")

def deque_menu():
    dq = Deque()
    while True:
        print("\n--- Deque (double-ended queue) Menu ---")
        print("1. Insert front")
        print("2. Insert rear")
        print("3. Delete front")
        print("4. Delete rear")
        print("5. Display")
        print("6. Back to main menu")
        ch = input("Choice (1-6): ").strip()
        if ch == '1':
            val = input_nonempty("Value to insert at front: ")
            dq.insert_front(val)
        elif ch == '2':
            val = input_nonempty("Value to insert at rear: ")
            dq.insert_rear(val)
        elif ch == '3':
            dq.delete_front()
        elif ch == '4':
            dq.delete_rear()
        elif ch == '5':
            dq.display()
        elif ch == '6':
            break
        else:
            print("Invalid choice. Try again.")

def main_menu():
    print("Welcome! This program includes Singly Linked List, Stack, Queue, Circular Queue, and Deque.")
    while True:
        print("\n=== Main Menu ===")
        print("1. Singly Linked List")
        print("2. Stack")
        print("3. Queue")
        print("4. Circular Queue")
        print("5. Deque (double-ended queue)")
        print("6. Exit")
        choice = input("Enter choice (1-6): ").strip()
        if choice == '1':
            linked_list_menu()
        elif choice == '2':
            stack_menu()
        elif choice == '3':
            queue_menu()
        elif choice == '4':
            circular_queue_menu()
        elif choice == '5':
            deque_menu()
        elif choice == '6':
            print("Goodbye!")
            break
        else:
            print("Invalid choice. Try again.")

if __name__ == "__main__":
    main_menu()
